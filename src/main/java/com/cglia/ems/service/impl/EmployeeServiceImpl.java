package com.cglia.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.ems.dao.EmployeeDAO;
import com.cglia.ems.model.Employee;
import com.cglia.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;
	public Integer saveEmp(Employee employee) {
		//EmployeeDAO dao=new EmployeeDAOImpl();
		Integer id=dao.save(employee);
		return id;
	}

	public Employee getEmpById(Integer id) {
		///EmployeeDAO dao=new EmployeeDAOImpl();
		Employee emp=dao.getById(id);
		return emp;
	}

	public int updateEmp(Employee employee) {
		//EmployeeDAO dao=new EmployeeDAOImpl();
		int count=dao.update(employee);
		return count;	
	}

	public int deleteEmpById(Integer id) {
		//EmployeeDAO dao=new EmployeeDAOImpl();
		int count=dao.deleteById(id);
		return count;
		// TODO Auto-generated method stub
		
	}

	public List<Employee> getAllEmployees() {
		//EmployeeDAO dao=new EmployeeDAOImpl();
		List<Employee> empList=dao.getAll();
		return empList;
	}

	
}
