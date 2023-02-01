package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;
import bo.loaibo;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/GioHang")
public class GioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		loaibo loai = new loaibo();
		if (loai.getloai() != null) {
			request.setAttribute("loai", loai.getloai());
		}

		String act = request.getParameter("act");
		String masach = request.getParameter("ms");
		HttpSession session = request.getSession();

		giohangbo gh;

		String button = request.getParameter("submit_XoaCheckBox");
		if (button != null) {
			gh = new giohangbo();
			if (session.getAttribute("gio") == null) {
				session.setAttribute("gio", gh);
			}
			String[] checkboxs = request.getParameterValues("checkbox-delete");
			if (checkboxs == null) {
				gh = (giohangbo) session.getAttribute("gio");
				session.setAttribute("gio", gh);

			} else {
				for (String checkbox : checkboxs) {
					gh = (giohangbo) session.getAttribute("gio");
					gh.TraLai(checkbox);
				}

			}
		}
		if (act != null) {
			if (act.equals("add")) {
				String tensach = request.getParameter("ts");
				long soluong = (long) 1;
				long gia = Long.parseLong(request.getParameter("gia"));
				String anh = request.getParameter("anh");

				if (session.getAttribute("gio") == null) {
					gh = new giohangbo();
					session.setAttribute("gio", gh);
				}

				gh = (giohangbo) session.getAttribute("gio");
				gh.Them(masach, tensach, soluong, gia, anh);

			} else if (act.equals("remove")) {

				gh = new giohangbo();

				if (session.getAttribute("gio") == null) {

					session.setAttribute("gio", gh);
				}

				if (act.equals("remove")) {
					gh = (giohangbo) session.getAttribute("gio");
					gh.TraLai(masach);
				}

			} else if (act.equals("update")) {
				long soluong = Long.parseLong(request.getParameter("soluong"));
				gh = new giohangbo();

				if (session.getAttribute("gio") == null) {
					session.setAttribute("gio", gh);
				}

				gh = (giohangbo) session.getAttribute("gio");
				gh.SuaSoLuong(masach, soluong);

			} else if (act.equals("clear")) {

				gh = new giohangbo();
				if (session.getAttribute("gio") == null) {
					session.setAttribute("gio", gh);
				}
				gh = (giohangbo) session.getAttribute("gio");
				gh.TraLaiTatCa();

			}
			giohangbo gio = (giohangbo) session.getAttribute("gio");
			session.setAttribute("ds", gio.ds);
		}
		response.sendRedirect("htgio");
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
