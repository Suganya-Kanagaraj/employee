package com.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	
	@Query(value="select * from employee", nativeQuery=true)
	public List <Employee> getallemps(); 
	
	@Query(value="select * from employee where age> ?", nativeQuery=true)
	public List <Employee> getbyage(int age); 
	
	@Query(value= "select a from Employee a where a.age>= :x")
	public List<Employee> getAllByAge(@Param("x")int a);
	@Query(value= "select a from Employee a where a.salary>= :x")
	public List<Employee> getAllBySalary(@Param("x")int a);
	@Query(value="select * from Employee where name like ?", nativeQuery=true)
	public List<Employee> name(String a); 
}