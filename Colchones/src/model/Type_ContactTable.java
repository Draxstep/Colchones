package model;

import java.util.ArrayList;

public class Type_ContactTable {
    private int currentId;
    private ArrayList<TypeContact> typeContact;

    public Type_ContactTable(){
        currentId = 0;
        typeContact= new ArrayList<>();
    }

    public void registerNewObject(String typeContact_name){
        typeContact.add(new TypeContact(currentId, typeContact_name));
    }

    public void deleteRegisteredObject(int objectId){
        for(int i=0;i<typeContact.size(); i++){
            if(typeContact.get(i).getId_typeContact() == objectId){
                i = typeContact.size();
            }
            typeContact.remove(i);
        }
    }

    public void editRegisteredObject(int objectId,TypeContact newObject){
        for(int i=0;i<typeContact.size(); i++){
            if(typeContact.get(i).getId_typeContact() == objectId){
                i = typeContact.size();
            }
            typeContact.set(i, newObject);
            
        }
    }

    public String showRegisteredObjects(){
        String info = "";
        for(int i=0;i<typeContact.size(); i++){
            info += "Id tipo contacto: " + typeContact.get(i).getId_typeContact() + ", Nombre tipo contacto: " + typeContact.get(i).getTypeContact_name();
        }
        return info;
    }

    public ArrayList<TypeContact> gettypeContactTable() {
        return typeContact;
    }

    

}
