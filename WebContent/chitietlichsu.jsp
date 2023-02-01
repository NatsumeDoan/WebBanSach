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
				<li><a href="lsuctroller?tendn=${DangNhap }&act=null">Lịch sử mua hàng</a></li>
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
						<th style="width: 4%">STT</th>
						<th style="width: 12%">Sản phẩm</th>
						<th style="width: 30%">Tên sách</th>
						<th style="width: 12%">Đơn giá</th>
						<th style="width: 12%">Số lượng</th>
						<th style="width: 12%">Số tiền</th>
						<th style="width: 12%">Đã mua</th>
					</tr>
				</thead>

				<tbody>
					<c:set var="i" value="0"></c:set>
					<c:forEach items="${chitiet}" var="c">
					<c:set var="i" value="${i+1}"></c:set>
					<tr>	
						<td data-th="STT">
							<h4 style="margin-top: 30px">${i}</h4>
						</td>
						<td data-th="Sản phẩm">
							<img src="${c.getAnh()}" style="width: 160px;height: 160px;">
						</td>
						<td data-th="Tên sách">
							<h4 style="margin-top: 30px">${c.getTensach()}</h4>
						</td>
						<td data-th="Đơn giá">
							<h4 style="margin-top: 30px">${c.getGia()}</h4>
						</td>
						<td data-th="Số lượng">
							<h4 style="margin-top: 30px">${c.getSoluong()}</h4>
						</td>
						<td data-th="Số tiền">
							<h4 style="margin-top: 30px">${c.getSoluong()*c.getGia()}</h4>
						</td>
						<td data-th="Số tiền">
							<c:if test="${c.isDamua()==false}">
								<h4 style="margin-top: 30px">Chưa thanh toán</h4>
							</c:if>
							<c:if test="${c.isDamua()}">
								<h4 style="margin-top: 30px">Đã thanh toán</h4>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</td>
		
	</table>
</body>
</html>