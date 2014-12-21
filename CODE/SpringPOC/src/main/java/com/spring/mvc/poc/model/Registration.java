package com.spring.mvc.poc.model;

public class Registration {
	
	private int registerationId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private String title;
	private String titleId;
	
	public Registration() {}

	public Registration(int registerationId, String firstName, String secondName,
			String emailId, String mobileNumber, String titleId,String title) {
		super();
		this.registerationId = registerationId;
		this.firstName = firstName;
		this.lastName = secondName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.titleId = titleId;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public int getRegisterationId() {
		return registerationId;
	}

	public void setRegisterationId(int registerationId) {
		this.registerationId = registerationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
