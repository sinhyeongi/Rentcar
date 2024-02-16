package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DTO.Page;

public class Select_car_P implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getParameter("category");
		if(target.equals("0")) {
			request.setAttribute("Carlist", CarDAO.getInstance().getAll());
			return "Carlist";
		}
		request.setAttribute("Carlist", CarDAO.getInstance().getAll_Category(target));
		
		return "Carlist";
	}

}
