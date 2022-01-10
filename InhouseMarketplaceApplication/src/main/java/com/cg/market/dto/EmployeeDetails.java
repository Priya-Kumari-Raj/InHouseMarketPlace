package com.cg.market.dto;

public class EmployeeDetails {

	private Integer empId;
	private String empName;
	private String deptName;
	private String location;

	public EmployeeDetails(Integer empId, String empName, String deptName, String location) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
	}

	public EmployeeDetails() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", location="
				+ location + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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
