package com.cg.market.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateEmployeeRequest {
	private Integer empId;
	@NotBlank
	@Size(min = 2, max = 20)
	private String empName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String deptName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String location;

	public UpdateEmployeeRequest(@NotBlank @Size(min = 2, max = 20) String empName,
			@NotBlank @Size(min = 2, max = 20) String deptName, @NotBlank @Size(min = 2, max = 20) String location) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
	}

	public UpdateEmployeeRequest() {
		super();
	}

	@Override
	public String toString() {
		return "UpdateEmployeeRequest [empName=" + empName + ", deptName=" + deptName + ", location=" + location + "]";
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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

}
