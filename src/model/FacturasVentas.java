package model;

import java.sql.Date;

public class SaleInvoices {
    private int id_sale_invoice;
    private Date sale_invoice_date;
    private int employee_id;
    private int client_id;

    public SaleInvoices(int id_sale_invoice, Date sale_invoice_date, int employee_id, int client_id) {
        this.id_sale_invoice = id_sale_invoice;
        this.sale_invoice_date = sale_invoice_date;
        this.employee_id = employee_id;
        this.client_id = client_id;
    }

    public int getId_sale_invoice() {
        return id_sale_invoice;
    }

    public Date getSale_invoice_date() {
        return sale_invoice_date;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getClient_id() {
        return client_id;
    }
}
