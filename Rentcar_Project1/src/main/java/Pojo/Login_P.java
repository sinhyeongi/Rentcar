package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.Page;

public class Login_P implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("id") == null) {
			request.setAttribute("title", "로그인");
			return "Login";
		}
		String log = MemberDAO.getInstance().LoginCheck(request.getParameter("id"), request.getParameter("pw"));
		System.out.println(log);
		request.getSession().setAttribute("log", log);
		if(log != null) {
			response.getWriter().print(log);
		}
		
		
		return null;
	}
}
