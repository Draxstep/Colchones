package model;

import java.util.ArrayList;

public class WarrantyTable{
    private ArrayList<Warranty> warranty;

    public WarrantyTable(){
        warranty= new ArrayList<>();
    }

    public void initArrayList(ArrayList<Warranty> arrayFromDb){
        warranty.addAll(arrayFromDb);
    }

    public void registerNewObject(int warranty_length){
       warranty.add(new Warranty(assignId(), warranty_length));
    }

    public void deleteRegisteredObject(int objectId){

        for(int i=0;i<warranty.size(); i++){
            if(warranty.get(i).getId_warranty() == objectId){
                warranty.remove(i);
                i = warranty.size() + 1;
                
            }

        }
    }

    public void editRegisteredObject(int objectId, Warranty newObject){
 
        for(int i=0;i<warranty.size(); i++){
            if(warranty.get(i).getId_warranty() == objectId){
                warranty.set(i, newObject);
                i = warranty.size() + 1;

            }

        }
    }

    public String getInfoRegisteredObjects(){
        String info = "";

        for(int i=0;i<warranty.size(); i++){
            info += "Id de la garantia:"  + warranty.get(i).getId_warranty() + ", Duracion de la garantia:" + warranty.get(i).getWarranty_length() + "\n";
        }
        return info;
    }

    private int assignId(){
        int id = 0;
        if(warranty.isEmpty()){
            id = 1;
        }else{
            int lastSavedid = warranty.get(warranty.size()-1).getId_warranty();
            id = lastSavedid+1;
        }
        return id;
    }

    public ArrayList<Warranty> getWarranty() {
        return warranty;
    }

    
}


