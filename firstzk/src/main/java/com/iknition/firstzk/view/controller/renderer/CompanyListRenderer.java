package com.iknition.firstzk.view.controller.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.iknition.firstzk.beans.Company;

public class CompanyListRenderer implements ListitemRenderer {
    public void render(Listitem item, Object data, int index) throws Exception {
        Company company = (Company) data;
        item.setValue(company);
        new Listcell(String.valueOf(company.getIdcompany())).setParent(item);
        new Listcell(company.getName()).setParent(item);
        new Listcell(company.getCountry()).setParent(item);
    }


}