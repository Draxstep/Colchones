package model;

import java.util.ArrayList;

public class Mattress_modelsTable {
    private ArrayList<MattressModels> mattressModels;

    public Mattress_modelsTable(){
        mattressModels= new ArrayList<>();
    }

    public void initArrayList(ArrayList<MattressModels> arrayFromDb){
        mattressModels.addAll(arrayFromDb);
    }

    public void registerNewObject(String mattress_model_name, int mattress_model_length, int mattress_model_width, int mattress_model_height, String mattress_model_material, int mattress_model_price, int id_brand, int id_mattress_model_type, int id_mattress_warranty){
        mattressModels.add(new MattressModels(assignId(), mattress_model_name, mattress_model_length, mattress_model_width, mattress_model_height, mattress_model_material, mattress_model_price, id_brand, id_mattress_model_type, id_mattress_warranty));
    }

    public void deleteRegisteredObject(int objectId){
        for(int i=0;i<mattressModels.size(); i++){
            if(mattressModels.get(i).getId_mattress_model() == objectId){
                mattressModels.remove(i);
                i = mattressModels.size() + 1;

            }

        }
    }

    public void editRegisteredObject(int objectId, MattressModels newObject){
        for(int i=0;i<mattressModels.size(); i++){
            if(mattressModels.get(i).getId_mattress_model() == objectId){
                mattressModels.set(i, newObject);
                i = mattressModels.size() + 1;

            }

            
        }
    }

    public String getInfoRegisteredObjects(){
        String info = "";

        for(int i=0;i<mattressModels.size(); i++){
            info += "Id modelo del colchon:"  + mattressModels.get(i).getId_mattress_model() + 
            ", Nombre del modelo del colchon:" + mattressModels.get(i).getMattress_model_name() + 
            ", Largo del colchon:"  + mattressModels.get(i).getMattress_model_length() +
            ", Ancho del colchon:"  + mattressModels.get(i).getMattress_model_width() +
            ", Alto del colchon:"  + mattressModels.get(i).getMattress_model_height() + 
            ", Material del colchon:"  + mattressModels.get(i).getMattress_model_material() +
            ", Precio del colchon:"  + mattressModels.get(i).getMattress_model_price() + 
            ", Id de la marca:"  + mattressModels.get(i).getId_brand() + 
            ", Id del tipo de modelo:"  + mattressModels.get(i).getId_mattress_model_type() +
            ", Id garantia del colchon:"  + mattressModels.get(i).getId_mattress_warranty() +"\n";
        }
        return info;
    }

    private int assignId(){
        int id = 0;
        if(mattressModels.isEmpty()){
            id = 1;
        }else{
            int lastSavedid = mattressModels.get(mattressModels.size()-1).getId_mattress_model();
            id = lastSavedid+1;
        }
        return id;
    }

    public ArrayList<MattressModels> getMattressModels() {
        return mattressModels;
    }

    

}
