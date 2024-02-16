package Mapping;

import java.util.HashMap;

import DTO.CarReserve;
import DTO.Page;
import Pojo.Addcar;
import Pojo.AdminCar;
import Pojo.Admin_member;
import Pojo.CarReseve;
import Pojo.CarReseveOption;
import Pojo.Car_Infomation;
import Pojo.CarreserveInfo;
import Pojo.DeleteCar;
import Pojo.DeleteMember;
import Pojo.Login_P;
import Pojo.Logout_P;
import Pojo.Main_P;
import Pojo.MemberInfo;
import Pojo.MemberInsert;
import Pojo.Select_car_P;
import Pojo.UpdateP_Admin;
import Pojo.UpdateQTY_admin;
import Pojo.UploadImg;
import Pojo.UploadImgcheck;

public class Mapper {
	private HashMap<String, Page> mapper;
	public Mapper(){
		mapper = new HashMap<String, Page>();
		mapper.put("/Main.do", new Main_P());
		mapper.put("/Login.do", new Login_P());
		mapper.put("/Logout.do", new Logout_P());
		mapper.put("/Select_car.do", new Select_car_P());
		mapper.put("/Carreserve.do",new CarReseve());
		mapper.put("/CarReseveOption.do", new CarReseveOption());
		mapper.put("/CarInfomation.do", new Car_Infomation());
		mapper.put("/MemberInfo.do", new MemberInfo());
		mapper.put("/CarreserveInfo.do", new CarreserveInfo());
		mapper.put("/MemberInsert.do", new MemberInsert());
		mapper.put("/DeleteMember.do", new DeleteMember());
		mapper.put("/addcar.do", new Addcar());
		mapper.put("/UploadImg.do", new UploadImg());
		mapper.put("/UploadImgcheck.do", new UploadImgcheck());
		mapper.put("/Admin_Car.do", new AdminCar());
		mapper.put("/DeleteCar.do", new DeleteCar());
		mapper.put("/UpdateP_admin.do", new UpdateP_Admin());
		mapper.put("/UpdateQTY_admin.do", new UpdateQTY_admin());
		mapper.put("/Admin_Member.do", new Admin_member());
	}
	public Page getPojo(String key) {
		return mapper.get(key);
	}
}
