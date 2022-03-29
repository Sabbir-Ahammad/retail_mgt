<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>Set Pricing</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/product/save" enctype="multipart/form-data">
			<div class="row">
					<div class="form-group col-md-3">
					<button class="btn btn-secondary">Scan Bar-Code</button>
						<div class="form-group">
							<label for="suppliercode">Supplier</label>
							<select class="form-control" id="supplier" name="supplier">
								<c:forEach items="${data.suppliers}" var="s">
						    		<option>${s.supplierName}</option>
						    	</c:forEach>
							</select>
						</div>
						<%-- <div class="form-group">
							<label for="category">Category</label> 
							<select class="form-control" id="category" name="category">
								<c:forEach items="${data.categories}" var="c">
									<option value="${c.code}">${c.code}<span>-</span>${c.name}</option>
								</c:forEach>
							</select> 
						</div>
						<div class="form-group">
							<label for="subcategory">Sub-Category</label> 
							<select class="form-control" id="subcategory" name="subcategory">
								<!-- <option>Please select a Category</option> -->
							</select>
						</div> --%>
						<div class="form-group">
							<label for="subcategory">Product</label> 
							<select class="form-control" id="subcategory" name="subcategory">
								<!-- <option>Please select a Category</option> -->
							</select>
						</div>
					
					</div>
					<div class="form-group col-md-3 border">
						<div class="form-group">
							<label for="productcode">Cost per unit</label> <input
								class="form-control" id="productCode" name="productCode">
						</div>
						<div class="form-group">
							<label for="productname">Tax rate</label> <input
								class="form-control" id="productName" name="productName">
						</div>
						<div class="form-group">
							<label for="productname">Discount</label> <input type="number"
								class="form-control" id="discount" name="discount">
						</div>
					</div>
					<div class="form-group col-md-3 border">
						<div class="form-group">
								<label for="productname">Charged Price Per Unit</label> <input
									class="form-control" id="productName" name="productName">
						</div>
					</div>
			</div>
			<button type="submit" class="btn btn-primary">Set Pricing</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<!-- <script type="text/javascript">
	$(document).ready(function() {
		callMe();
		$("#category").change(function() {
			callMe();
		});
	});
	
	/* load subcategory */
	function callMe(){
		$.post( "/product/searchSubcat/"+$("#category :selected").val(), function( data ) {
			 $("#subcategory").html("");
			 for(i=0; i<data.length; i++){
				 $("#subcategory").append("<option>"+data[i].subCategoryName+"</option>");
			 }
		});
	}
	
	/* view image */
	var loadFile = function(event) {
		var image = document.getElementById('output');
		image.src = URL.createObjectURL(event.target.files[0]);
	};
</script>
 -->