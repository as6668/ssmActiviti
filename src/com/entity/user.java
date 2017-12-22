package com.entity;


public class user {
 private String id;
 private String username;
 private String password;
 private String nc;
 private String approved;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getNc() {
	return nc;
}
public void setNc(String nc) {
	this.nc = nc;
}
public String getApproved() {
	return approved;
}
public void setApproved(String approved) {
	this.approved = approved;
}
public user(String id, String username, String password, String nc, String approved) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.nc = nc;
	this.approved = approved;
}
public user(String username, String password, String nc, String approved) {
	super();
	this.username = username;
	this.password = password;
	this.nc = nc;
	this.approved = approved;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}

}
