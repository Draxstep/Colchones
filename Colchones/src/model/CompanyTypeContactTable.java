package model;

import java.util.ArrayList;

public class CompanyTypeContactTable{
    private ArrayList<CompanyTypeContact> company_typeContacts;

    public CompanyTypeContactTable(){
        company_typeContacts= new ArrayList<>();
    }

    public void registerNewObject(CompanyTypeContact newObject){
      company_typeContacts.add(newObject);
    }

    public void deleteRegisteredObject(int objectId1, int objectId2){
        for(int i=0; i<company_typeContacts.size(); i++){
            if(company_typeContacts.get(i).getid_typeContact() == objectId1 && company_typeContacts.get(i).getid_SupplierCompany() == objectId2){
                company_typeContacts.remove(i);
                i = company_typeContacts.size();
            }
        }
    }

    public void editRegisteredObject(int objectId1, int objectId2, CompanyTypeContact newObject){
        for(int i=0;i<company_typeContacts.size(); i++){
            if(company_typeContacts.get(i).getid_typeContact() == objectId1 && company_typeContacts.get(i).getid_SupplierCompany() == objectId2){
                company_typeContacts.set(i, newObject);
                i = company_typeContacts.size();
            }
        }
    }

    public String showRegisteredObjects(){
        String info = "";
        for(int i=0;i<company_typeContacts.size(); i++){
            info += "Id del tipo de contacto: " + company_typeContacts.get(i).getid_typeContact() + ", Id de la empresa proveedora:" + company_typeContacts.get(i).getid_SupplierCompany() + ", Valor: " + company_typeContacts.get(i).getValue();
        }
        return info;
    }

    public ArrayList<CompanyTypeContact> getModelos_colchon_pedido() {
        return company_typeContacts;
    }



}


