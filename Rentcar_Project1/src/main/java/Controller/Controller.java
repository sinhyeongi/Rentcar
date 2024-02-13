package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Page;
import Mapping.Mapper;
import Mapping.ViewResolver;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Mapper mapper = new Mapper();
    private ViewResolver viewResolver;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String path = request.getContextPath();
		url = url.substring(path.length());
		System.out.println("url = "+url);
		Page page =  mapper.getPojo(url);
		if(page == null) {
			request.setAttribute("page", "404.html");
			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/View/layout.jsp");
			dis.forward(request, response);
		}
		String next = page.Service(request, response);
		if(next != null) {
			request.setAttribute("page", next+".jsp");
			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/View/layout.jsp");
			dis.forward(request, response);
			return;
		}
		
	}

}
