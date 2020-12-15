package com.cg.employeepayollappnew.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeePayrollBeans {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
