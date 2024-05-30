package model;

public class MattressModelsOrder {
    private int id_mattress_model;
    private int id_order;

    public MattressModelsOrder(int id_mattress_model, int id_order) {
        this.id_mattress_model = id_mattress_model;
        this.id_order = id_order;
    }

    public int getId_mattress_model() {
        return id_mattress_model;
    }

    public int getId_order() {
        return id_order;
    }

    
}
