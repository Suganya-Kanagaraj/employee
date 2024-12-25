package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmployeeService;
import com.Exceptions.AgeException;
import com.Exceptions.NameException;





@RestController
@RequestMapping(value="/Employee")
public class EmployeeController {
@Autowired
EmployeeService ss;

@PostMapping(value="/post")
public String post (@RequestBody Employee s) {
	return ss.post(s);
}

@PostMapping(value="/list")
public String list (@RequestBody List<Employee> se) {
	return ss.list(se);
}
@GetMapping(value="/getAll")
public List<Employee>getall(){
	return ss.getall();
}
@GetMapping(value="/getId/{id}")
public Employee getid(@PathVariable int id){
	return ss.getid(id);
}
@DeleteMapping(value="/delete/{a}")
public String delete(@PathVariable int a){
	return ss.delete(a);
}

@PutMapping(value="/update/{a}")
public String update(@PathVariable int a,@RequestBody Employee s){
	return ss.update(a,s);
}


@GetMapping(value="/getByAge")
public List<Employee>getByAge(){
	return ss.getByAge();
}
@GetMapping(value="/getMaxSal")
public Employee getmax(){
	return ss.getmax();
}
@GetMapping(value="/getSecondMaxSal")
public Employee getsecondmax(){
	return ss.getsecondmax();
}
@GetMapping(value="/getMaxlengName")
public List<String> getmaxlength(){
	return ss.getmaxlength();
}
@GetMapping(value="/getMinAge")
public String getminage(){
	return ss.getminage();
}
@GetMapping(value="/RemoveDupAge")
public List<Integer> remvdupage(){
	return ss.remvdupage();
}
@GetMapping(value="/getAllEmps")
public List<Employee> getallemps(){
	return ss.getallemps();
}

@GetMapping(value="/getByAge/{age}")
public List<Employee> getbyage(@PathVariable int age ){
	return ss.getbyage(age);
}
@GetMapping(value="/getallByAge/{age}")
public List<Employee> getAllByAge(@PathVariable int age ){
	return ss.getAllByAge(age);
}
@GetMapping(value="/getallBySalary/{a}")
public List<Employee> getAllBySalary(@PathVariable int a ){
	return ss.getAllBySalary(a);
}

// 
@GetMapping(value="/getallByid/{a}")
public String geteee(@PathVariable int a ) throws AgeException{
	return ss.geteee(a);
}
@GetMapping(value="/getname/{a}")
public List<Employee> name(@PathVariable String a ) throws AgeException{
	return ss.name(a);
} 

@GetMapping(value="/getNamebyId/{a}")
public String getna(@PathVariable int a) throws AgeException, NameException{
	return ss.getna(a);
}

}


