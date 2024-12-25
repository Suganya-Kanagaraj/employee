package com.Employee.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;




@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository sr;

public String post(Employee s) {
	sr.save(s);
	return "posted";
}
public String list(List<Employee> se) {
	sr.saveAll(se);
	return "Success";
}
public List<Employee>getall(){
	return sr.findAll();
	
}
public Employee getid(int id){
	return sr.findById(id).get();
}
public String delete(int a){
	sr.deleteById(a);
	return "Deleted";
}
public String update(int a,Employee s){
	sr.save(s);
	return "Updated";
}
public List<Employee> getallemps(){
	
	return sr.getallemps();
}

public List<Employee> getbyage(int age){
	
	return sr.getbyage(age);
}
public List<Employee> getAllByAge(int age){
	
	return sr.getAllByAge(age);
}
public List<Employee> getAllBySalary(int a){
	
	return sr.getAllBySalary(a);
}
public Employee geteee(int a) {
	return sr.findById(a).get();
}
/*public String name(String a){
	
	return sr.name(a);
}*/

public List<Employee> name(String a) {
	return sr.name(a);
}
}