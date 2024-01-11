package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class JobAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String city;
	
	private String state;
	
	private String zipcode;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private Jobs jobs;

	public JobAddress() {
		// TODO Auto-generated constructor stub
	}
	
	public JobAddress(int id, String city, String state, String zipcode, Jobs jobs) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.jobs = jobs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	
	
}
