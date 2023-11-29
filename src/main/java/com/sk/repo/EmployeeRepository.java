package com.sk.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.sk.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
    List<Employee> findBySalaryBetween(int minSalary, int maxSalary);
    Employee findByEmpName(String empName); 
    @Transactional
    void deleteByEmpName(String empName);
    @Query("SELECT DISTINCT e.teamName FROM Employee e")
	List<String> findDistinctTeamNames();
}
