package com.cg.employeepayollappnew.dto;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

public class EmployeePayrollDTO {
	
	public String name;
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name=name;
		this.salary=salary;
	}

	public EmployeePayrollDTO() {
		// TODO Auto-generated constructor stub
	}

}
