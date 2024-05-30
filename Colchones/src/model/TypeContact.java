package model;

public class TypeContact{
    private int id_typeContact;
    private String typeContact_name;

    

    public TypeContact(int id_typeContact, String typeContact_name) {
        this.id_typeContact = id_typeContact;
        this.typeContact_name = typeContact_name;
    }

    public int getId_typeContact() {
        return id_typeContact;
    }

    public String getTypeContact_name() {
        return typeContact_name;
    }
    
}
