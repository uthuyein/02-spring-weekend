<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout>
	<h3>Product List</h3>
	<div class="row">
		<div class="col">
			<form action="${root }/product/search">
				<input type="text" class="form-control" placeholder="Search ..." />
				<button class="btn btn-outline-primary">
					<i class="bi bi-search"></i>
				</button>
			</form>
		</div>
		<div class="col">
			<a href="${root }/product/add" class="btn btn-outline-success"><i class="bi bi-plus"></i></a>
		</div>
	</div>
</app:layout>