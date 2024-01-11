package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Academics;
import com.example.demo.models.Address;
import com.example.demo.models.Employee;

import com.example.demo.services.EmployeeServices;
import com.example.demo.wrappers.ResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class EmployeeControllers {

	
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("")
	public ResponseEntity getAllUsers() {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("all users");
		wrapper.setData(this.employeeServices.getAllUser());
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity getUserById(@PathVariable int id) {
		
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("user with id "+id);
		wrapper.setData(this.employeeServices.getUserById(id));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity getUserByName(@RequestParam String name) {
		
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("user with name "+name);
		wrapper.setData(this.employeeServices.getByName(name));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}
	
	@GetMapping("/find-by-anyname")
	public ResponseEntity getUserByAnyName(@RequestParam String name) {
		
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("user with name "+name);
		wrapper.setData(this.employeeServices.getByAnyName(name));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity CreateUser(@RequestBody @Valid Employee employee) {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("user create successfully");
		wrapper.setData(this.employeeServices.createUser(employee));
		return new ResponseEntity(wrapper,HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		this.employeeServices.deleteUser(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{id}")
	public ResponseEntity updateUser(@PathVariable int id,@RequestBody Employee updatedData) {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("user updated successfully");
		wrapper.setData(this.employeeServices.updateUser(id, updatedData));
		
		return new ResponseEntity(wrapper,HttpStatus.OK);
	}
	
	@PostMapping("/{id}/address")
	public ResponseEntity addAddress(@PathVariable int id,@RequestBody Address address) {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("Address added successfully");
		wrapper.setData(this.employeeServices.addAddress(id, address));
		
		return new ResponseEntity(wrapper,HttpStatus.OK);
	}
	
	@PostMapping("/{id}/academics")
	public ResponseEntity addAcademics(@PathVariable int id,@RequestBody Academics academics) {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("Academics added successfully");
		wrapper.setData(this.employeeServices.addAcademics(id, academics));
		
		return new ResponseEntity(wrapper,HttpStatus.OK);
	}
}
