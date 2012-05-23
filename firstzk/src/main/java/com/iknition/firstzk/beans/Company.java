package com.iknition.firstzk.beans;


import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    private Integer idcompany;
    private String name;
    private String country;
    private List<Contact> contacts;
    
    public Company() {}

    
	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public Integer getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
 
    
}