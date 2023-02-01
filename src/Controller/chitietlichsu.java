package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.lsuctdao;
/**
 * Servlet implementation class chitietlichsu
 */
@WebServlet("/chitietlichsu")
public class chitietlichsu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitietlichsu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		lsuctdao  ls= new lsuctdao();
		String mahd = request.getParameter("mahd");
		if(mahd!=null) {
			request.setAttribute("chitiet", ls. getlsuct(mahd));
			 RequestDispatcher rd = request.getRequestDispatcher("chitietlichsu.jsp");
				rd.forward(request, response);
		}else {
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
