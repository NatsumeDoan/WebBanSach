package Controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aa= request.getParameter("txta");
		String bb= request.getParameter("txtb");
		if(aa!=null||bb!=null) {
			double a= Double.parseDouble(aa);
			double b= Double.parseDouble(bb);
			double kq=0;
			if(request.getParameter("butc")!=null) {
				kq=a+b;
			}
			if(request.getParameter("butt")!=null) {
				kq=a-b;
			}
			if(request.getParameter("butn")!=null) {
				kq=a*b;
			}
			if(request.getParameter("butc")!=null) {
				kq=a/b;
			}
			request.setAttribute("bkq", kq);
		}
		RequestDispatcher rd = request.getRequestDispatcher("may_tinh.jsp");
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
