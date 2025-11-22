<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<app:layout>
	<h3 class="mb-3">
		<i class="bi bi-cart"></i> Shopping Cart
	</h3>
	<table class="table table-borderd table-hover">
		<thead>
			<tr>
				<th></th>
				<th>Category</th>
				<th>Product</th>
				<th class="text-end">Price</th>
				<th class="text-center">Quentity</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.items }" var="item" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${item.product.category.name }</td>
					<td>${item.product.name }</td>
					<td class="text-end">${item.price }</td>
					<td class="text-center">
					<a href="${root }/checkout/minus/${item.product.id}" class="icon-link text-danger"> <i class="bi bi-dash"></i></a>
					 ${item.qty }
					<a href="${root }/checkout/add/${item.product.id}" class="icon-link text-success"> <i class="bi bi-plus"></i></a>
					</td>
					<td class="text-end">${item.qty*item.price }</td>

				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" class="text-end">Total</td>
				<td class="text-center">${cart.totalItems }</td>
				<td class="text-end">${cart.totalItemsAmount }</td>
			</tr>
		</tfoot>
	</table>
	<div class="d-flex justify-content-end">
		<a href="${root }/checkout/clear" class="btn btn-outline-primary me-2">Clear</a> 
		<a href="${root }/checkout/checkout" class="btn btn-outline-success">Checkout</a>
	</div>
</app:layout>