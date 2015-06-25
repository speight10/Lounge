package com.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contact {

	@NotNull
	@Size (min=2, max =35)
	private String name;
	@NotNull
	@Size (min=2, max =35)
	private String lname;
	@NotNull
	private String phone;
	@NotNull
	private String email;
	
	private String Message;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
