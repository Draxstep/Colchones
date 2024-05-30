package model;

public class PersonTypeContact{
    private int id_typeContact;
    private int id_person;

    

    public PersonTypeContact(int id_person, int id_typeContact) {
        this.id_typeContact = id_typeContact;
        this.id_person = id_person;
    }

    public int getId_typeContact() {
        return id_typeContact;
    }

    public int getId_Person() {
        return id_person;
    }
    
}
