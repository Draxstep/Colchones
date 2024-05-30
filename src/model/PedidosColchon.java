package model;

import java.sql.Date;

public class PedidosColchon {
    private int id_pedido_colchon;
    private Date fecha_colchon_pedido;
    private int id_empresa_proveedor;
    private int id_empleado;

    public PedidosColchon(int id_pedido_colchon, Date fecha_colchon_pedido, int id_empresa_proveedor, int id_empleado) {
        this.id_pedido_colchon = id_pedido_colchon;
        this.fecha_colchon_pedido = fecha_colchon_pedido;
        this.id_empresa_proveedor = id_empresa_proveedor;
        this.id_empleado = id_empleado;
    }

    public int getId_pedido_colchon() {
        return id_pedido_colchon;
    }

    public Date getFecha_colchon_pedido() {
        return fecha_colchon_pedido;
    }

    public int getId_empresa_proveedor() {
        return id_empresa_proveedor;
    }

    public int getId_empleado() {
        return id_empleado;
    }
}
