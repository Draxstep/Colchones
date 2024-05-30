package model;

public class CompanyTypeContact {
    private int id_supplierCompany;
    private int id_typeContact;
    private String value;

    public CompanyTypeContact(int id_supplierCompany, int id_typeContact, String value) {
        this.id_supplierCompany = id_supplierCompany;
        this.id_typeContact = id_typeContact;
        this.value = value;
    }

    public int getid_SupplierCompany() {
        return id_supplierCompany;
    }

    public int getid_typeContact() {
        return id_typeContact;
    }

    public String getValue(){
        return this.value;
    }

    
}
