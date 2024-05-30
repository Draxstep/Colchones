package model;

import java.sql.Date;

public class FacturasVentas {
    private int id_factura_venta;
    private Date fecha_factura_venta;
    private int id_empleado;
    private int id_cliente;

    public FacturasVentas(int id_factura_venta, Date fecha_factura_venta, int id_empleado, int id_cliente) {
        this.id_factura_venta = id_factura_venta;
        this.fecha_factura_venta = fecha_factura_venta;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
    }

    public int getId_factura_venta() {
        return id_factura_venta;
    }

    public Date getFecha_factura_venta() {
        return fecha_factura_venta;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }
}
