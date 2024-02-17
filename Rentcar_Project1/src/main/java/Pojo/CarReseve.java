package Pojo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import DAO.CarDAO;
import DTO.CarReserve;
import DTO.Page;

public class CarReseve implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("startDate") == null) {
			LocalDate data = LocalDate.now(); 
			request.setAttribute("today", data);
			request.setAttribute("list", CarDAO.getInstance().getAll());
			if(request.getParameter("target") != null) {
				request.setAttribute("target", request.getParameter("target"));
			}
			request.setAttribute("title","예약페이지");
		return "Carreserve";
		}
		String data[] = request.getParameter("car").split("/");
		Date dddate = new Date();
		String data2[] = request.getParameter("startDate").split("-"); 
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(data2[0]), Integer.parseInt(data2[1])-1, Integer.parseInt(data2[2]));
		
		if(dddate.after(cal.getTime())) {
			LocalDate data3 = LocalDate.now(); 
			request.setAttribute("today", data3);
			request.setAttribute("list", CarDAO.getInstance().getAll());
			if(request.getParameter("target") != null) {
				request.setAttribute("target", request.getParameter("target"));
			}
			return "Carreserve";
		}
		CarReserve vo = new CarReserve();
		vo.setNo(Integer.parseInt(data[0]));
		vo.setId((String)request.getSession().getAttribute("log"));
		vo.setQty(Integer.parseInt(request.getParameter("car_count")));
		vo.setDday(request.getParameter("startDate")+"/"+request.getParameter("startH"));
		vo.setRday(Integer.parseInt(request.getParameter("car_rent_time")));
		request.setAttribute("vo", vo);
		request.setAttribute("price", request.getParameter("price"));
		request.setAttribute("title", "옵션 선택 페이지");
		return "Carreserve_option";
	}
}
