<%@page import="bean.xacnhanbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.wrapper {
	display: flex;
	align-items: stretch;
	/* justify-content: space-between; */
	padding-top: 100px;
}

.navbar {
	position: fixed;
	right: 0;
	left: 0;
}

.sach-moi {
	display: flex;
	flex-wrap: wrap;
	/* flex: 0 0 60%; */
	max-width: 80%;
}

.sach-item {
	background-color: #e3e3e3;
	border-radius: 12px;
	padding: 20px;
	cursor: pointer;
	margin-right: 15px;
	margin-bottom: 30px;
	text-align: center;
}

.sach-img {
	width: 100%;
	height: 270px;
	border-radius: 12px;
}

.avt {
	text-align: center;
}

img {
	object-fit: cover;
}

.buy-sach {
	
}

.sach-tacgia, .sach-gia {
	font-size: 18px;
}

.sach-name {
	text-align: center;
	margin: 10px 0;
}

.container {
	width: 1440px;
	margin: 0 auto;
	padding: 0 15px;
}

.wrapper-mh {
	flex: 0 0 20%;
	max-width: 20%;
	padding-right: 25px;
	/* z-index: -1; */
}

.tim-kiem {
	display: flex;
	flex: 0 0 20%;
}

.MenuTrang li {
	display: inline;
}

a.active {
	color: green;
	font-weight: bold;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div style="display: flex;">
		<nav class="navbar navbar-inverse" style="position: absolute;">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="xacnhancontroller">X??c nh???n ho??
						????n</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="loaicontroller">Lo???i</a></li>
					<li><a href="adminsachcontroller">S??ch</a></li>
					<li><a href="daxacnhancontroller">ho?? ????n ???? thanh to??n</a></li>
				</ul>
				<c:if test="${admin.getTenDangNhap() ==null }">

					<ul class="nav navbar-nav navbar-right">
						<li><a href="dangnhapadminController"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>
				</c:if>
				<c:if test="${admin.getTenDangNhap() !=null }">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logoutadmin"><span
								class="glyphicon glyphicon-user"></span> Log Out</a></li>
						<li><a><span>Xin ch??o, ${admin.getTenDangNhap() }!
							</span></a></li>
					</ul>
				</c:if>
			</div>
		</nav>
		<div class="container" style="margin-top: 50px; width: 50%">
			<form method="post" action="sualoaicontroller" class="add-form">
				<h2 style="border-bottom: 1px solid red">S???a lo???i</h2>
				<div class="form-group">
					M?? lo???i: <input type="text" name="txtml" value="${maloai }"
						class="form-control">
				</div>
				<input type="hidden" name="txtmlc" value="${maloai }"
					class="form-control">
				<div class="form-group">
					T??n loai: <input type="text" name="txttl" value="${tenloai }"
						class="form-control">
				</div>
				<br> <input type="submit">
			</form>
		</div>
	</div>
</body>
</html>