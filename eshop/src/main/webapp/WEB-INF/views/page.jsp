<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>E-Shop - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Data Table Bootstrap CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">

			<!--Home Page Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- About Page Content load here is about click -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Contact Page load here if contact menu is clicked  -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Contact Page load here if contact menu is clicked  -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProduct.jsp"%>
			</c:if>

			<!-- Show product detail page clicled-->
			<c:if
				test="${userClickShowProduct == true}">
				<%@include file="product.jsp"%>
			</c:if>
			
			<!-- Show error page -->
			<c:if
				test="${errorPageClick == true}">
				<%@include file="error.jsp"%>
			</c:if>
			
			<!-- Show Manage Product page-->
			<c:if
				test="${userClickManageProducts == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>
		</div>

		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Data table -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Data Bootstap JS -->
		<script src="${js}/dataTables.bootstrap4.js"></script>

		<!-- BootBox JS -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript file -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>
</html>
