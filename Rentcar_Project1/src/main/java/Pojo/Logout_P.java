package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Page;

public class Logout_P implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log") != null) {
		request.getSession().removeAttribute("log");
		response.getWriter().print("true");
		return null;
		}
		response.getWriter().print("false");
		return null;
	}
}
