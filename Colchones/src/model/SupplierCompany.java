package model;

public class SupplierCompany {
    private int id_supplierCompany;
    private String supplier_name;


    public SupplierCompany(int id_supplierCompany, String supplier_name) {
        this.id_supplierCompany = id_supplierCompany;
        this.supplier_name = supplier_name;
    }

    public int getId_supplierCompany() {
        return id_supplierCompany;
    }

    public String getsupplier_name() {
        return supplier_name;
    }

    
}
