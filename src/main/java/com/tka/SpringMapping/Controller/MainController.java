package com.tka.SpringMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tka.SpringMapping.Service.MainService;
import com.tka.SpringMapping.entity.Country;
import com.tka.SpringMapping.entity.Employee;

import jakarta.persistence.PreUpdate;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	MainService service;
	
	
	@PostMapping("/addcountry")
	public String addcountry(@RequestBody Country c) {
		
		String msg=service.addcountry(c);
		return msg;
	}
	
	@PutMapping("/update")
	public String updateCountry(@RequestBody Country c ) {
		
		String msg=service.updatecountry(c);
		
		return msg;
	}
	
	
	@DeleteMapping("/delete")
	public String deletecountry(@RequestHeader int id) {
		
		String msg=service.deletecountry(id);
		
		return msg;
	}
	
	@GetMapping("/get")
	public String getcountry(@RequestHeader int id) {
		
		String msg=service.getcountry(id);
         
		return msg;
	}
	
	@GetMapping("/getall")
	public String getallcountry() {
		
		String msg=service.getallcountry();
		
		return msg;
	}
	
	
	@PostMapping("/addEmployee")
	public String addEmplyee(@RequestBody Employee e) {
		String msg=service.addEmployee(e);
		return msg;
	}
	
	@PutMapping("/updateEmp")
	public String updateEmployee(Employee e) {
		
		String msg=service.updateEmployee(e);
		return msg;

	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}
	
	
	@GetMapping("/getparticularEmp")
   public Employee getEmployee(@PathVariable int id) {
	   Employee emp=service.getEmployee(id);
	   
	   return emp;
   }
	
	
	public List<Employee> getallEmployee(){     //it is return type is array of object
		List<Employee> emplist=service.getallEmployee();
		return emplist;
	}
	
	
	
	
	
}
