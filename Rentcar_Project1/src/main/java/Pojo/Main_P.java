package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.MemberDAO;
import DTO.Page;

public class Main_P implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Main");
		request.setAttribute("list", MemberDAO.getInstance().getAllData());
		request.setAttribute("Carlist", CarDAO.getInstance().getAll());
		return "Main";
	}
}
