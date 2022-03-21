<jsp:include page="/WEB-INF/view/common/header.jsp" />
<div>
	<div style="text-align: center;">
		<h1>Add New Product</h1>
	</div>
	<div>
		<form>
		  <div class="form-row">
			  <div class="form-group col-md-6">
			      <label for="productcode">Product code</label>
			      <input class="form-control" id="productcode" placeholder="Product code">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="productname">Product Name</label>
			      <input class="form-control" id="productname" placeholder="Product Name">
			    </div>
		  </div>
		  <div class="form-row">
			  <div class="form-group col-md-6">
			      <label for="categorycode">Category code</label>
			      <input class="form-control" id="categorycode" placeholder="Category code">
			      <label for="categoryname">Category Name</label>
			      <input class="form-control" id="categoryname" placeholder="Category Name">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="suppliercode">Supplier code</label>
			      <input class="form-control" id="suppliercode" placeholder="Supplier code">
			      <label for="suppliername">Supplier Name</label>
			      <input class="form-control" id="suppliername" placeholder="Supplier Name">
			    </div>
		  </div>
		  <div class="form-group col-md-6">
			      <label for="tags">Tags</label>
			      <input class="form-control" id="tags" placeholder="Tags">
		  </div>
		  <div class="form-group col-md-6">
			      <label for="tags">image</label>
			      <input class="form-control" id="image" placeholder="Tags" >
		  </div>
		  <button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
