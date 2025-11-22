<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<app:layout>
	<h3 class="mb-3"><i class="bi bi-file-earmark"></i> Product List</h3>
	<form action="${root }/product/search">
		<div class="row g-1 align-items-center">
			<div class="col-8">
				<input type="text" class="form-control" placeholder="Search ..." />
			</div>
			<div class="col-auto me-3">
				<button class="btn btn-outline-primary rounded-pill">
					<i class="bi bi-search"></i>
				</button>

			</div>
			<div class="col-auto">
				<a href="${root }/product/add" class="btn btn-outline-success rounded-pill"><i
					class="bi bi-plus"></i> Add New Product</a>
			</div>
		</div>
	</form>
	<c:choose>
		<c:when test="${products.size() > 0 }">
			<div class="col mt-3">
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
								<td class="text-center"><a href="${root }/cart/add/${p.id()}" class="icon-link"><i class="bi bi-cart"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning mt-3">
				 <p class="text-danger"> There is no product yet !</p>
			</div>
		</c:otherwise>
	</c:choose>
	

</app:layout>