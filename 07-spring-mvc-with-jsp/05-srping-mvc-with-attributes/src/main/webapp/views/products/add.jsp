<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<app:layout>
	<h3 class="mb-3">
		<i class="bi bi-file-earmark"></i> Product Form
	</h3>
	<c:if test="${message ne null }">
		<div class="alert alert-info">${message }</div>
	</c:if>
	<div class="row">
		<div class="col-5">
			<form:form action="${root }/product" method="post"
				modelAttribute="productForm">
				<form:hidden path="id" />
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
							<option value="${size}"
								${param.size eq size ? 'selected="selected"': productForm.size eq size ? 'selected="selected"':''}>${size }</option>
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
				<div class="form-group mb-3 d-flex justify-content-end">
					<button class="btn btn-outline-primary">Save Product</button>
				</div>
			</form:form>
		</div>

		<c:if test="${products.size() ne 0 }">
			<div class="col mt-3">
				<label for=""></label>

				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Category</th>
							<th>Product</th>
							<th class="text-end">Detail Price</th>
							<th class="text-end">Whole Sale</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="p" varStatus="i">
							<tr>
								<td class="text-end">${i.count }</td>
								<td>${p.category() }</td>
								<td>${p.name() }</td>
								<td class="text-end">${p.dtPrice() }</td>
								<td class="text-end">${p.wsPrice() }</td>
								<td class="text-center"><a href="${root }/product/edit/${p.id()}"
									class="icon-link"><i class="bi bi-pencil"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>

</app:layout>