package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class adminsachcontroller
 */
@WebServlet("/adminsachcontroller")
public class adminsachcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminsachcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadminController");
			rd.forward(request, response);
		}
		else {
		loaibo loai = new loaibo();
		if (loai.getloai() != null) {
			request.setAttribute("loai", loai.getloai());
		}
		String xoa = request.getParameter("xoa");
		//Lấy ds sách
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		sachbo sdao = new sachbo();
		String maloai = request.getParameter("ml");
		String giaTriTimKiem = request.getParameter("timkiem");

		int count =0;
		int endPage=0;
		//Pagination
		String indexPage = request.getParameter("page");
		int page=1;
		if(indexPage!=null)
			page = Integer.parseInt(indexPage);
		
		ArrayList<sachbean> dsSach = null;
		if(xoa!=null) {
			String image = sdao.getAnh(xoa);
			String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "image_sach";
			String fileImg = dirUrl1 + File.separator + image;
			try {
				Files.delete(Paths.get(fileImg));
			} catch (Exception e) {
				e.printStackTrace();
			}
			sdao.deleteSach(xoa);
			
		}
		if(maloai == null && giaTriTimKiem == null) {
			dsSach = sdao.pagingBooks(page);
			count = sdao.getTotalBook();
			endPage = count/18;
			if(count % 18 != 0)
				endPage++;
		}
		if(maloai!=null) {
			dsSach = sdao.pagingBooksByMaSach(page, maloai);
			count = sdao.countBooksByMaLoai(maloai);
			endPage = count/18;
			if(count % 18 != 0)
				endPage++;
		}
		if(giaTriTimKiem!=null) {
			dsSach = sdao.pagingBooksBySearchValue(page, giaTriTimKiem);
			count = sdao.countBooksBySearchValue(giaTriTimKiem);
			endPage = count/18;
			if(count % 18 != 0)
				endPage++;
		}
		
		if(dsSach!=null)
			request.setAttribute("dsSach", dsSach);
		
		request.setAttribute("endPage", endPage);
		request.setAttribute("tag", page);
		RequestDispatcher rd = request.getRequestDispatcher("adminsach.jsp");
		rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
