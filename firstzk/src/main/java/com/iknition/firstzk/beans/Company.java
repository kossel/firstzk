package com.iknition.firstzk.beans;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table (appliesTo = "company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 20111130110622L;
	
	
	private Integer idcompany;
	private String name;
	private String country;
	private Set<Contact> contacts = new HashSet<Contact>();
	
	public Company() {}

	public Company(Integer idcompany, String name, String country) {
		this.idcompany = idcompany;
		this.name = name;
		this.country = country;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void addContact(Contact contact) {
        if(!contacts.contains(contact)) {
        	contacts.add(contact);
        }
        if (contact.getCompany() != this) {
        	contact.setCompany(this);
        }
    }
	
	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}
}
