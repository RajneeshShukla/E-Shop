<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<c:if test="${not empty alertMsg }">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${alertMsg}
				</div>
			</div>
		</c:if>

		<c:if test="${not empty errorMsg }">
			<div class="col-xs-12">
				<div class="alert  alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${errorMsg}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name"> Product
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name"
									placeholder="Enter Product Name" class="form-control" />
								<sf:errors path="name" element="em" cssClass="help-block" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Brand
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand"
									placeholder="Enter Brand Name" class="form-control" />
								<sf:errors path="brand" element="em" cssClass="help-block" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Product
								Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write Product Description" class="form-control"></sf:textarea>
								<sf:errors path="description" element="em" cssClass="help-block" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Unit
								Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice"
									placeholder="Enter Price" class="form-control" />
								<sf:errors path="unitPrice" element="em" cssClass="help-block" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity"
									placeholder="Enter Product Quantity" class="form-control" />
								<sf:errors path="quantity" element="em" cssClass="help-block" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="name">Upload
								Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" element="em" cssClass="help-block" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Select
								Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
							</div>
						</div>

						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
						<sf:hidden path="active" />
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>

		<div class="col-xs-12">
			<div style="overflow: auto;">
				<table id="adminProductsTable"
					class="table table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qty. Avail</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>


					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qty. Avail</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>


				</table>
			</div>
		</div>
	</div>
</div>