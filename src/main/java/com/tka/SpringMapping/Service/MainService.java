package com.tka.SpringMapping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.SpringMapping.Dao.MainDao;
import com.tka.SpringMapping.entity.Country;
import com.tka.SpringMapping.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addcountry(Country c) {
		
		String msg=dao.addcountry(c);
		
		if(msg==null) {
			
			msg="data is not added successfully";
		}
		
		return msg;
	}
	
	public String updatecountry(Country c) {
		
		String msg=dao.updatecountry(c);
		
		if(msg==null) {
			
			msg="data is not added successfully";
		}
		
		return msg;
		
	}
	
	public String deletecountry(int id) {
		
		String msg=dao.deletecountry(id);
		
		if(msg==null) {
			
		msg="data not delete";
		}
		
		return msg;
	}
	
	
	public String getcountry(int id) {
		
		String msg=dao.getcountry(id);
		
		if(msg==null) {
			msg="data not get";
		}
		
		return msg;
	}
	
	
	public String getallcountry() {
	
	String msg=dao.getallcountry();
		
		if(msg==null) {
			
			msg="data not get";
		}
		
		return msg;
	}
	
	public String addEmployee(Employee e) {
		
		String msg=dao.addEmployee(e);
       
		if(msg==null) {
			msg="Record is not be added";
		}
		
		return msg;
	}
	
	public String updateEmployee(Employee e) {
		
		String msg=dao.updateEmployee(e);
		
		if(msg==null) {
			msg="Employee data not updated";
		}
		return msg;
		
	}
	
	public String deleteEmployee(int id) {
		
		String msg=dao.deleteEmployee(id);
		
		if(msg==null) {
			msg="data not deleted";
		}
		
		return msg;
	}
	
	public Employee getEmployee(int id) {
		
		Employee emp=dao.getEmployee(id);
		
	    return emp;
	}
	
	public List<Employee> getallEmployee(){
		
		List<Employee> emplist=dao.getallEmployee();
		
		return emplist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
