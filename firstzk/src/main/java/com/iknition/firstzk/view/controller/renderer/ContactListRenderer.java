package com.iknition.firstzk.view.controller.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.iknition.firstzk.beans.Company;
import com.iknition.firstzk.beans.Contact;

	public class ContactListRenderer implements ListitemRenderer {
		public void render(Listitem item, Object data, int index) throws Exception {
	        Contact company = (Contact) data;
	        item.setValue(company);
	        new Listcell(String.valueOf(company.getIdcontact())).setParent(item);
	        new Listcell(company.getName()).setParent(item);
	        new Listcell(company.getEmail()).setParent(item);
	    }
}
