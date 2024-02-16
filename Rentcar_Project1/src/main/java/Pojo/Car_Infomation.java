package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DTO.CarVO;
import DTO.Page;

public class Car_Infomation implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("target") == null) {
			return "Main";
		}
		CarVO vo = CarDAO.getInstance().getData(Integer.parseInt(request.getParameter("target")));
		request.setAttribute("vo", vo);
		request.setAttribute("target", request.getParameter("target"));
		return "Car_Infomation";
	}
}
