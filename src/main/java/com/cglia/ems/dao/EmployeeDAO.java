package com.cglia.ems.dao;

import java.util.List;

import com.cglia.ems.model.Employee;

public interface EmployeeDAO {
	
	public Integer save(Employee employee);
	
	public Employee getById(Integer id);
	
	public int update(Employee employee);
	
	public int deleteById(Integer id);
	
	public List<Employee> getAll();
}
