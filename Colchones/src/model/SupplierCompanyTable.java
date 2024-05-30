package model;

import java.util.ArrayList;

public class SupplierCompanyTable{
    private ArrayList<SupplierCompany> supplierCompanies;
    private int currentId;

    public SupplierCompanyTable(){
        currentId = 0;
        supplierCompanies= new ArrayList<>();
    }

    public void registerNewObject(String supplierName){
       supplierCompanies.add(new SupplierCompany(currentId, supplierName));
       currentId++;
    }

    public void deleteRegisteredObject(int objectId){
        for(int i=0; i<supplierCompanies.size(); i++){
            if(supplierCompanies.get(i).getId_supplierCompany() == objectId){
                i = supplierCompanies.size();
            }
            supplierCompanies.remove(i);
        }
    }

    public void editRegisteredObject(int objectId, SupplierCompany newObject){
        for(int i = 0;i <supplierCompanies.size(); i++){
            if(supplierCompanies.get(i).getId_supplierCompany() == objectId){
                supplierCompanies.set(i, newObject);
                i = supplierCompanies.size();
            }
        }
    }

    public String showRegisteredObjects(){
        String info = "";
        for(int i=0;i<supplierCompanies.size(); i++){
            info += "Id de la empresa proveedora: " + supplierCompanies.get(i).getId_supplierCompany() + ", Nombre de la empresa: " + supplierCompanies.get(i).getsupplier_name(); 
            System.out.println(supplierCompanies.get(i).getsupplier_name());
        }
        return info;
    }

    public ArrayList<SupplierCompany> getsupplierCompanies() {
        return supplierCompanies;
    }

    
}


