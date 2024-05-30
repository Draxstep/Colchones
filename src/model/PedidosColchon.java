package model;

import java.sql.Date;

public class MattressOrders {
    private int mattress_order_id;
    private Date mattress_order_date;
    private int supplier_id;
    private int employee_id;

    public MattressOrders(int mattress_order_id, Date mattress_order_date, int supplier_id, int employee_id) {
        this.mattress_order_id = mattress_order_id;
        this.mattress_order_date = mattress_order_date;
        this.supplier_id = supplier_id;
        this.employee_id = employee_id;
    }

    public int getMattress_order_id() {
        return mattress_order_id;
    }

    public Date getMattress_order_date() {
        return mattress_order_date;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }
}

    public int getId_empleado() {
        return id_empleado;
    }
}
