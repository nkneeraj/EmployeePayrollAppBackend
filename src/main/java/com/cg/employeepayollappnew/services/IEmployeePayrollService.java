package com.cg.employeepayollappnew.services;

import java.util.List;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;
import com.cg.employeepayollappnew.exception.EmployeeException;
import com.cg.employeepayollappnew.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Employee getEmployeeData(long empID) throws EmployeeException;

	Employee updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;

	Employee deleteEmployeeById(long empId) throws EmployeeException;

	List<Employee> getAllEmployeeData();
}
