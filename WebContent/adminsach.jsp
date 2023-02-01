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
	width: 100%;
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
					<a class="navbar-brand" href="xacnhancontroller">Xác nhận hoá
						đơn</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="loaicontroller">Loại</a></li>
					<li><a href="adminsachcontroller">Sách</a></li>
					<li><a href="daxacnhancontroller">hoá đơn đã thanh toán</a></li>
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
						<li><a><span>Xin chào, ${admin.getTenDangNhap() }!
							</span></a></li>
					</ul>
				</c:if>
			</div>
		</nav>

		<div class="container" style="margin-top: 50px;">
			<table class="table table-condensed table-responsive">
				<thead>
					<tr>
						<th style="width: 5%">Sách</th>
						<th style="width: 5%">Mã sách</th>
						<th style="width: 15%">Tên sách</th>
						<th style="width: 5%">Số tập</th>
						<th style="width: 15%">Tác giả</th>
						<th style="width: 15%">Mã loại</th>
						<th style="width: 5%">Số lượng</th>
						<th style="width: 5%">Giá</th>
						<th style="width: 15%">Ngày nhập</th>
						<th style="width: 8%">Quantity</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${dsSach }" var="s">
						<tr>
							<td data-th="Sách">
								<div class="row">
									<div class="col-md-3 text-left book-img">
										<img src="${s.getAnh() }" alt=""
											class="img-fluid  d-md-block rounded mb-2 shadow "
											style="width: 80px">
									</div>
								</div>
							</td>
							<td data-th="Mã sách">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getMasach() }</h4>
								</div>
							</td>
							<td data-th="Title">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getTensach() }</h4>
								</div>
							</td>
							<td data-th="Số tập">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getSotap() }</h4>
								</div>
							</td>
							<td data-th="Số tập">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getTacgia() }</h4>
								</div>
							</td>
							<td data-th="Mã loại">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getMaloai() }</h4>
								</div>
							</td>
							<td data-th="Số lượng">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getSoluong() }</h4>
								</div>
							</td>
							<td data-th="Price"><h4>${s.getGia() }</h4></td>
							<td data-th="Ngày nhập">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${s.getNgaynhap() }</h4>
								</div>
							</td>
							<td class="actions" data-th="">
								<div class="text-right">
									<a href="adminsachcontroller?xoa=${s.getMasach() }">xoá sách</a> 
									<a href="suasachcontroller?ms=${s.getMasach() }&ts=${s.getTensach() }&tg=${s.getTacgia() }&sl=${s.getSoluong() }&g=${s.getGia() }&a=${s.getAnh() }&ml=${s.getMaloai() }&st=${s.getSotap() }&nn=${s.getNgaynhap() }">sửa sách</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div style="text-align: center;">
		<a href="themsachcontroller"> Thêm sách</a>
	</div>
	<div class="pagination-container">
		<ul class="pagination" style="display: flex; justify-content: center;">
			<c:if test="${tag>1 }">
				<li><a href="adminsachcontroller?page=${tag-1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="1" end="${endPage }" var="i">
				<li><a class="${tag==i?'active':''}"
					href="adminsachcontroller?page=${i }">${i }</a></li>
			</c:forEach>
			<c:if test="${tag < endPage }">
				<li><a href="adminsachcontroller?page=${tag+1 }">Next</a></li>
			</c:if>
		</ul>
	</div>
	<div class="MenuTrang"></div>


</body>
</html>

