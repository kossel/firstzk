package com.iknition.firstzk.service;

import java.util.List;

import com.iknition.firstzk.beans.Company;

public interface CompanyManager {
    public boolean save(Company company);
    public boolean delete(Company company);
    public Company getCompany(Integer id);
    public List<Company> getCompanyList();
}
