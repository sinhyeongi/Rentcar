package Pojo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.CarReserveDAO;
import DAO.MemberDAO;
import DTO.Page;

public class Admin_member implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log").equals("admin") == false) {
			return null;
		}
		else if(request.getParameter("id") == null) {
		request.setAttribute("list", MemberDAO.getInstance().getAllData());
		request.setAttribute("title", "회원 관리");
			return "Admin_member";
		}
		String id = request.getParameter("id");
		int cnt = MemberDAO.getInstance().DeleteMember(id);
		if(cnt != 0) {
			ArrayList<String >list = CarReserveDAO.getInstance().getCarreservecancel_Oneuser(id);
			cnt = CarReserveDAO.getInstance().Carreservecancel_OneUser(id);
			for(int i = 0 ; i < list.size(); i++) {
				String tmp[] = list.get(i).split("/");
				CarDAO.getInstance().Carreservecancel(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			}
			response.getWriter().print(cnt);
		}
		return null;
	}
}
