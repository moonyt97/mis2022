<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>대맛탱에 오신걸 환영합니다</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: Restaurantly - v3.7.0
  * Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script type="text/javascript" src="script/join.js"></script>
</head>

<body>
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top d-flex align-items-cente">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

		<h1 class="logo me-auto me-lg-0">
			<a href="index.jsp">대맛탱</a>
		</h1>
		<!-- Uncomment below if you prefer to use an image logo -->
		<!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

		<nav id="navbar" class="navbar order-last order-lg-0">
		<ul>
			<li><a class="nav-link scrollto active" href="index.jsp">Home</a></li>
			<li><a class="nav-link scrollto" href="DeDukGu.do">대덕구</a></li>
			<li><a class="nav-link scrollto" href="DongGu.do">동구</a></li>
			<li><a class="nav-link scrollto" href="SeoGu.do">서구</a></li>
			<li><a class="nav-link scrollto" href="YuSungGu.do">유성구</a></li>
			<li><a class="nav-link scrollto" href="JungGu.do">중구</a></li>
			<li><a class="nav-link scrollto" href="Notice.do">공지사항</a></li>
			<!-- <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li> -->
			<!--  <li><a class="nav-link scrollto" href="#contact">Contact</a></li> -->
		</ul>
		<i class="bi bi-list mobile-nav-toggle"></i> </nav>
		<!-- .navbar -->
		<c:choose>
			<c:when test="${loginUser!=null}">
				<div style="display: flex">
					<a href="Userupdate.do" style="text-transform: none;"
						onMouseOver="this.innerHTML='정보수정'"
						onMouseOut="this.innerHTML='${loginUser.memberId}'"
						class="book-a-table-btn scrollto d-none d-lg-flex changeContent">${loginUser.memberId}
					</a> <a href="Logout.do" class="book-a-table-btn  d-none d-lg-flex">로그아웃
					</a>
					<a href="LikeList.do" class="book-a-table-btn  d-none d-lg-flex">♥
				</a>
				</div>
			</c:when>
			<c:otherwise>
				<a href="Login.do"
					class="book-a-table-btn scrollto d-none d-lg-flex">로그인/ 회원가입 </a>

			</c:otherwise>
		</c:choose>

	</div>
	</header>
	<!-- End Header -->

	<main id="main"> <section id="DeDukGu" class="DeDukGu">
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h2>대덕구</h2>
			<div class="section-title-register">
				<p>대덕구 맛집</p>
				<c:choose>
					<c:when test="${loginUser.memberAdmin eq '0'} ">
						<span></span>
					</c:when>
					<c:when test="${loginUser.memberAdmin eq '1'}">
						<a href="dedukguregister.do">게시판 등록</a>
					</c:when>
				</c:choose>

			</div>
		</div>

		<div class="row">
			<c:forEach var="store" items="${list}">
				<div class="col-lg-4 col-md-6">
					<div class="member" data-aos="zoom-in" data-aos-delay="100">
						<img src="${store.storeImg}" style="width:300px; height:300px" class="img-fluid" alt="">
						<div class="member-info">
							<div class="member-info-content">
								<h4>${store.storeTitle}</h4>
								<span>${store.memberId}</span>
							</div>
							<div class="social">
								<a href="dedukgustoreDetail.do?num=${store.storeNo}">상세페이지로
									이동</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	</section> </main>




	<!— Vendor JS Files —>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<!-- <script src="assets/vendor/php-email-form/validate.js"></script> -->

	<!— Template Main JS File —>
	<script src="assets/js/main.js"></script>
</body>
</html>