package presenter;

import java.sql.SQLException;

import dao.ConexionBD;
import dao.MattressModelsDao;
import dao.WarrantyDao;
import model.MattressModels;
import model.MattressModelsOrder;
import model.Mattress_model_orderTable;
import model.WarrantyTable;
public class App {
    public static void main(String[] args) throws SQLException {
        ConexionBD conn = new ConexionBD();
        MattressModelsDao mattressDao = new MattressModelsDao();
        WarrantyDao warrantyDao = new WarrantyDao();
        WarrantyTable tab = new WarrantyTable();
        Mattress_model_orderTable tab2 = new Mattress_model_orderTable();
        WarrantyTable watab = new WarrantyTable();
        
        //warrantyDao.insertData(1, 6);
        //mattressDao.insertData(1, "nombre1", 48, 23, 10, "material1", 200000, 1, 1, 1);
        //mattressDao.removeData(1);
        //warrantyDao.removeData(1);
    }
}
