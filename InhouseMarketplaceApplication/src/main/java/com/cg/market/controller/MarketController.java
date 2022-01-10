package com.cg.market.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.market.dto.CreateEmployeeRequest;
import com.cg.market.dto.CreateOfferRequest;
import com.cg.market.dto.CreateProductRequest;
import com.cg.market.dto.CreateProposalRequest;
import com.cg.market.dto.CreateRequirementRequest;
import com.cg.market.dto.EmployeeDetails;
import com.cg.market.dto.OfferDetails;
import com.cg.market.dto.ProductDetails;
import com.cg.market.dto.ProposalDetails;
import com.cg.market.dto.RequirementDetails;
import com.cg.market.dto.UpdateEmployeeRequest;
import com.cg.market.dto.UpdateOfferRequest;
import com.cg.market.dto.UpdateProductRequest;
import com.cg.market.dto.UpdateProposalRequest;
import com.cg.market.dto.UpdateRequirementRequest;
import com.cg.market.dto.UserDetails;
import com.cg.market.entities.Employee;
import com.cg.market.entities.Offer;
import com.cg.market.entities.Product;
import com.cg.market.entities.Proposal;
import com.cg.market.entities.Requirement;
import com.cg.market.exception.AuthorizationException;
import com.cg.market.exception.NotLoggedInException;
import com.cg.market.service.MarketService;
import com.cg.market.service.UserRegister;
import com.cg.market.util.EmployeeUtil;
import com.cg.market.util.OfferUtil;
import com.cg.market.util.ProductUtil;
import com.cg.market.util.ProposalUtil;
import com.cg.market.util.RequirementUtil;

@RestController
@RequestMapping("/market")
@Validated
public class MarketController {

	@Autowired
	private MarketService mService;
	@Autowired
	private EmployeeUtil empUtil;
	@Autowired
	private ProductUtil prodUtil;
	@Autowired
	private ProposalUtil propUtil;
	@Autowired
	private OfferUtil offUtil;
	@Autowired
	private RequirementUtil reqUtil;
	@Autowired
	private UserRegister eRegister;

	@GetMapping("/by/empid/{empid}")
	public EmployeeDetails fetchEmployee(@PathVariable("empid") Integer empId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("employee fetch id:" + empId);
		Employee emp = mService.findById(empId);
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("employee/add")
	public EmployeeDetails addEmployee(@RequestBody @Valid CreateEmployeeRequest requestData,
		HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println(session);
		String role = (String) request.getSession().getAttribute("role");
		System.out.println(role);
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
	}
		EmployeeDetails details=null;
		if(role.equalsIgnoreCase("admin")) {
		System.out.println("req data: " + requestData);
		Employee emp = new Employee(requestData.getEmpName(), requestData.getDeptName(), requestData.getLocation());
		System.out.println("Emoloyee came: " + emp);
		emp = mService.register(emp);
		details = empUtil.toDetails(emp);
		}else {
			throw new AuthorizationException("Please login as ADMIN"); 
		}
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("employee/update")
	public EmployeeDetails updateEmployee(@RequestBody @Valid UpdateEmployeeRequest updateData,
			HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println(session);
		String role = (String) request.getSession().getAttribute("role");
		System.out.println(role);
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
	}
		EmployeeDetails details=null;
		
		if(role.equalsIgnoreCase("admin")) {
			
		System.out.println("update data: " + updateData);
		Employee emp = new Employee(updateData.getEmpId(), updateData.getEmpName(), updateData.getDeptName(),
				updateData.getLocation());
		System.out.println("Employee updated:" + emp);
		emp = mService.update(emp);
		details = empUtil.toDetails(emp);
		}else{
			throw new AuthorizationException("Please login as ADMIN"); 
		}
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("employee/delete/{empid}")
	public EmployeeDetails deleteEmployee(@PathVariable("empid") Integer empId, HttpServletRequest request) {

		HttpSession session=request.getSession();
		System.out.println(session);
		String role = (String) request.getSession().getAttribute("role");
		System.out.println(role);
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
	}
		EmployeeDetails details=null;
		
		if(role.equalsIgnoreCase("admin")) {
		System.out.println("delete data: " + empId);
		Employee emp = mService.deleteById1(empId);
		details = empUtil.toDetails(emp);
		}else{
			throw new AuthorizationException("Please login as ADMIN"); 
		}
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("product/add")
	public ProductDetails addProduct(@RequestBody @Valid CreateProductRequest requestData, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Req data: " + requestData);
		Product prod = new Product(requestData.getTitle(), requestData.getDescription(), requestData.getCategory(),
				requestData.getPrice(), requestData.getDate(), requestData.getEmp());
		System.out.println("Product came: " + prod);
		prod = mService.register(prod);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@GetMapping("/by/prodid/{prodid}")
	public ProductDetails fetchProduct(@PathVariable("prodid") Integer prodId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Product fetch id:" + prodId);
		Product prod = mService.findById1(prodId);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("product/update")
	public ProductDetails updateProduct(@RequestBody @Valid UpdateProductRequest updateData,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("update data: " + updateData);
		Product prod = new Product(updateData.getProdId(), updateData.getTitle(), updateData.getDescription(),
				updateData.getCategory(), updateData.getPrice(), updateData.getDate(), updateData.getEmp());
		System.out.println("Product updated:" + prod);
		prod = mService.update(prod);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@GetMapping("product/getall")
	public List<ProductDetails> fetchAllProduct(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		List<Product> products = mService.findAllProduct();
		List<ProductDetails> response = prodUtil.toDetails(products);
		return response;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("product/delete/{prodid}")
	public ProductDetails deleteProduct(@PathVariable("prodid") Integer prodId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("delete data: " + prodId);
		Product prod = mService.deleteById(prodId);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("proposal/add")
	public ProposalDetails addProposal(@RequestBody @Valid CreateProposalRequest requestData,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Req data: " + requestData);
		Proposal prop = new Proposal(requestData.getPropId(), requestData.getProposal(), requestData.getAmount(),
				requestData.getProposalDate(), requestData.isAccepted(), requestData.getEmp(), requestData.getProd());
		System.out.println("Proposal came: " + prop);
		prop = mService.register(prop);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@GetMapping("/by/propid/{propid}")
	public ProposalDetails fetchProposal(@PathVariable("propid") Integer propId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Proposal fetch id:" + propId);
		Proposal prop = mService.findById2(propId);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("proposal/delete/{propid}")
	public ProposalDetails deleteProposal(@PathVariable("propid") Integer propId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("delete data: " + propId);
		Proposal prop = mService.deleteById2(propId);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("proposal/update")
	public ProposalDetails updateProposal(@RequestBody @Valid UpdateProposalRequest updateData,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("update data: " + updateData);
		Proposal prop = new Proposal(updateData.getPropId(), updateData.getProposal(), updateData.getAmount(),
				updateData.getProposalDate(), updateData.isAccepted(), updateData.getEmp(), updateData.getProd());
		System.out.println("Proposal updated:" + prop);
		prop = mService.update(prop);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@GetMapping("proposal/getall")
	public List<ProposalDetails> fetchAllProposal(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		List<Proposal> proposals = mService.findAll();
		List<ProposalDetails> response = propUtil.toDetails(proposals);
		return response;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("offer/add")
	public OfferDetails addOffer(@RequestBody @Valid CreateOfferRequest requestData, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Req data: " + requestData);
		Offer off = new Offer(requestData.getOfferId(), requestData.isAvailable(), requestData.getAvailableUpto(),
				requestData.getProd());
		System.out.println("Offer came: " + off);
		off = mService.register(off);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("offer/update")
	public OfferDetails updateOffer(@RequestBody @Valid UpdateOfferRequest updateData, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("update data: " + updateData);
		Offer off = new Offer(updateData.getOfferId(), updateData.isAvailable(), updateData.getAvailableUpto(),
				updateData.getProd());
		System.out.println("Offer updated:" + off);
		off = mService.update(off);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("offer/delete/{offid}")
	public OfferDetails deleteOffer(@PathVariable("offid") Integer offId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("delete data: " + offId);
		Offer off = mService.deleteById3(offId);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}

	@GetMapping("offer/getall")
	public List<OfferDetails> fetchAllOffer(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		List<Offer> offers = mService.findAllOffer();
		List<OfferDetails> response = offUtil.toDetails(offers);
		return response;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("requirement/add")
	public RequirementDetails addRequirement(@RequestBody @Valid CreateRequirementRequest requestData,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("Req data: " + requestData);
		Requirement requ = new Requirement(requestData.getReqId(), requestData.isFulfilled(),
				requestData.getFulfilledOn(), requestData.getProd());
		System.out.println("Requirement came: " + requ);
		requ = mService.register(requ);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("requirement/update")
	public RequirementDetails updateRequirement(@RequestBody @Valid UpdateRequirementRequest updateData,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("update data: " + updateData);
		Requirement requ = new Requirement(updateData.getReqId(), updateData.isFulfilled(), updateData.getFulfilledOn(),
				updateData.getProd());
		System.out.println("Requirement updated:" + requ);
		requ = mService.update(requ);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}

	@GetMapping("requirement/getall")
	public List<RequirementDetails> fetchAllRequirement(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		List<Requirement> requirements = mService.findAllRequirement();
		List<RequirementDetails> response = reqUtil.toDetails(requirements);
		return response;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("requirement/delete/{requid}")
	public RequirementDetails deleteRequirement(@PathVariable("requid") Integer requId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		}
		System.out.println("delete data: " + requId);
		Requirement requ = mService.deleteById4(requId);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login")
	public String login(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		String role = mService.login(userDetails);
		session.setAttribute("user", userDetails.getUsername());
		session.setAttribute("role", role);
		return "You have successfully logged in as : " + role;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String name = (String) attrNames.nextElement();
			System.out.println(name);
			String uName = (String) session.getAttribute(name);
			System.out.println(uName);
			if (uName.equals(userDetails.getUsername())) {
				System.out.println("invalidating session..." + uName);
				session.invalidate();
			}
		}
		return "You have successfully logged out " + userDetails.getUsername();
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login/register")
	public String register(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		UserDetails uDetails = new UserDetails(userDetails.getUsername(), userDetails.getPassword(), userDetails.getUserRole());
		uDetails = eRegister.register(uDetails);
		return "Registration successful with Username : " + uDetails.getUsername() + ", Role-> "
				+ uDetails.getUserRole();
	}
}
