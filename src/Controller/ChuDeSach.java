package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class ChuDeSach
 */
@WebServlet("/ChuDeSach")
public class ChuDeSach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChuDeSach() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Lấy ds loại
		loaibo loai = new loaibo();
		if (loai.getloai() != null) {
			request.setAttribute("loai", loai.getloai());
		}
		
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
		RequestDispatcher rd = request.getRequestDispatcher("htsach");
		rd.forward(request, response);
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
