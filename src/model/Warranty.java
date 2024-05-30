package model;

public class Warranty {
    private int id_warranty;
    private int warranty_length;


    public Warranty(int id_warranty, int warranty_length) {
        this.id_warranty = id_warranty;
        this.warranty_length = warranty_length;
    }

    public int getId_warranty() {
        return id_warranty;
    }

    public int getWarranty_length() {
        return warranty_length;
    }

    
}
