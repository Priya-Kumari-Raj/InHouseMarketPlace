package com.cg.market.service;

import java.util.List;

import com.cg.market.dto.UserDetails;
import com.cg.market.entities.Employee;
import com.cg.market.entities.Offer;
import com.cg.market.entities.Product;
import com.cg.market.entities.Proposal;
import com.cg.market.entities.Requirement;

public interface MarketService {

	Employee findById(Integer empId);

	Employee register(Employee emp);

	Product register(Product prod);

	Product findById1(Integer prodId);

	Product deleteById(Integer prodId);

	Employee deleteById1(Integer empId);

	Proposal register(Proposal prop);

	Proposal findById2(Integer propId);

	Proposal deleteById2(Integer propId);

	List<Proposal> findAll();

	List<Product> findAllProduct();

	Offer register(Offer off);

	Offer deleteById3(Integer offId);

	List<Offer> findAllOffer();

	Requirement register(Requirement requ);

	List<Requirement> findAllRequirement();

	Requirement deleteById4(Integer requId);

	Proposal update(Proposal prop);

	Offer update(Offer off);

	Requirement update(Requirement requ);

	Product update(Product prod);

	Employee update(Employee emp);

	String login(UserDetails userDetails);

}
