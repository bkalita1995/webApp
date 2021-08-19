package com.web2.Entity;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	@Column(name="roll_no")
	private int roll_no;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="lname")
	private String lname;

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	
	

	
}
