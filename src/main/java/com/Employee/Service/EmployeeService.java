package com.Employee.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;
import com.Exceptions.AgeException;
import com.Exceptions.NameException;




@Service
public class EmployeeService {
@Autowired
EmployeeDao sd;

public String post (Employee s) {
	return sd.post(s);
}
public String list (List<Employee> se) {
	return sd.list(se);
}
public List<Employee>getall(){
	return sd.getall();
}
public Employee getid(int id){
	return sd.getid(id);
}
public String delete(int a){
	return sd.delete(a);
}
public String update(int a,Employee s){
	return sd.update(a,s);
}

//12/12/2024

public List <Employee>getByAge(){
	List<Employee>emps=sd.getall();
	List<Employee>empAge=new ArrayList<>();
	emps.forEach(x-> {
	if(x.getAge()>25) {
		empAge.add(x);
	}
	});
	return empAge;
}


public Employee getmax() {
	List<Employee>e=sd.getall();
	Employee max= e.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();
	return max;
}
public Employee getsecondmax() {
	List<Employee>e1=sd.getall();
	Employee max= e1.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
	return max;
}
public List<String> getmaxlength() {
	List<Employee>e1=sd.getall();
	List<String> length= e1.stream().map(x-> x.getName()).filter(x-> (x.length()>5)).collect(Collectors.toList()); 
	return length;
}
public String getminage() {
	List<Employee>e1=sd.getall();
	
		Employee length=e1.stream().min(Comparator.comparing(x-> x.getAge())).get();
	return length.getName()+","+length.getAge();
}
public List<Integer> remvdupage() {
	List<Employee>e1=sd.getall();
	List<Integer> rem= e1.stream().map(x-> x.getAge()).distinct().collect(Collectors.toList()); 
	return rem;
}

/*public List <Employee>getSecondMax(){
	List<Employee>emps=sd.getall();
	List<Employee>empAge=new ArrayList<>();
	emps.forEach(x-> {
	if(x.getAge()>25) {
		empAge.add(x);
	}
	});
	return empAge;
}*/
public List<Employee> getallemps() {
	return sd.getallemps();
	
}
public List<Employee> getbyage(int age) {
	return sd.getbyage(age);
	
}
public List<Employee> getAllByAge(int age) {
	return sd.getAllByAge(age);
	
}
public List<Employee> getAllBySalary(int a) {
	return sd.getAllBySalary(a);
	
}

//13/12/
public String geteee(int a) throws AgeException{
	
	if(sd.geteee(a).getAge()>30) {
		return sd.geteee(a)+" ";
	}
	else {
		throw new AgeException("Age Exception");
   }
	
}

public List<Employee> name(String a) throws AgeException{
	
	if(sd.name(a).isEmpty()) {
		throw new AgeException("Age Exception");	
	}
	return sd.name(a);
	
}
public String getna(int a) throws NameException, AgeException{
	String name=sd.getid(a).getName();
	if(name.startsWith("N")) {
		return name;
	}
	
    else {
		throw new NameException("Invalid name");
   }
}


// same as before ,try catch applied
/*
public String getna(int a) throws NameException{
	String name=sd.getid(a).getName();
	try {
	if(name.startsWith("N")) {
		return name;
	}
	
    else {
		throw new NameException("Invalid name");
   }
	}
	catch(NameException an){
		return("Name Exception");
	}
}
*/
}