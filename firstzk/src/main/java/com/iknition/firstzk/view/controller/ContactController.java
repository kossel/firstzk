package com.iknition.firstzk.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.iknition.firstzk.beans.Company;
import com.iknition.firstzk.beans.Contact;
import com.iknition.firstzk.service.ContactManager;
import com.iknition.firstzk.service.ServiceLocator;
import com.iknition.firstzk.view.controller.renderer.ContactListRenderer;

public class ContactController extends GenericForwardComposer {
    // data binding create/edit Contact bean
    private AnnotateDataBinder binder;
    private Contact _contact = new Contact();
    // wire component as member fields
    private Listbox contactList;
    private Grid editContactGrid;
	private Button createContact;
	private Button updateContact;
	private Button deleteContact;
    // ...   other components in ZUL
     
    // get singleton ContactManager object for CRUD operation
    private ContactManager manager = ServiceLocator.getContactManager();
     
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        binder = (AnnotateDataBinder) page.getAttribute("binder");
        EventQueues.lookup("loadContact", EventQueues.DESKTOP, true).subscribe(new EventListener() {
            public void onEvent(Event event) throws Exception {
                event.getTarget().setVisible(true);
                Company company = (Company) event.getData(); 
                contactList.setModel(setContactModel(company));
            }
        });
        contactList.setItemRenderer(new ContactListRenderer());
    }
    private ListModel setContactModel(Company company) {
        List<Contact> contacts = new ArrayList<Contact>();
        if(company.getContacts() != null)
            contacts.addAll(company.getContacts());
        return new ListModelList(contacts);
    }
    private ListModelList getModel() {
        return (ListModelList) contactList.getModel();
    }
     
    public void onClick$resetContact() {
        contactList.clearSelection();
        _contact = new Contact();
        binder.loadComponent(editContactGrid);
        createContact.setDisabled(false);
        updateContact.setDisabled(true);
        deleteContact.setDisabled(true);
    }
     
    //set selection to edit data
    public void onSelect$contactList() {
        _contact = (Contact) contactList.getSelectedItem().getValue();
        System.out.println(_contact);
        binder.loadComponent(editContactGrid);
        createContact.setDisabled(true);
        updateContact.setDisabled(false);
        deleteContact.setDisabled(false);
    }
    public void onClick$createContact(ForwardEvent event) throws InterruptedException {
        // process create
    }
    public void onClick$updateContact() throws InterruptedException {
        // process update
    }
    public void onClick$deleteContact() throws InterruptedException {
        // process delete
    }
    public Contact getContact() { return _contact; }
    public void setContact(Contact contact) { _contact = contact; }
}