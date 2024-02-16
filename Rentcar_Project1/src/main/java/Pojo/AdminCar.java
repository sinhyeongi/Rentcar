package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DTO.Page;

public class AdminCar implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log").equals("admin") == false) {
			return "re:Main";
		}
		request.setAttribute("title", "차량 관리하기");
		request.setAttribute("Carlist", CarDAO.getInstance().getAll());
		return "AdminCar";
	}
}
