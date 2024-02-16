package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DTO.Page;

public class UploadImgcheck implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("name") == null) {
			return  null;
		}
		String name = request.getParameter("name");
		int c = CarDAO.getInstance().CheckName(name);
		response.getWriter().print(c);
		return null;
	}
}
