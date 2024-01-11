package com.example.demo.projections;

import java.time.Instant;

import com.example.demo.models.JobAddress;

public interface JobProjections {

	
	public int getId();
	
	public String getTitle();
	
	public int getNoOfPost();
	
	public String getQualification();
	
	public String getExperience();
	
	public String getLastDateToApply();
	
	public String getCompanyName();
	
	public Instant getCreateDate();
	
	public JobAddress getAddress();
}
