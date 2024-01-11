package com.example.demo.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 4, max = 10)
	@Column(name = "username", updatable = true)
	private String name;
	@Email(message = "please enter valid email address.")
	@NotBlank
	@NotNull
	@Column(nullable = false, unique = true)
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 6)
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "password must be character or number.")
	private String password;
	
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "academics_id")
	private Academics academics;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Academics getAcademics() {
		return academics;
	}

	public void setAcademics(Academics academics) {
		this.academics = academics;
	}

	public Employee() {
		
	}
	
	public Employee(int id, @Size(min = 4, max = 10) String name,
			@Email(message = "please enter valid email address.") @NotBlank @NotNull String email,
			@NotNull @NotBlank @Size(min = 6) @Pattern(regexp = "[a-zA-Z0-9]+", message = "password must be character or number.") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
