package com.iknition.firstzk.beans;

import java.io.Serializable;

public class Contact implements Serializable {
    private Integer idcontact;
    private Company company;
    private String name;
    private String email;
     
    public Contact() {}

	public Integer getIdcontact() {
		return idcontact;
	}

	public void setIdcontact(Integer idcontact) {
		this.idcontact = idcontact;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

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
 
    
}