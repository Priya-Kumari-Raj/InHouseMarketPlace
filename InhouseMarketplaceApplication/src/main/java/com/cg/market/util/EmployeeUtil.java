package com.cg.market.util;

import org.springframework.stereotype.Component;

import com.cg.market.dto.EmployeeDetails;
import com.cg.market.entities.Employee;

@Component
public class EmployeeUtil {

	public EmployeeDetails toDetails(Employee emp) {

		return new EmployeeDetails(emp.getEmpId(), emp.getEmpName(), emp.getDeptName(), emp.getLocation());
	}

}
