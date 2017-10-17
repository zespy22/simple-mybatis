package com.sample.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo1.mappers.EmployeeMapper;
import com.sample.demo1.vo.Employee;

@Service
public class HRSercieImpl implements HRService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeMapper.getAllEmployees();
			if(employees.isEmpty()) {
				throw new RuntimeException("없음");
			}
			System.out.println("사원수" + employees.size());
			return employees;
	}
}
