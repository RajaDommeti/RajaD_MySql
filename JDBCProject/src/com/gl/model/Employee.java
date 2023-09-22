package com.gl.model;

public class Employee {
	private int id;
	private String name;
	private String email_id;
	private String phone_no;
	public Employee() {
	}
	public Employee(int id, String name, String email_id, String phone_no) {
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.phone_no = phone_no;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email_id=" + email_id + ", phone_no=" + phone_no + "]";
	}
	
}
