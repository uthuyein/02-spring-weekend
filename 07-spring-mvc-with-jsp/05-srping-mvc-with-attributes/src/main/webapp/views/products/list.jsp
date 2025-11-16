<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<app:layout>
	<h3>Product List</h3>
	<form action="${root }/product/search">
		<div class="row g-2 align-items-center">
			<div class="col-6">
				<input type="text" class="form-control" placeholder="Search ..." />
			</div>
			<div class="col-auto">
				<button class="btn btn-outline-primary">
					<i class="bi bi-search"></i>
				</button>

			</div>
			<div class="col-auto">
				<a href="${root }/product/add" class="btn btn-outline-success"><i
					class="bi bi-plus"></i></a>
			</div>
		</div>
	</form>

	<c:if test="${products.size() ge 0 }">
		
			<div class="col mt-3">
			
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Category</th>
							<th>Product</th>
							<th>Detail Price</th>
							<th>Whole Sale</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="p" varStatus="i">
							<tr>
								<td>${i.count }</td>
								<td>${p.category() }</td>
								<td>${p.name() }</td>
								<td>${p.dtPrice() }</td>
								<td>${p.wsPrice() }</td>
								<td><a href="${root }/cart/add/${p.id()}" class="icon-link"><i class="bi bi-cart"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>

</app:layout>