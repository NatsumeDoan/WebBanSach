package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;

/**
 * Servlet implementation class loaicontroller
 */
@WebServlet("/loaicontroller")
public class loaicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loaicontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maloai = request.getParameter("ml");
		String method = request.getParameter("method");
		loaibo loai = new loaibo();
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadminController");
			rd.forward(request, response);
		}
		else {
			if (loai.getloai() != null) {
				request.setAttribute("loai", loai.getloai());
			}
			if (method != null) {
				if (method.equals("addloai")) {
					String ml = request.getParameter("mloai");
					String tl = request.getParameter("tloai");
					if (ml != null && ml != "" && tl != null && tl != "")
						if(loai.getmaloai(ml)==0)
							loai.addloai(ml, tl);
						else {
							request.setAttribute("tl", "ko co");
						}
				}

			}
			if(maloai!=null) {
				loai.xoaloai(maloai);
			}
			request.setAttribute("loai", loai.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("adminloai.jsp");
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
