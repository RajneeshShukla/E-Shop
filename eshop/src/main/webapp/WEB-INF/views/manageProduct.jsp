<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- FORM ELEMENTS -->
					<sf:form action="" class="form-horizontal" modelAttribute="product">

						<div class="form-group">
							<label class="control-label col-md-4" for="name"> Product
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name"
									placeholder="Enter Product Name" class="form-control" />
								<em class="help-block">Please enter product Name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Brand
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand"
									placeholder="Enter Brand Name" class="form-control" />
								<em class="help-block">Please enter brand Name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Product
								Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write Product Description" class="form-control"></sf:textarea>
								<em class="help-block">Please write Product Description!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Unit
								Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice"
									placeholder="Enter Price" class="form-control" />
								<em class="help-block">Please enter brand Name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity"
									placeholder="Enter Product Quantity" class="form-control" />
								<em class="help-block">Please enter Product Quantity!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Select
								Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
									items="${categories}" itemLabel="name" itemValue="id" />
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

</div>