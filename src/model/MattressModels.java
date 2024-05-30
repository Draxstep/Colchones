package model;

public class MattressModels{
    private int id_mattress_model;
    private String mattress_model_name;
    private int mattress_model_length;
    private int mattress_model_width;
    private int mattress_model_height;
    private String mattress_model_material;
    private int mattress_model_price;
    private int id_brand;
    private int id_mattress_model_type;
    private int id_mattress_warranty;

    

    public MattressModels(int id_mattress_model, String mattress_model_name, int mattress_model_length, int mattress_model_width, int mattress_model_height, String mattress_model_material, int mattress_model_price, int id_brand, int id_mattress_model_type, int id_mattress_warranty) {
        this.id_mattress_model = id_mattress_model;
        this.mattress_model_name = mattress_model_name;
        this.mattress_model_length = mattress_model_length;
        this.mattress_model_width = mattress_model_width;
        this.mattress_model_height = mattress_model_height;
        this.mattress_model_material = mattress_model_material;
        this.mattress_model_price = mattress_model_price;
        this.id_brand = id_brand;
        this.id_mattress_model_type = id_mattress_model_type;
        this.id_mattress_warranty = id_mattress_warranty;
    }

    public int getId_mattress_model() {
        return id_mattress_model;
    }

    public String getMattress_model_name() {
        return mattress_model_name;
    }

    public int getMattress_model_length() {
        return mattress_model_length;
    }

    public int getMattress_model_width() {
        return mattress_model_width;
    }

    public int getMattress_model_height() {
        return mattress_model_height;
    }

    public String getMattress_model_material() {
        return mattress_model_material;
    }

    public int getMattress_model_price() {
        return mattress_model_price;
    }

    public int getId_brand() {
        return id_brand;
    }

    public int getId_mattress_model_type() {
        return id_mattress_model_type;
    }

    public int getId_mattress_warranty() {
        return id_mattress_warranty;
    }

    
}
