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
						<th style="width: 2%">STT</th>
						<th style="width: 15%">Mã loại</th>
						<th style="width: 15%">Tên loại</th>
						<th style="width: 8%">Sửa loại</th>
						<th style="width: 5%">Xoá loại</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="j" value="0"></c:set>
					<c:forEach items="${loai }" var="l">
						<c:set var="j" value="${j+1}"></c:set>
						<tr>
							<td data-th="STT">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${j}</h4>
								</div>
							</td>
							<td data-th="Mã loại">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${l.getMaloai() }</h4>
								</div>
							</td>
							<td data-th="Tên loại">
								<div class="col-md-9 text-left mt-sm-2">
									<h4>${l.getTenloai() }</h4>
								</div>
							</td>
							<td data-th="Sửa loại">
								<div class="col-md-9 text-left mt-sm-2">
									<a
										href="sualoaicontroller?ml=${l.getMaloai() }&tl=${l.getTenloai() }"><h4>Sửa
											loại</h4></a>
								</div>
							</td>
							<td data-th="Xoá loại">
								<div class="col-md-9 text-left mt-sm-2">
									<a href="loaicontroller?ml=${l.getMaloai() }"><h4>Xoá
											loại</h4></a>
								</div>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<div style="margin-bottom: 30px; text-align: center;">
		<a data-toggle="modal" data-target="#myModal"><h4>Thêm loại</h4></a>
	</div>
	<c:if test="${tl =='ko co'}">
		<b>mã loại đã tồn tại thêm loại thất bại</b>
	</c:if>
	<!-- The Modal -->
	<form method="Post" action="loaicontroller">
		<input type="hidden" name="method" value="addloai">
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header" style="text-align: center;">
						<h4 class="modal-title">Thêm loại</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group">
							<label for="maloai">Mã loại</label> <input class="form-control"
								placeholder="Nhập Mã Loại" name="mloai">
						</div>
						<div class="form-group">
							<label for="tenloai">Tên Loại</label> <input class="form-control"
								placeholder="Nhập Tên Loại" name="tloai">
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
