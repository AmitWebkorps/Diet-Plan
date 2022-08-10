package com.healthymeal.entity;

public class User {
	private String name;
	private Integer age;
	private String email;
	private String password;
	private String role;
	private Double height;
	private Integer weight;

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name1) {
		name = name1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age1) {
		age = age1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email1) {
		email = email1;
	}
}
