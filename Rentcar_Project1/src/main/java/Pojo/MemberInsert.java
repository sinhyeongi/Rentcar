package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberVO;
import DTO.Page;

public class MemberInsert implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id") == null) {
			request.setAttribute("title", "회원가입");
			return "MemberInsert";
		}else if(request.getParameter("id") != null && request.getParameter("pw")== null) {
			int cnt = (MemberDAO.getInstance().getUser(request.getParameter("id")) == null ? 0 : 1);
			response.getWriter().print(cnt);
			return null;
		}
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setEmail(request.getParameter("email"));
		vo.setTel(request.getParameter("tel"));
		vo.setHobby(request.getParameter("hobby"));
		vo.setJob(request.getParameter("job"));
		vo.setAge(request.getParameter("age"));
		vo.setInfo(request.getParameter("info"));
		int cnt = MemberDAO.getInstance().InsertMember(vo);
		response.getWriter().print(cnt);
		return  null;
	}
}
