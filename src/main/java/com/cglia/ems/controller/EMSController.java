package com.cglia.ems.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cglia.ems.model.Employee;
import com.cglia.ems.service.EmployeeService;

@Controller(value="emsController")
public class EMSController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping({"/","/home"})
	public String showHome() {
		return "Home";
	}
	@GetMapping("/add")
	public String addEmployee(HttpServletRequest request) {
		return "AddEmp";
	}
	
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee emp, HttpServletRequest request, RedirectAttributes attrs) {
		System.out.println(emp);
		//EmployeeService service=new EmployeeServiceImpl();
		Integer id=service.saveEmp(emp);
		attrs.addFlashAttribute("empid", id);
		
		
		if(id>0) {
			attrs.addFlashAttribute("successmsg","Employee saved successfully with ID:"+id);
		}else {
			attrs.addFlashAttribute("failuremsg","An error occurred. Please try again...");
		}
		
		return "redirect:/getAll";
	}
	@RequestMapping(path="/getAll", method=RequestMethod.GET)
	public String getAllEmployees(HttpServletRequest request) {
		//EmployeeService service=new EmployeeServiceImpl();
		List<Employee> empList=service.getAllEmployees();
		
		request.setAttribute("employeeList", empList);
		System.out.println(empList);
		return "ShowAllEmp";
	}
	@GetMapping("/getEmp")
	public String getEmployeeByID(@RequestParam("id") Integer id, HttpServletRequest request) {
		//EmployeeService service=new EmployeeServiceImpl();
		Employee emp=service.getEmpById(id);
		request.setAttribute("emp", emp);
		return "UpdateEmp";
		
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp, RedirectAttributes attrs) {
		//EmployeeService service=new EmployeeServiceImpl();
		int count=service.updateEmp(emp);
		attrs.addFlashAttribute("updatecount", count);
		if(count>0) {
			attrs.addFlashAttribute("updated","Employee with ID: "+emp.getId()+" is updated successfully.");
		}else {
			attrs.addFlashAttribute("notupdated","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(HttpServletRequest request, RedirectAttributes attrs) {
		Integer id=null;
		int count=0;
		if(Objects.nonNull(request.getParameter("idtodelete"))) {
			id=Integer.parseInt(request.getParameter("idtodelete"));
		}
		
		//EmployeeService service=new EmployeeServiceImpl();
		if(Objects.nonNull(id)) {
			count=service.deleteEmpById(id);
			attrs.addFlashAttribute("deletecount", count);
		}
		
		if(count>0) {
			attrs.addFlashAttribute("deleted","Employee with ID: "+id+" is deleted successfully.");
		}else {
			attrs.addFlashAttribute("notdeleted","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
}
