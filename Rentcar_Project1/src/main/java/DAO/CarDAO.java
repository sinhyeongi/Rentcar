package DAO;

import java.util.ArrayList;

import DB.Car_DB;
import DTO.CarReserve;
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
	public ArrayList<CarVO> getAll_Category(String category){
		return db.getAllData_Category(category);
	}
	public CarVO getData(int target) {
		return db.getData(target);
	}
	public int SubCarCount(int count,int no) {
		return db.SubCarCount(count,no);
	}
	public ArrayList<CarReserve> setName(ArrayList<CarReserve> list){
		ArrayList<CarVO> list2 = db.getAllData();
		for(int i = 0 ; i < list.size(); i++) {
			for(int i2 = 0 ; i2 < list2.size(); i2++) {
				if(list.get(i).getNo() == list.get(i2).getNo()) {
					list.get(i).setName(list2.get(i2).getName());
					break;
				}
			}
		}
		return list;
	}
	public int Carreservecancel(int no,int qty) {
		return db.Carreservecancel(no, qty);
	}
	public int InsertCar(CarVO vo) {
		return db.InsertCar(vo);
	}
	public int CheckName(String name) {
		return db.CheckName(name);
	}
}
