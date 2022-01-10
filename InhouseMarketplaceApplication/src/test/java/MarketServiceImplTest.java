package com.cg.market.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.market.entites.Employee;
import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;
import com.cg.market.service.MarketService;
import com.cg.market.service.MarketServiceImpl;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(MarketServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MarketServiceImplTest {

	@Autowired
	private MarketService service;
	@Autowired
	private EntityManager em;

	@Test
	public void testFindById() {
		Employee emp = new Employee("Sachin", "Tester", "Hyderbad");
		em.persist(emp);
		Integer id = emp.getEmpId();
		Employee empFound = service.findById(id);
		assertEquals(empFound.getEmpName(), "Sachin");
		assertEquals(empFound.getDeptName(), "Tester");
		assertEquals(empFound.getLocation(), "Hyderbad");

	}

	@Test
	public void testFindById1() {
		Product prod = new Product("Bike", "Good", "Vehicle", 250000);
		em.persist(prod);
		Integer id = prod.getProdId();
		Product prodFound = service.findById1(id);
		assertEquals(prodFound.getCategory(), "Vehicle");
		assertEquals(prodFound.getDescription(), "Good");
		assertEquals(prodFound.getTitle(), "Bike");
		assertEquals(250000, 250000, 0.1);
	}

	@Test
	public void testFindById2() {
		Proposal prop = new Proposal("Plz give", 200000, true);
		em.persist(prop);
		Integer id = prop.getPropId();
		Proposal propFound = service.findById2(id);
		assertEquals(propFound.getProposal(), "Plz give");
		assertEquals(200000, 200000, 0.1);
		boolean success = propFound.getIsAccepted();
		assertTrue(success);
	}

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee("Allu", "tester", "Bangalore");
		Employee empSaved = service.register(emp);
		assertEquals(empSaved.getEmpName(), emp.getEmpName());
		assertEquals(empSaved.getDeptName(), emp.getDeptName());
		assertEquals(empSaved.getLocation(), emp.getLocation());
	}

	@Test
	public void testAddProduct() {
		Product prod = new Product("Bike", "Good", "Vehicle", 250000);
		Product prodSaved = service.register(prod);
		assertEquals(prodSaved.getTitle(), prod.getTitle());
		assertEquals(prodSaved.getDescription(), prod.getDescription());
		assertEquals(prodSaved.getCategory(), prod.getCategory());
		assertEquals(250000, 250000, 0.1);
	}

	@Test
	public void testAddProposal() {
		Proposal prop = new Proposal("Plz give", 200000, true);
		Proposal propSaved = service.register(prop);
		assertEquals(propSaved.getProposal(), prop.getProposal());
		assertEquals(200000, 200000, 0.1);
		boolean success = prop.getIsAccepted();
		assertTrue(success);
	}

	@Test
	public void testUpdateProposal() {
		Proposal prop = new Proposal("Plz give", 200000, true);
		Proposal propSaved = service.register(prop);
		prop.setAmount(300000);
		prop.setProposal("dont give");
		prop.setIsAccepted(true);
		Proposal prop1 = service.update(prop);
		assertEquals(300000, prop1.getAmount());
		assertEquals("dont give", prop1.getProposal());
		boolean success = prop1.getIsAccepted();
		assertTrue(success);
		
	}

	@Test
	public void testUpdateProduct() {
		Product prod = new Product("Bike", "very Good", "Electronics", 250);
		Product prodSaved = service.register(prod);
		prod.setTitle("comb");
		prod.setDescription("not very good");
		prod.setCategory("Vehicles");
		prod.setPrice(300000);
		Product prod1 = service.update(prod);
		assertEquals("comb", prod1.getTitle());
		assertEquals("not very good", prod1.getDescription());
		assertEquals("Vehicles", prod1.getCategory());
		assertEquals(300000, prod1.getPrice());
	}
	
	
}