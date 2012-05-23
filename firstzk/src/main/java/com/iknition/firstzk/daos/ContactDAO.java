package com.iknition.firstzk.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.iknition.firstzk.beans.Contact;

public class ContactDAO extends HibernateDaoSupport {
	 
    public void saveOrUpdate(Contact company) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(company);
    }
 
    public void delete(Contact company) throws DataAccessException {
        getHibernateTemplate().delete(company);
    }
 
    public Contact find(Class<Contact> clazz, Integer id) throws DataAccessException {
        Contact company = (Contact) getHibernateTemplate().load(clazz, id);
        return company;
    }
     
    public List<Contact> findAll(Class<Contact> clazz) throws DataAccessException {
        List<Contact> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
