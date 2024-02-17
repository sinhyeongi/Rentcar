package DAO;

import java.util.ArrayList;

import DB.CarReserve_DB;
import DTO.CarReserve;

public class CarReserveDAO {
	private static CarReserveDAO instance;
	private CarReserve_DB db;
	private CarReserveDAO() {
		db = CarReserve_DB.getInstance();
	}
	public static CarReserveDAO getInstance() {
		if(instance == null) {
			instance = new CarReserveDAO();
		}
		return instance;
	}
	public int InsertData(CarReserve vo) {
		return db.InsertData(vo);
	}
	public ArrayList<CarReserve> getData(String id){
		return db.getData(id);
	}
	public int Carreservecancel(int seq,String id) {
		return db.Carreservecancel(seq,id);
	}
	public int Carreservecancel_OneUser(String id) {
		return db.Carreservecancel_Oneuser(id);
	}
	public ArrayList<String> getCarreservecancel_Oneuser(String id){
		return db.getCarreservecancel_Oneuser(id);
	}
	public int Carreservecancel_ad(int no) {
		return db.Carreservecancel_Admin(no); 
	}
	public int CarreserveCancel_Admin_seq(int seq) {
		return db.CarreserveCancel_Admin_seq(seq);
	}
	public ArrayList<CarReserve> getAllData(){
		return db.getAllData();
		
	}
}
