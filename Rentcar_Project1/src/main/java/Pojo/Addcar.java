package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Page;

public class Addcar implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getSession().getAttribute("log"));
		if(request.getSession().getAttribute("log").equals("admin") == false) {
			return "Main";
		}
		request.setAttribute("title", "차량 추가 하기");
		return "addCar";
	}
}
