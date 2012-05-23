package com.iknition.firstzk.view.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.iknition.firstzk.beans.Company;
import com.iknition.firstzk.service.CompanyManager;
import com.iknition.firstzk.service.ServiceLocator;
import com.iknition.firstzk.view.controller.renderer.CompanyListRenderer;

public class CompanyController extends GenericForwardComposer {
    // data binding create/edit Company bean
    private AnnotateDataBinder binder;
    private Company _company = new Company();
    // wire component as member fields
    private Listbox companyList;
    // other component in ZUL file
 
    // get singleton CompanyManager object for CRUD operation
    private CompanyManager manager = ServiceLocator.getCompanyManager();
     
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        binder = (AnnotateDataBinder) page.getAttribute("binder");
        companyList.setModel(new ListModelList(manager.getCompanyList()));
        companyList.setItemRenderer(new CompanyListRenderer());
    }
     
    public void onClick$resetCompany() {
        // process reset view
    }
         
    //set selection to edit data
    public void onSelect$companyList() {
        _company = (Company) companyList.getSelectedItem().getValue();
        binder.loadComponent(editCompanyGrid);
        createCompany.setDisabled(true);
        updateCompany.setDisabled(false);
        deleteCompany.setDisabled(false);
        // used for Hibernate lazy-loading
        _company = (Company) ServiceLocator.getHibernateSession().merge(_company);
        Event event = new Event("onLoad", page.getFellow("contactDiv"), _company);
        EventQueues.lookup("loadContact", EventQueues.DESKTOP, true).publish(event);
    }   
     
    public void onClick$createCompany() throws InterruptedException {
        // process create
    }
    public void onClick$updateCompany() throws InterruptedException {
        // process update
    }
    public void onClick$deleteCompany() throws InterruptedException {
        // process delete
    }
    private ListModelList getModel() {
        return (ListModelList) companyList.getModel();
    }
    public Company getCompany() {   return _company; }
    public void setCompany(Company company) { _company = company; }
}