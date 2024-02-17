package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.Page;

public class DeleteMember implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("id")== null) {
			response.getWriter().print("0");
			return null;
		}
		String id = request.getParameter("id");
		int cnt =MemberDAO.getInstance().DeleteMember(id);
		response.getWriter().print(cnt);
		if(cnt > 0) {
			request.getSession().removeAttribute("log");
		}
		return null;
	}
}
