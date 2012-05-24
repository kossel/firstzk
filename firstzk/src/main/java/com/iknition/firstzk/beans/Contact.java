package com.iknition.firstzk.beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table (appliesTo = "contact")
public class Contact implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idcontact;
    private Company company;
    private String name;
    private String email;
     
    public Contact() {}

    @Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getIdcontact() {
		return idcontact;
	}

	public void setIdcontact(Integer idcontact) {
		this.idcontact = idcontact;
	}

	@ManyToOne(cascade = CascadeType.ALL)
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