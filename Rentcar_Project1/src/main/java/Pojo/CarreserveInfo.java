package Pojo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.CarReserveDAO;
import DTO.CarReserve;
import DTO.Page;

public class CarreserveInfo implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log") == null) {
			return "re:Main";
		}if(request.getParameter("no") != null) {
			int cnt = -1;
			cnt = CarReserveDAO.getInstance().Carreservecancel(Integer.parseInt(request.getParameter("seq")),request.getParameter("id"));
			if(cnt > 0) {
				cnt = CarDAO.getInstance().Carreservecancel(Integer.parseInt(request.getParameter("no")), Integer.parseInt(request.getParameter("qty")));
			}
			response.getWriter().print(cnt);
			return null;
		}
		ArrayList<CarReserve> list = CarReserveDAO.getInstance().getData((String)request.getSession().getAttribute("log"));
		list = CarDAO.getInstance().setName(list);
		request.setAttribute("list", list);
		request.setAttribute("title", request.getSession().getAttribute("log")+"회원 예약 정보");
		return "CarreserveInfo";
	}
}
