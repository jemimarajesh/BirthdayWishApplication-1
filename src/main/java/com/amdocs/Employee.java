package com.amdocs;

public class Employee {
	
	private String name;
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
	public String getTeamEmail() {
		return teamEmail;
	}
	public void setTeamEmail(String teamEmail) {
		this.teamEmail = teamEmail;
	}
	private String email;
	private String teamEmail;
	
}
