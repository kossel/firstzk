package com.iknition.firstzk.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.iknition.firstzk.beans.Company;

public class CompanyDAO extends HibernateDaoSupport {
	 
    public void saveOrUpdate(Company company) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(company);
    }
 
    public void delete(Company company) throws DataAccessException {
        getHibernateTemplate().delete(company);
    }
 
    public Company find(Class<Company> clazz, Integer id) throws DataAccessException {
        Company company = (Company) getHibernateTemplate().load(clazz, id);
        return company;
    }
     
    public List<Company> findAll(Class<Company> clazz) throws DataAccessException {
        List<Company> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
