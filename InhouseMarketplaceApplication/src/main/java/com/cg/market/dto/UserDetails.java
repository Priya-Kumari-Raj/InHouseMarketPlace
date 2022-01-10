package com.cg.market.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logindetails")
public class UserDetails {
	@Id
	private String username;
	private String password;
	private String userRole;

	public UserDetails(String username, String password, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	public UserDetails() {
		super();

	}

	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", password=" + password + ", userRole=" + userRole + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
