package com.cg.employeepayollappnew.services;

import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee emp = new Employee(employeePayrollDTO);
		modelMapper.map(employeePayrollDTO, emp);
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
//		modelMapper.map(employeePayrollDTO, emp);
		emp.setName(employeePayrollDTO.getName());
		emp.setBasic_pay(employeePayrollDTO.getBasic_pay());
		emp.setDepartment(employeePayrollDTO.getDepartment());
		emp.setGender(employeePayrollDTO.getGender());
		emp.setStart(employeePayrollDTO.getStartDate());
		return employeePayrollRepo.save(emp);
	}

	@Override
	public Employee deleteEmployeeById(long empId) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		employeePayrollRepo.deleteById(empId);
		return emp;
	}
}
