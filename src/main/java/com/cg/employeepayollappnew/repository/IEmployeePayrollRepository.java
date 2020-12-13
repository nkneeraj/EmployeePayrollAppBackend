package com.cg.employeepayollappnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeepayollappnew.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Long> {
	
}
