package com.cg.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.cg.market.dao.ILoginDao;
import com.cg.market.dao.MarketDao;
import com.cg.market.dao.MarketDaoOffer;
import com.cg.market.dao.MarketDaoProduct;
import com.cg.market.dao.MarketDaoProposal;
import com.cg.market.dao.MarketDaoRequirement;
import com.cg.market.dto.UserDetails;
import com.cg.market.entities.Employee;
import com.cg.market.entities.Offer;
import com.cg.market.entities.Product;
import com.cg.market.entities.Proposal;
import com.cg.market.entities.Requirement;
import com.cg.market.exception.AuthenticationFailedException;
import com.cg.market.exception.EmployeeAlreadyExistsException;
import com.cg.market.exception.EmployeeNotFoundException;
import com.cg.market.exception.OfferAlreadyExistsException;
import com.cg.market.exception.OfferNotFoundException;
import com.cg.market.exception.ProductAlreadyExistsException;
import com.cg.market.exception.ProductNotFoundException;
import com.cg.market.exception.ProposalAlreadyExistsException;
import com.cg.market.exception.ProposalNotFoundException;
import com.cg.market.exception.RequirementNotFoundException;
import com.cg.market.exception.RequirementAlreadyExistsException;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {
	@Autowired
	private MarketDao dao;
	@Autowired
	private MarketDaoProduct pDao;
	@Autowired
	private MarketDaoProposal prDao;
	@Autowired
	private MarketDaoOffer oDao;
	@Autowired
	private MarketDaoRequirement rDao;
	@Autowired
	private ILoginDao lDao;
	private Logger logger = Logger.getLogger(MarketServiceImpl.class);

	@Override
	public Employee findById(Integer empId) {
		Optional<Employee> optional = dao.findById(empId);
		if (!optional.isPresent()) {
			System.out.println("***error***");
			logger.error("EmployeeNotFound" + empId);
			throw new EmployeeNotFoundException("Employee not found for id=" + empId);
		}
		Employee emp = optional.get();
		logger.info("Employee Found" + emp);
		System.out.println("employee:" + emp);
		return emp;
	}

	@Override
	public Employee register(Employee emp) {
		List<Employee> empList = dao.existsByempName(emp.getEmpName());
		if (empList.size() > 1) {
			logger.error("Employee already exsits");
			throw new EmployeeAlreadyExistsException("Employee already exists ");
		}
		emp = dao.save(emp);
		logger.info("Returning saved Employee:" + emp);
		System.out.println("Returning saved Employee: " + emp);
		return emp;
	}

	@Override
	public Product register(Product prod) {
		boolean exists = prod.getProdId() != null && pDao.existsById(prod.getProdId());
		if (exists) {
			logger.error("Product already exsits for id :" + prod.getProdId());
			throw new ProductAlreadyExistsException("Product already exists for id=" + prod.getProdId());
		}
		prod = pDao.save(prod);
		logger.info("Returning saved product : " + prod);
		System.out.println("Returning saved product: " + prod);
		return prod;
	}

	@Override
	public Product findById1(Integer prodId) {
		Optional<Product> opt = pDao.findById(prodId);
		if (!opt.isPresent()) {
			logger.error("Product not found for id" + prodId);
			System.out.println("***error***");
			throw new ProductNotFoundException("Product not found for id= " + prodId);
		}
		Product prod = opt.get();
		logger.info("Product Found" + prod);
		System.out.println("Product: " + prod);
		return prod;
	}

	@Override
	public Product deleteById(Integer prodId) {
		Optional<Product> opt = pDao.findById(prodId);
		if (!opt.isPresent()) {
			logger.error("No product found for Id: " + prodId);
			throw new ProductNotFoundException("No Product Found for Id :" + prodId);
		}
		Product prod = opt.get();
		pDao.deleteById(prodId);
		logger.info("Deleting the product: " + prod);
		System.out.println("Deleting the product:" + prod);
		return prod;
	}

	@Override
	public Employee deleteById1(Integer empId) {
		Optional<Employee> opt = dao.findById(empId);
		if (!opt.isPresent()) {
			logger.error("No employee found for Id: " + empId);
			throw new EmployeeNotFoundException("No Employee Found for Id :" + empId);
		}
		Employee emp = opt.get();
		dao.deleteById(empId);
		logger.info("Delelting the employee: " + emp);
		System.out.println("Deleting the employee:" + emp);
		return emp;
	}

	@Override
	public Proposal register(Proposal prop) {
		boolean exists = prop.getPropId() != null && pDao.existsById(prop.getPropId());
		if (exists) {
			logger.error("Proposal already exists for Id: " + prop.getPropId());
			throw new ProposalAlreadyExistsException("Proposal already exists for id=" + prop.getPropId());
		}
		prop = prDao.save(prop);
		logger.info("Proposal saved: " + prop);
		System.out.println("Returning saved Proposal: " + prop);
		return prop;

	}

	@Override
	public Proposal findById2(Integer propId) {
		Optional<Proposal> opt = prDao.findById(propId);
		if (!opt.isPresent()) {
			System.out.println("***error***");
			logger.error("Proposal not found for Id: " + propId);
			throw new ProposalNotFoundException("proposal not found for id=" + propId);
		}
		Proposal prop = opt.get();
		logger.info("Proposal : " + prop);
		System.out.println("Proposal: " + prop);
		return prop;
	}

	@Override
	public Proposal deleteById2(Integer propId) {
		Optional<Proposal> opt = prDao.findById(propId);
		if (!opt.isPresent()) {
			logger.error("Proposal not found for Id: " + propId);
			throw new ProposalNotFoundException("No Proposal Found for Id :" + propId);
		}
		Proposal prop = opt.get();
		prDao.deleteById(propId);
		logger.info("Deleting the proposal: " + prop);
		System.out.println("Deleting the proposal:" + prop);
		return prop;
	}

	@Override
	public List<Proposal> findAll() {
		System.out.println(prDao.getClass().getName());
		List<Proposal> list = prDao.findAll();
		return list;

	}

	@Override
	public List<Product> findAllProduct() {
		System.out.println(pDao.getClass().getName());
		List<Product> list = pDao.findAll();
		return list;

	}

	@Override
	public Offer register(Offer off) {
		boolean exists = off.getOfferId() != null && oDao.existsById(off.getOfferId());
		if (exists) {
			logger.error("Offer already exists for Id : " + off.getOfferId());
			throw new OfferAlreadyExistsException("Offer already exists for id=" + off.getOfferId());
		}
		off = oDao.save(off);
		logger.info("Returning saved offer: " + off);
		System.out.println("Returning saved offer: " + off);
		return off;
	}

	@Override
	public Offer deleteById3(Integer offId) {
		Optional<Offer> opt = oDao.findById(offId);
		if (!opt.isPresent()) {
			logger.error("No Offer found for Id : " + offId);
			throw new OfferNotFoundException("No Offer Found for Id :" + offId);
		}
		Offer off = opt.get();
		oDao.deleteById(offId);
		logger.info("Delelting the offer: " + off);
		System.out.println("Deleting the Offer:" + off);
		return off;
	}

	@Override
	public List<Offer> findAllOffer() {
		System.out.println(oDao.getClass().getName());
		List<Offer> list = oDao.findAll();
		return list;
	}

	@Override
	public Requirement register(Requirement requ) {
		boolean exists = requ.getReqId() != null && rDao.existsById(requ.getReqId());
		if (exists) {
			logger.error("Requirement already exists for Id : " + requ.getReqId());
			throw new RequirementAlreadyExistsException("Requirement already exists for id=" + requ.getReqId());
		}
		requ = rDao.save(requ);
		logger.info("Returning the Requirement: " + requ);
		System.out.println("Returning saved Requirement: " + requ);
		return requ;

	}

	@Override
	public List<Requirement> findAllRequirement() {
		System.out.println(rDao.getClass().getName());
		List<Requirement> list = rDao.findAll();
		return list;
	}

	@Override
	public Requirement deleteById4(Integer requId) {
		Optional<Requirement> opt = rDao.findById(requId);
		if (!opt.isPresent()) {
			logger.error("Requirement not found for Id: " + requId);
			throw new RequirementNotFoundException("No Requirement Found for Id :" + requId);
		}
		Requirement requ = opt.get();
		rDao.deleteById(requId);
		logger.info("Deleting the requirement: " + requ);
		System.out.println("Deleting the Requirement:" + requ);
		return requ;
	}

	@Override
	public Proposal update(Proposal prop) {
		boolean isAccepted = prop.getIsAccepted();
		if (isAccepted) {
			prDao.save(prop);
		} else {
			logger.error("Proposal has not been accepted");
			throw new ProposalNotFoundException("Proposal has not been accepted");
		}
		return prop;
	}

	@Override
	public Offer update(Offer off) {
		boolean isAvailable = off.isAvailable();
		if (!isAvailable) {
			oDao.save(off);
		} else {
			logger.error("Offer has not been accepted");
			throw new OfferNotFoundException("Offer has not been accepted");
		}
		return off;
	}

	@Override
	public Requirement update(Requirement requ) {
		boolean isFulfilled = requ.isFulfilled();
		if (isFulfilled) {
			rDao.save(requ);
		} else {
			logger.error("Requirement has not been accepted");
			throw new RequirementNotFoundException("Requirement has not been updated");
		}
		return requ;
	}

	@Override
	public Product update(Product prod) {
		pDao.save(prod);
		return prod;
	}

	@Override
	public Employee update(Employee emp) {
		dao.save(emp);
		return emp;
	}

	@Override
	public String login(UserDetails userDetails) {
		String role = "";
		Optional<UserDetails> op = lDao.findById(userDetails.getUsername());
		if (!op.isPresent()) {
			logger.error("No user found for Id: " + userDetails.getUsername());
			throw new AuthenticationFailedException("No User found for username=" + userDetails.getUsername());
		}
		UserDetails uDetails = op.get();
		if (!userDetails.getPassword().equals(uDetails.getPassword())) {
			logger.error("Authentication failed fror username: " + userDetails.getUsername());
			throw new AuthenticationFailedException(
					"Authentification failed for username=" + userDetails.getUsername());
		}
		role = uDetails.getUserRole();
		return role;
	}

}
