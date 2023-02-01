<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Lịch sử mua hàng</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.book {
	display: inherit;
	background-color: #cbcbcb;
	border-radius: 20px;
	padding: 20px;
	cursor: pointer;
}

.book-img {
	width: 234px;
	height: 264px;
	border-radius: 10px;
}
.list-items {
	display: block;
	width: 100%;
	height: 40px;
	padding: 8px 10px;
	border: 1px solid #ccc;
	color: #000;
	}
	
.list-items:hover {
	text-decoration: none;
	background-color: #d3d3d3;
	color: #000;
	font-weight: 600;
	
}
.payment{
	width:100%;
	height:70px;
	display:flex;
	justify-content: space-evenly;
	position:fixed;
	bottom: 0;
	right:0;
	left: 0;
	border-top:1px solid #ccc;
	background-color: #fff;
	z-index: 30;
}
.text-right{
	width:30%;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="ChuDeSach">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="GioHang">Giỏ hàng</a></li>
				<li><a href="#">Thanh toán</a></li>
				<li><a href="lsuctroller?tendn=${DangNhap}&act=null">Lịch sử mua hàng</a></li>
			</ul>
			<div class="nav navbar-nav">
				<form action="ChuDeSach" method="get" style="display: flex;padding-top: 10px;">
					<input class="form-control" type="text" name="timkiem"
						placeholder="Nhập giá trị tìm kiếm"> <input
						class="btn-primary" type="submit" value="Tìm kiếm">
				</form>
			</div>

			<c:if test="${DangNhap==null }">
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="sign_up"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			</c:if>
			<c:if test="${DangNhap!=null }">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><span
						class="glyphicon glyphicon-user"></span> Log Out</a></li>
				<li><a><span>Xin chào, ${DangNhap }!
					</span></a></li>
			</ul>
			</c:if>		
		</div>
	</nav>

	<table width="1000" align="center" class="table">
		
		<td valign="top" width="800">
		<form action="giohangController" method="GET" id="my_form"></form>
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="width: 10%">Mã hoá đơn</th>
						<th style="width: 30%">Ngày mua</th>
						<th style="width: 30%">Xem chi tiết</th>
					</tr>
				</thead>

				<tbody>		
					<c:forEach items="${lsu }" var="l">
					<tr>	
						<td data-th="Tên sách">
							<h4 style="margin-top: 30px">${l.getMahd()}</h4>
						</td>
						<td data-th="Đơn giá">
							<h4 style="margin-top: 30px">${l.getNgaymua()}</h4>
						</td>
			
						<td data-th="Xem chi tiết">
							<div style="padding-top: 17px;">
							<a href="chitietlichsu?mahd=${l.getMahd()}" style="margin-top: 30px">Xem chi tiết</a>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</td>
	</table>
	<div class="row mt-4 d-flex align-items-center" style="justify-content: center;display: flex;">
					<div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-right"
						style="display: flex; padding: 10px 50px 10px 120px;">
						<c:if test="${DangNhap==null }">
						<p style=" padding-top: 20px;">Không thể xem khi chưa đăng nhập</p>
						<a href="login" class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
							style="margin: 10px;">Login</a>
						</c:if>
					</div>
				</div>
</body>
</html>