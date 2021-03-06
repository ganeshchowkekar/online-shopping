<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping- ${title}</title>

<script>
	window.menu = '${title}'
	window.contextRoot='${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!--Jquery data table CSS  -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">



</head>
<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<!-- home page content -->
		<div class="content">
			<c:if test="${userClicksHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about us -->
			<c:if test="${userClicksAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks about us -->
			<c:if test="${userClicksContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when user clicks all products or category products -->
			<c:if
				test="${userClicksAllProducts==true or userClicksCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks show product -->
			<c:if test="${userClicksShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!--JS -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/popper.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- JQuery DATA Table Plugin  -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>

		<!-- self coded JS -->
		<script src="${js}/myapp1.js"></script>   

	</div>
</body>
</html>
