package com.cg.employeepayollappnew.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;
import com.cg.employeepayollappnew.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Optional<Employee> getEmployeeData(long empID);
}
