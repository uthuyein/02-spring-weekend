<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<app:layout>
	<h3>
		<i class="bi bi-file-earmark"></i> Product Form
	</h3>
	<form:form action="" method="post" modelAttribute="productForm">
		<div class="form-group">
			<label for="category" class="form-label"></label>
			<form:input type="text" path="category" class="form-control"></form:input>
			<%-- <small>
				<form:errors path="category" cssStyle="text-danger"></form:errors>
			</small> --%>
		</div>
		<div class="form-group">
			<label for="name" class="form-label"></label>
			<form:input type="text" path="name" class="form-control"></form:input>
			<%-- <small>
				<form:errors path="name" cssStyle="text-danger"></form:errors>
			</small> --%>
		</div>
		<div class="form-group">
			<label for="size" class="form-label"></label>
			<form:select type="text" path="size"  class="form-control">
				<option value="">Select One</option>
				<c:forEach items="${sizes }" var="s">
					<option value="${s}"></option>
				</c:forEach>
			</form:select>
			<%-- <small>
				<form:errors path="name" cssStyle="text-danger"></form:errors>
			</small> --%>
		</div>
		<div class="form-group">
			<label for="dtPrice" class="form-label"></label>
			<form:input type="number" path="dtPrice" class="form-control"></form:input>
			<%-- <small>
				<form:errors path="dtPrice" cssStyle="text-danger"></form:errors>
			</small> --%>
		</div>
		<div class="form-group">
			<label for="wsPrice" class="form-label"></label>
			<form:input type="number" path="wsPrice" class="form-control"></form:input>
			<%-- <small>
				<form:errors path="wsPrice" cssStyle="text-danger"></form:errors>
			</small> --%>
		</div>
		<div class="form-group">
			<button class="btn btn-outline-primary">Save Product</button>
		</div>
	</form:form>
</app:layout>