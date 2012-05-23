package com.iknition.firstzk.service;

import java.util.List;

import com.iknition.firstzk.beans.Contact;

public interface ContactManager {
    public boolean save(Contact company);
    public boolean delete(Contact company);
    public Contact getContact(Integer id);
    public List<Contact> getContactList();
}
