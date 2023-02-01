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

a.active{
	color: green;
	font-weight: bold;
}
</style>
<title>Insert title here</title>
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
	<div class="container">
		<div class="wrapper">

			<div class="wrapper-mh">
				<p class="lead">CHỦ ĐỀ SÁCH</p>
				<div class="list-group">
					<c:forEach items="${loai }" var="l">
					<a class="list-group-item" href="ChuDeSach?ml=${l.getMaloai() }">
						${l.getTenloai() }</a>
					</c:forEach>
				</div>
			</div>


			<div class="sach-moi">
				<c:forEach items="${dsSach }" var="s">
				<div class="sach-item" style="width: 280px">
					<div class="avt">
						<img src="${s.getAnh() }" alt="avatar" class="sach-img" />
					</div>

					<h3 class="sach-name">${s.getTensach() }</h3>
					<a
						href="GioHang?act=add&ms=${s.getMasach()}&ts=${s.getTensach()}&gia=${s.getGia()}&anh=${s.getAnh()}">
						<img class="buy-sach" alt="" src="buynow.jpg">
					</a>
				</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<div class="pagination-container">
		<ul class="pagination" style="display: flex; justify-content: center;">
			<c:if test="${tag>1 }">
				<li><a href="ChuDeSach?page=${tag-1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="1" end="${endPage }" var="i">
				<li><a class="${tag==i?'active':''}"
					href="ChuDeSach?page=${i }">${i }</a></li>
			</c:forEach>
			<c:if test="${tag < endPage }">
				<li><a href="ChuDeSach?page=${tag+1 }">Next</a></li>
			</c:if>
		</ul>
	</div>
	<div class="MenuTrang"></div>
	
</body>
</html>