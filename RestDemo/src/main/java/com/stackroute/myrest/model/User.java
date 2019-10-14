package com.stackroute.myrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
@Id
private String userid;
private String userName;
private String password;
private String phone;
 User()
 {
	 super();
 }
 User(String uid,String unm,String pwd,String ph)
 {
	 super();
	 this.userid=uid;
	 this.userName=unm;
	 this.password=pwd;
	 this.phone=ph;
			 
 }


 
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
