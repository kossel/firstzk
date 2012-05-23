package com.iknition.firstzk.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.iknition.firstzk.beans.Contact;
import com.iknition.firstzk.daos.ContactDAO;

public class ContactManagerImpl implements ContactManager {
    private ContactDAO companyDAO;
 
    public ContactDAO getContactDAO() {
        return companyDAO;
    }
 
    public void setContactDAO(ContactDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
 
    @Transactional
    public boolean save(Contact company) {
        try {
            companyDAO.saveOrUpdate(company);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Contact company) {
        try {
            companyDAO.delete(company);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Contact getContact(Integer id) {
        try {
            return companyDAO.find(Contact.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Contact> getContactList() {
        try {
            return companyDAO.findAll(Contact.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}