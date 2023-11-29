package com.sk.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sk.entity.Employee;
import com.sk.repo.EmployeeRepository;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
	    @Autowired
	    private EmployeeRepository employeeRepository;    
	    
       //CREATE
	    
	    public Employee createEmployee(Employee employee) 
	    {
	        return employeeRepository.save(employee);
	    }
	    
	    //GET
	    
	    public List<Employee> getAllEmployees() 
	    {
	        return employeeRepository.findAll();
	    }

	    public List<Employee> getEmployeesBySalaryRange(int minSalary, int maxSalary) 
	    {
	        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
	    }

	    public Employee getEmployeeByName(String empName) 
	    {
	        return employeeRepository.findByEmpName(empName);
	    }

	    public List<String> getAllUniqueTeamNames() {
	        return employeeRepository.findAll()
	                .stream()
	                .map(Employee::getTeamName)
	                .distinct()
	                .collect(Collectors.toList());
	    }

	    // UPDATE  

	    public Employee updateEmployeeRole(Long id, String newRole) 
	    {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            employee.setRole(newRole);
	            return employeeRepository.save(employee);
	        }
	        return null; // or throw NotFoundException
	    }
	    
	    public Employee updateEmployeeSalary(Long id, int newSalary)
	    {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            employee.setSalary(newSalary);
	            return employeeRepository.save(employee);
	        }
	        return null; // or throw NotFoundException
	    }

	    public Employee updateEmployeeTeamName(Long id, String newTeamName)
	    {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            employee.setTeamName(newTeamName);
	            return employeeRepository.save(employee);
	        }
	        return null; // or throw NotFoundException
	    }

	    public Employee updateEmployeeDetails(Long id, Employee updatedEmployee)
	    {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee employee = optionalEmployee.get();
	            employee.setEmpName(updatedEmployee.getEmpName());
	            employee.setCompanyName(updatedEmployee.getCompanyName());
	            employee.setRole(updatedEmployee.getRole());
	            employee.setTeamName(updatedEmployee.getTeamName());
	            employee.setSalary(updatedEmployee.getSalary());
	            return employeeRepository.save(employee);
	        }
	        return null; // or throw NotFoundException
	    }
	    
	    // DELETE
	    
	    public void deleteEmployeeByName(String empName) {
	        employeeRepository.deleteByEmpName(empName);
	    }

	    public void deleteAllEmployees() {
	        employeeRepository.deleteAll();
	    }
	}

	

