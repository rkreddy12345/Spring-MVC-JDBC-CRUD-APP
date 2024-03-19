package com.cglia.ems.service;

import java.util.List;

import com.cglia.ems.model.Employee;

public interface EmployeeService {
	
	public Integer saveEmp(Employee employee);

	public Employee getEmpById(Integer id);

	public int updateEmp(Employee employee);

	public int deleteEmpById(Integer id);

	public List<Employee> getAllEmployees();
}
