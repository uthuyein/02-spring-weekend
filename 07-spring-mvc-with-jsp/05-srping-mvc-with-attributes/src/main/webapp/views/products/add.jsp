<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<app:layout>
	<div class="w-50">
		<h3>
			<i class="bi bi-file-earmark"></i> Product Form
		</h3>
		<label for="" class="alert-info">${message }</label>
		<form:form action="${root }/product" method="post"
			modelAttribute="productForm">
			<div class="form-group mb-3">
				<label for="category" class="form-label">Category</label>
				<form:input type="text" path="category" class="form-control"></form:input>
				<small> <form:errors path="category" cssClass="text-danger"></form:errors>
				</small>
			</div>
			<div class="form-group mb-3">
				<label for="name" class="form-label">Product</label>
				<form:input type="text" path="name" class="form-control"></form:input>
				<small> <form:errors path="name" cssClass="text-danger"></form:errors>
				</small>
			</div>
			<div class="form-group mb-3">
				<label for="size" class="form-label">Size</label>
				<form:select type="text" path="size" class="form-control">
					<option value="">Select One</option>
					<c:forEach items="${sizes }" var="size">
						<option value="${size}">${size }</option>
					</c:forEach>
				</form:select>
				<small> <form:errors path="size" cssClass="text-danger"></form:errors>
				</small>
			</div>
			<div class="form-group mb-3">
				<label for="dtPrice" class="form-label">Detail Price</label>
				<form:input type="number" path="dtPrice" class="form-control"></form:input>
				<small> <form:errors path="dtPrice" cssClass="text-danger"></form:errors>
				</small>
			</div>
			<div class="form-group mb-3">
				<label for="wsPrice" class="form-label">Whole Sale Price</label>
				<form:input type="number" path="wsPrice" class="form-control"></form:input>
				<small> <form:errors path="wsPrice" cssClass="text-danger"></form:errors>
				</small>
			</div>
			<div class="form-group mb-3">
				<button class="btn btn-outline-primary">Save Product</button>
			</div>
		</form:form>
	</div>
</app:layout>