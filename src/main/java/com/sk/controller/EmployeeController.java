package com.sk.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.entity.Employee;
import com.sk.service.EmployeeService;

@RestController
@RequestMapping("/employees")
	public class EmployeeController {
	    @Autowired
	    private EmployeeService employeeService;
	    
	    // CREATE//
	    //Insert new Employee Record
	    @PostMapping("/create")
	    public Employee createEmployee(@RequestBody Employee employee) 
	    {
	        return employeeService.createEmployee(employee);
	    }
	    
	    // READ//
	    // Retrieve all the Employee Detail

	    @GetMapping("/all")
	    public List<Employee> getAllEmployees()
	    {
	        return employeeService.getAllEmployees();
	    }
        
	    //Return employees whose salary on the basis of min and max
	    @GetMapping("/salary")
	    public List<Employee> getEmployeesBySalaryRange(@RequestParam int minSalary, @RequestParam int maxSalary)
	    {
	        return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
	    }
        
	    //Return employee behalf of name
	    
	    @GetMapping("/{empName}")
	    public Employee getEmployeeByName(@PathVariable String empName) 
	    {
	        return employeeService.getEmployeeByName(empName);
	    }

	   @GetMapping("/teams")
	    public List<String> getUniqueTeamNames() 
	    {
	        return employeeService.getAllUniqueTeamNames();
	    }

	    // UPDATE//
	   
	    @PutMapping("/{id}/role")
	    public Employee updateEmployeeRole(@PathVariable Long id, @RequestParam String newRole) 
	    {
	        return employeeService.updateEmployeeRole(id, newRole);
	    }

	    @PutMapping("/{id}/salary")
	    public Employee updateEmployeeSalary(@PathVariable Long id, @RequestParam int newSalary) 
	    {
	        return employeeService.updateEmployeeSalary(id, newSalary);
	    }

	    @PutMapping("/{id}/team")
	    public Employee updateEmployeeTeamName(@PathVariable Long id, @RequestParam String newTeamName) 
	    {
	        return employeeService.updateEmployeeTeamName(id, newTeamName);
	    }

	    @PutMapping("/{id}")
	    public Employee updateEmployeeDetails(@PathVariable Long id, @RequestBody Employee updatedEmployee)
	    {
	        return employeeService.updateEmployeeDetails(id, updatedEmployee);
	    }
	    
	    //DELETE
	    
	    @DeleteMapping("/{empName}")
	    public void deleteEmployeeByName(@PathVariable String empName)
	    {
	        employeeService.deleteEmployeeByName(empName);
	    }

	    @DeleteMapping
	    public void deleteAllEmployees()
	    {
	        employeeService.deleteAllEmployees();
	    }

	}


