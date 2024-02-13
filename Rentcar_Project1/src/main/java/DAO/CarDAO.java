package DAO;

import java.util.ArrayList;

import DB.Car_DB;
import DTO.CarVO;

public class CarDAO {
	private static CarDAO instance;
	private Car_DB db;
	private CarDAO() {
		db = Car_DB.getInstance();
	}
	public static CarDAO getInstance() {
		if(instance == null) {
			instance = new CarDAO();
		}
		return instance;
	}
	public ArrayList<CarVO> getAll(){
		return db.getAllData();
	}
}
