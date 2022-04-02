<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/pricing/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>Set Pricing</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/pricing/update" enctype="multipart/form-data">
			<div class="row">
					<div class="form-group col-md-3">
						<div class="input-group">
					      <input type="text" class="form-control" style="height: 38px" placeholder="Search" name="search">
					      <div class="input-group-btn">
					        <button class="btn btn-default border" type="button"><i class="fa fa-search"></i></button>
					      </div>
					    </div>
						<div class="form-group">
							<label for="suppliercode">Supplier</label>
							<select class="form-control" id="supplier" name="supplier">
								<c:forEach items="${data.suppliers}" var="s">
						    		<option>${s.supplierName}</option>
						    	</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="product">Product</label> 
							<select class="form-control" id="product" name="product">
								<!-- <option>Please select a Category</option> -->
							</select>
						</div>
					</div>
					<div class="form-group col-md-3 border">
						<div class="form-group">
							<label for="productcode">Cost per unit</label> <input
								class="form-control" id="unitCost" name="unitCost">
						</div>
						<div class="form-group">
							<label for="productname">Tax rate</label> <input
								class="form-control" id="taxRate" name="taxRate">
						</div>
						<div class="form-group">
							<label for="productname">Discount</label> <input
								class="form-control" id="discount" name="discount">
						</div>
					</div>
					<div class="form-group col-md-3 border">
						<div class="form-group">
							<label for="productname">Charged Price Per Unit</label> <input
								class="form-control" id="sellingPrice" name="sellingPrice">
						</div>
					</div>
			</div>
			<button type="submit" class="btn btn-primary">Set Pricing</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
	$(document).ready(function() {
		getProducts();
		
		$("#supplier").change(function() {
			getProducts();
			/* getProductDetail(); */
		});
		
		$("#product").change(function() {
			getProductDetail();
		});
	});
	/* load products for supplier */
	function getProducts(){
		$.post( "/pricing/searchProduct/"+$("#supplier :selected").val(), function( productList ) {
			 $("#product").html("");
			 for(i=0; i<productList.length; i++){
				 $("#product").append("<option>"+productList[i].productName+"</option>");
			 }
		});
	}
	/* load product detail */
	function getProductDetail(){
		$.post("/pricing/searchProductDetail/"+$("#product :selected").val(), function( product ){
			/* console.log(product.unitCost); */
			$("#unitCost").val(product.unitCost);
			$("#taxRate").val(product.taxRate);
			$("#discount").val(product.discount);
			$("#sellingPrice").val(product.sellingPrice);
		});
	}
</script>