<%@page import="bo.giohangbo"%>
<%@page import="bean.giohangbean"%>
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
	justify-content: space-between;
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
	flex: 0 0 60%;
	max-width: 80%;
}

.sach-item {
	background-color: #e3e3e3;
	border-radius: 20px;
	padding: 20px;
	cursor: pointer;
	margin-right: 15px;
	margin-bottom: 30px;
}

.sach-img {
	width: 100%;
	height: 200px;
	border-radius: 20px;
}

.avt {
	text-align: center;
}

img {
	object-fit: cover;
}

.sach-tacgia, .sach-gia {
	font-size: 18px;
}

.sinhvien-name {
	text-align: center;
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
	flex: 0 0 11%;
}

.book-img {
	width: 90px;
}

.btn-group-lg>.btn, .btn-lg {
	padding: 2px 27px;
	font-size: 18px;
	line-height: 1.3333333;
	border-radius: 6px;
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
				<li><a href="lsuctroller?tendn=${DangNhap}&act=null">Lịch
						sử mua hàng</a></li>
			</ul>
			<div class="nav navbar-nav">
				<form action="ChuDeSach" method="get"
					style="display: flex; padding-top: 10px;">
					<input class="form-control" type="text" name="timkiem"
						placeholder="Nhập giá trị tìm kiếm"> <input
						class="btn-primary" type="submit" value="Tìm kiếm">
				</form>
			</div>

			<c:if test="${DangNhap==null }">

				<ul class="nav navbar-nav navbar-right">
					<li><a href="sign_up"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</c:if>
			<c:if test="${DangNhap!=null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout"><span
							class="glyphicon glyphicon-user"></span> Log Out</a></li>
					<li><a><span>Xin chào, ${DangNhap }! </span></a></li>
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

			<form action="GioHang" method="GET" id="my_form"></form>
			<div class="container">
				<table class="table table-condensed table-responsive">
					<thead>
						<tr>
							<c:if test="${not empty gio }">
								<th style="width: 5%"><input type="submit" form="my_form"
									value="Xóa" class="form-control btn-primary"
									name="submit_XoaCheckBox"></th>
							</c:if>
							<th style="width: 20%">Product</th>
							<th style="width: 30%">Title</th>
							<th style="width: 10%">Price</th>
							<th style="width: 10%">Quantity</th>
							<th style="width: 18%"></th>
						</tr>
					</thead>

					<tbody>
						<c:if test="${not empty gio }">
							<c:forEach items="${ds }" var="h">
								<tr>
									<td><input type="checkbox" form="my_form"
										name="checkbox-delete" value=${h.getMaSach() }></td>
									<td data-th="Product">
										<div class="row">
											<div class="col-md-3 text-left book-img">
												<img src="${h.getAnh() }" alt=""
													class="img-fluid  d-md-block rounded mb-2 shadow "
													style="width: 120px">
											</div>
										</div>
									</td>
									<td data-th="Title">
										<div class="col-md-9 text-left mt-sm-2">
											<h4>${h.getTenSach() }</h4>
										</div>
									</td>
									<td data-th="Price"><h4>${h.getGia() }</h4></td>

									<td data-th="Quantity"><input type="number"
										class="form-control form-control-lg text-center"
										id=${h.getMaSach() } value=${h.getSoluong() }></td>
									<td class="actions" data-th="">
										<div class="text-right">
											<a href="#"
												onclick="location.href='GioHang?act=update&soluong='+document.getElementById('${h.getMaSach() }').value+'&ms=${h.getMaSach() }'">
												Cập nhật </a> <a href="GioHang?act=remove&ms=${h.getMaSach() }">
												Trả lại</a>

										</div>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="float-right text-right">
					<c:if test="${not empty gio }">
						<span>(Tổng số: <b>${ds.size() }</b> sản phẩm)
						</span>
						<h2>
							<b>Tổng tiền:${gio.TongTien() }</b>
						</h2>
					</c:if>
				</div>
				<div class="row mt-4 d-flex align-items-center">
					<div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-right"
						style="display: flex; padding: 10px 50px 10px 120px;">
						<c:if test="${not empty gio }">
							<a href="ChuDeSach" class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
								style="margin: 10px;">Tiếp tục mua hàng</a>
							<a href="GioHang?act=clear"
								class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
								style="margin: 10px;">Trả lại tất cả</a>
							<a href="lsuctroller?tendn=${DangNhap }&act=add"
								class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
								style="margin: 10px;">Xác nhận đặt hàng</a>
						</c:if>
						<c:if test="${empty gio }">
							<p>Giỏ hàng đang trống. Mời bạn</p>
							<a href="ChuDeSach" class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
								style="margin: 10px;">Chọn mua hàng</a>
						</c:if>
					</div>
				</div>
			</div>

			

		</div>
	</div>

</body>
</html>