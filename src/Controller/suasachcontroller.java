package Controller;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.sachbo;

/**
 * Servlet implementation class suasachcontroller
 */
@WebServlet("/suasachcontroller")
public class suasachcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suasachcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadminController");
			rd.forward(request, response);
		}
		else {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		sachbo sbo = new sachbo();
		String masach =request.getParameter("ms");
		String tensach =request.getParameter("ts");
		String sotap = request.getParameter("st");
		String tacgia = request.getParameter("tg"); 
		String soluong =(request.getParameter("sl"));
		Date ngaynhap = Date.valueOf(request.getParameter("nn"));
		String gia =(request.getParameter("g"));
		String maloai= request.getParameter("ml");
		String anh = request.getParameter("a");
		anh = sbo.getAnh(masach);
		if(masach!=null) {
			request.setAttribute("masach", masach);
			request.setAttribute("tensach", tensach);
			request.setAttribute("sotap", sotap);
			request.setAttribute("tacgia", tacgia);
			request.setAttribute("soluong", soluong);
			request.setAttribute("ngaynhap", ngaynhap);
			request.setAttribute("gia", gia);
			request.setAttribute("maloai", maloai);
			request.setAttribute("anh", anh);
			RequestDispatcher rd= request.getRequestDispatcher("suasach.jsp");
	 	    rd.forward(request, response);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
