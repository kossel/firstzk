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
import org.zkoss.zul.*;

public class ContactController extends GenericForwardComposer {
	
	private static final long serialVersionUID = 20111201101010L;
	private AnnotateDataBinder binder;
	private Listbox contactList;
	private Grid editContactGrid;
	private Button createContact;
	private Button updateContact;
	private Button deleteContact;
	
	private ContactManager manager = ServiceLocator.getContactManager();
	private Contact _contact = new Contact();;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = (AnnotateDataBinder) page.getAttribute("binder");
		_contact = new Contact();
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
	
	public Contact getContact() {
		return _contact;
	}
	
	public void setContact(Contact contact) {
		_contact = contact;
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
	
	//register onClick event for creating new object into list model
	public void onClick$createContact(ForwardEvent event) throws InterruptedException {
		Listbox companyList = (Listbox) self.getParent().getFellow("companyList");
		if (_contact.getName() == null && _contact.getEmail() == null) {
			Messagebox.show("no new content to add");
		} else {
			_contact.setCompany((Company) companyList.getSelectedItem().getValue());
			manager.save(_contact);
			getModel().add(_contact);
		}
	}
	
	//register onClick event for updating edited data in list model
	public void onClick$updateContact() throws InterruptedException {
		Listitem listItem = contactList.getSelectedItem();
		manager.save(_contact);
		listItem.setValue(_contact);
		int index = contactList.getSelectedIndex();
		getModel().set(index, _contact);
	}
	
	//register onClick event for removing data in list model
	public void onClick$deleteContact() throws InterruptedException {
		Messagebox.show("Are you sure to delete?", null, Messagebox.YES | Messagebox.NO, Messagebox.QUESTION, new EventListener() {
			public void onEvent(Event event) throws Exception {
				if(event.getName().equals("onYes")) {
					getModel().remove(_contact);
					manager.delete(_contact);
				}
			}
		});
	}
}
