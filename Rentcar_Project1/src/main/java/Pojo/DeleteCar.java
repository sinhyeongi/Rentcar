package Pojo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarDAO;
import DAO.CarReserveDAO;
import DTO.Page;

public class DeleteCar implements Page {
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log").equals("admin") == false) {
			return null;
		}
		int target = Integer.parseInt(request.getParameter("target"));
		String img = CarDAO.getInstance().DeleteCar(target);
		if(img != null && img.length() > 3) {
			try {
				String path = request.getServletContext().getRealPath("");
				path +="img/";
				String path2 = "/Users/ssd/Desktop/SHGjspworkspace/Project1/Rentcar/Rentcar_Project1/src/main/webapp/img/";
				Path file1 = Paths.get(path+img);
				Path file2 = Paths.get(path2 + img);
				Files.delete(file1);
				Files.delete(file2);
			}catch(NoSuchFileException e) {
				e.printStackTrace();
			}
			
			int cnt = CarReserveDAO.getInstance().Carreservecancel_ad(target);
			response.getWriter().print(cnt);
			return null;
		}
		response.getWriter().print("err");
		return null;
	}
}
