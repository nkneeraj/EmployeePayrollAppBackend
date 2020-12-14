package com.cg.employeepayollappnew.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;
import com.cg.employeepayollappnew.exception.EmployeeException;
import com.cg.employeepayollappnew.model.Employee;
import com.cg.employeepayollappnew.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;

	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee emp = new Employee(employeePayrollDTO);
		return employeePayrollRepo.save(emp);
	}

	@Override
	public Employee getEmployeeData(long empId) throws EmployeeException {
		return employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid User id"));
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		return employeePayrollRepo.findAll();
	}

	@Override
	public Employee updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		if (employeePayrollDTO.name != null) {
			emp.setName(employeePayrollDTO.name);
		}
		if (employeePayrollDTO.salary != 0.0) {
			emp.setSalary(employeePayrollDTO.salary);
		}
		employeePayrollRepo.save(emp);
		return emp;
	}

	@Override
	public Employee deleteEmployeeById(long empId) throws EmployeeException {
		Employee emp = employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid User id"));
		if (emp == null)
			return null;
		Employee emp1 = emp;
		employeePayrollRepo.deleteById(empId);
		return emp1;
	}
}
