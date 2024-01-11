package com.example.demo.projections;

import com.example.demo.models.Academics;
import com.example.demo.models.Address;

public interface EmployeeProjection {

	public int getId();

	public String getName();

	public String getEmail();

	public Address getAddress();

	public Academics getAcademics();
}
