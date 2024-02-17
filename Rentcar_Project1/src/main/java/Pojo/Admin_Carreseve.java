package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.CarReserveDAO;
import DTO.Page;

public class Admin_Carreseve implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("reserve_seq")==null) {
			request.setAttribute("list", CarReserveDAO.getInstance().getAllData());
		return "Admin_Carreseve";
		}
		int target = Integer.parseInt(request.getParameter("reserve_seq"));
		CarDAO.getInstance().Carreservecancel(Integer.parseInt(request.getParameter("no")), Integer.parseInt(request.getParameter("qty")));
		response.getWriter().print(CarReserveDAO.getInstance().CarreserveCancel_Admin_seq(target));
		return null;
	}
}
