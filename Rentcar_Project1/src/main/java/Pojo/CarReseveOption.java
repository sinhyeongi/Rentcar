package Pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.CarReserveDAO;
import DTO.CarReserve;
import DTO.Page;

public class CarReseveOption implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("id") == null) {
			return "Main";
		}
		CarReserve vo = new CarReserve();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setId(request.getParameter("id"));
		vo.setQty(Integer.parseInt(request.getParameter("qty")));
		vo.setDday(request.getParameter("dday"));
		vo.setRday(Integer.parseInt(request.getParameter("rday")));
		vo.setUsein(Integer.parseInt(request.getParameter("usein")));
		vo.setUsewifi(Integer.parseInt(request.getParameter("usewifi")));
		vo.setUsenavi(Integer.parseInt(request.getParameter("usenavi")));
		vo.setUseseat(Integer.parseInt(request.getParameter("useseat")));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		int cnt = CarReserveDAO.getInstance().InsertData(vo);
		int cnt2 = CarDAO.getInstance().SubCarCount(vo.getQty(),vo.getNo());
		response.getWriter().print(cnt);
		return null;
	}

}
