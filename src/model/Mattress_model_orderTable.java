package model;

import java.util.ArrayList;

public class Mattress_model_orderTable{
    private ArrayList<MattressModelsOrder> mattress_models_order;

    public Mattress_model_orderTable(){
        mattress_models_order= new ArrayList<>();
    }

    public void initArrayList(ArrayList<MattressModelsOrder> arrayFromDb){
        mattress_models_order.addAll(arrayFromDb);
    }

    public void registerNewObject(int id_mattress_model, int id_order){
      mattress_models_order.add(new MattressModelsOrder(id_mattress_model, id_order));
    }

    public void deleteRegisteredObject(int objectId1, int objectId2){

        for(int i=0;i<=mattress_models_order.size(); i++){
            if(mattress_models_order.get(i).getId_mattress_model() == objectId1 && mattress_models_order.get(i).getId_order() == objectId2){
                mattress_models_order.remove(i);
                i = mattress_models_order.size() + 1;
            }
        }
    }

    public void editRegisteredObject(int objectId1, int objectId2, MattressModelsOrder newObject){
        for(int i=0;i<mattress_models_order.size(); i++){
            if(mattress_models_order.get(i).getId_mattress_model() == objectId1 && mattress_models_order.get(i).getId_order() == objectId2){
                mattress_models_order.set(i, newObject);
                i = mattress_models_order.size() + 1;
            }

        }
    }

    public String getInfoRegisteredObjects(){
        String info = "";

        for(int i=0;i<mattress_models_order.size(); i++){
            info += "Id de la orden:"  + mattress_models_order.get(i).getId_order() + ", Id del modelo:" + mattress_models_order.get(i).getId_mattress_model() + "\n";
        }
        return info;
    }

    public ArrayList<MattressModelsOrder> getModelos_colchon_pedido() {
        return mattress_models_order;
    }



}


