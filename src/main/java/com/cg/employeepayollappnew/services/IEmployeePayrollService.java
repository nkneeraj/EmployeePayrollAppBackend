package com.cg.employeepayollappnew.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;
import com.cg.employeepayollappnew.exception.EmployeeException;
import com.cg.employeepayollappnew.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Employee getEmployeeData(long empID) throws EmployeeException;

	void updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;

	void deleteEmployeeById(long empId) throws EmployeeException;
}
