package com.cg.market.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.market.entities.Employee;

@Repository
public interface MarketDao extends JpaRepository<Employee, Integer> {

	@Query("from Employee where empname=:empName")
	List<Employee> existsByIdempId(@Param("empName") String empName);

}
