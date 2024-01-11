package com.example.demo.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private int noOfPost;
	
	private String qualification;
	
	private String experience;
	
	private String lastDateToApply;
	
	private String companyName;
	
	@CreatedDate
	private Instant createDate;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private JobAddress address;
	
	public Jobs() {
		// TODO Auto-generated constructor stub
	}
	
	public Jobs(int id, String title, int noOfPost, String qualification, String experience, String lastDateToApply,
			String companyName, Instant createDate, JobAddress address) {
		super();
		this.id = id;
		this.title = title;
		this.noOfPost = noOfPost;
		this.qualification = qualification;
		this.experience = experience;
		this.lastDateToApply = lastDateToApply;
		this.companyName = companyName;
		this.createDate = createDate;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNoOfPost() {
		return noOfPost;
	}

	public void setNoOfPost(int noOfPost) {
		this.noOfPost = noOfPost;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(String lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public JobAddress getAddress() {
		return address;
	}

	public void setAddress(JobAddress address) {
		this.address = address;
	}

	
	

}
