package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import bo.dangnhapadminbo;

/**
 * Servlet implementation class dangnhapadminController
 */
@WebServlet("/dangnhapadminController")
public class dangnhapadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangnhapadminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		dangnhapadminbo dnbo = new dangnhapadminbo();
		dangnhapbean dn = null;
		RequestDispatcher rd;
		if (un != null && pass != null) {
			// Tao doi tuong session
			HttpSession session = request.getSession();
			// Neu chua tao session
			if (session.getAttribute("admin") == null) {
				dn = new dangnhapbean();
				// session.setAttribute("kh", kh);//Tao bien session dn
			}
			dn = dnbo.ktdn(un, pass);
			if (dn == null)
				rd = request.getRequestDispatcher("dangnhapadmin.jsp?kt=1");
			else {
				session.setAttribute("admin", dn);
				rd = request.getRequestDispatcher("adminController");
			}
		} else
			rd = request.getRequestDispatcher("dangnhapadmin.jsp");

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
