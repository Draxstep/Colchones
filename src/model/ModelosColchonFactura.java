package model;

public class MattressModelInvoice {
    private int mattress_model_id;
    private int sale_invoice_id;

    public MattressModelInvoice(int mattress_model_id, int sale_invoice_id) {
        this.mattress_model_id = mattress_model_id;
        this.sale_invoice_id = sale_invoice_id;
    }

    public int getMattress_model_id() {
        return mattress_model_id;
    }

    public int getSale_invoice_id() {
        return sale_invoice_id;
    }
}
