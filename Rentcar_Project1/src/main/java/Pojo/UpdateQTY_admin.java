package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DTO.Page;

public class UpdateQTY_admin implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("no") == null) {
			return null;
		}
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("total_qty"));
		
		response.getWriter().print(CarDAO.getInstance().UpdateQTY(no, qty));
		return null;
	}
}
