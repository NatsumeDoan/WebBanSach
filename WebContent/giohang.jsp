<%@page import="java.util.Enumeration"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String act = request.getParameter("act");
		String masach = request.getParameter("ms");

		giohangbo gh;

		gh = new giohangbo();

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
				response.sendRedirect("htgio.jsp");
			} else {
				for (String checkbox : checkboxs) {
					gh = (giohangbo) session.getAttribute("gio");
					gh.TraLai(checkbox);
				}
				response.sendRedirect("htgio.jsp");
			}
		} else {
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
				response.sendRedirect("htgio.jsp");
			} else if (act.equals("remove")) {

				gh = new giohangbo();

				if (session.getAttribute("gio") == null) {

					session.setAttribute("gio", gh);
				}

				if (act.equals("remove")) {
					gh = (giohangbo) session.getAttribute("gio");
					gh.TraLai(masach);
				}
				response.sendRedirect("htgio.jsp");
			} else if (act.equals("update")) {
				long soluong = Long.parseLong(request.getParameter("soluong"));
				gh = new giohangbo();

				if (session.getAttribute("gio") == null) {
					session.setAttribute("gio", gh);
				}

				gh = (giohangbo) session.getAttribute("gio");
				gh.SuaSoLuong(masach, soluong);
				response.sendRedirect("htgio.jsp");
			} else if (act.equals("clear")) {

				gh = new giohangbo();
				if (session.getAttribute("gio") == null) {
					session.setAttribute("gio", gh);
				}
				gh = (giohangbo) session.getAttribute("gio");
				gh.TraLaiTatCa();
				response.sendRedirect("htgio.jsp");
			}
		}
		session.setAttribute("gio", gh);
	%>
</body>
</html>