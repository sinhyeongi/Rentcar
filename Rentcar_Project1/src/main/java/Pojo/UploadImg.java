package Pojo;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.CarDAO;
import DTO.CarVO;
import DTO.Page;

public class UploadImg implements Page{
	@Override
	public String Service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root_path = request.getServletContext().getRealPath("");
		String work_path = "/Users/ssd/Desktop/SHGjspworkspace/Project1/Rentcar/Rentcar_Project1/src/main/webapp/img/";
		System.out.println(root_path);
		File f = new File(root_path+"img");
		if(!f.exists()) {
			try {
				f.mkdir();
				System.out.println("폴더 생성");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		root_path += "img";
		int size = 1024 * 1024 *10;
		System.out.println(root_path);
		MultipartRequest mr = new MultipartRequest(request, root_path,size,"UTF-8",new DefaultFileRenamePolicy());
		String sfname = mr.getFilesystemName("img");
		File ofile = mr.getFile("img");
		File cfile = new File(work_path+sfname);
		System.out.println(ofile.toString());
		Files.copy(ofile.toPath(), cfile.toPath());
		
		CarVO vo = new CarVO();
		vo.setName(mr.getParameter("name"));
		vo.setCategory(mr.getParameter("category"));
		vo.setPrice(Integer.parseInt(mr.getParameter("price")));
		vo.setUsepeople(Integer.parseInt(mr.getParameter("usepeople")));
		vo.setTotal_qty(Integer.parseInt(mr.getParameter("total_qty")));
		vo.setCompany(mr.getParameter("company"));
		vo.setImg(sfname);
		vo.setInfo(mr.getParameter("info"));
		int cnt =CarDAO.getInstance().InsertCar(vo);
		response.getWriter().print(cnt);
		return null;
	}
	
}
