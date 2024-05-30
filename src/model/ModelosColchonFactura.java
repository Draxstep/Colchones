package model;

public class ModelosColchonFactura {
    private int id_modelo_colchon;
    private int id_factura_venta;

    public ModelosColchonFactura(int id_modelo_colchon, int id_factura_venta) {
        this.id_modelo_colchon = id_modelo_colchon;
        this.id_factura_venta = id_factura_venta;
    }

    public int getId_modelo_colchon() {
        return id_modelo_colchon;
    }

    public int getId_factura_venta() {
        return id_factura_venta;
    }
}
