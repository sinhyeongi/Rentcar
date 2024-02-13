package Mapping;

import java.util.HashMap;

import DTO.Page;
import Pojo.Login_P;
import Pojo.Logout_P;
import Pojo.Main_P;

public class Mapper {
	private HashMap<String, Page> mapper;
	public Mapper(){
		mapper = new HashMap<String, Page>();
		mapper.put("/Main.do", new Main_P());
		mapper.put("/Login.do", new Login_P());
		mapper.put("/Logout.do", new Logout_P());
	}
	public Page getPojo(String key) {
		return mapper.get(key);
	}
}
