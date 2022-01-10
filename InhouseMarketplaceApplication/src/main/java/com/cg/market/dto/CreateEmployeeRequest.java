package com.cg.market.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateEmployeeRequest {
	@NotBlank
	@Size(min = 2, max = 20)
	private String empName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String deptName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String location;

	public CreateEmployeeRequest() {
		super();
	}

	public CreateEmployeeRequest(@NotBlank @Size(min = 2, max = 20) String empName,
			@NotBlank @Size(min = 2, max = 20) String deptName, @NotBlank @Size(min = 2, max = 20) String location) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "CreateEmployeeRequest [empName=" + empName + ", deptName=" + deptName + ", location=" + location + "]";
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
