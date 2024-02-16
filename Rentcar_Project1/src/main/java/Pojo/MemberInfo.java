package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberVO;
import DTO.Page;

public class MemberInfo implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Info Call");
		if(request.getSession().getAttribute("log") == null) {
			return "Main";
		}
		if(request.getParameter("id")== null) {
			request.setAttribute("title",request.getSession().getAttribute("log")+" 회원 정보");
			MemberVO vo = MemberDAO.getInstance().getUser((String)request.getSession().getAttribute("log"));
			request.setAttribute("vo", vo);
			return "MemberInfo";
		}
		System.out.println("Info End");
		response.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		vo.setUpData(request);
		if(MemberDAO.getInstance().UpdateInfo(vo) == 1) {
			response.getWriter().print("ok");
		}
		return null;
	}
}
