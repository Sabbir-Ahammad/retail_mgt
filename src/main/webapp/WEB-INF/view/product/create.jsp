<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-5">
		<div style="text-align: center;">
			<h4>Add New Product</h4>
		</div>
		<form id="productAddForm" name="productAddForm" method="post"
			action="/product/save" enctype="multipart/form-data">
			<label for="suppliercode">Supplier</label>
			<div class="form-row">
				<div class="form-group col-md-6">
					<select class="form-control" id="supplier" name="supplier">
						<c:forEach items="${data.suppliers}" var="s">
				    		<option value="${s.supplierCode}">${s.supplierName}</option>
				    	</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="category">Category</label> 
					<select class="form-control" id="category" name="category">
						<c:forEach items="${data.categories}" var="c">
							<option value="${c.code}">${c.code}<span>-</span>${c.name}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="form-group col-md-6">
					<label for="subcategory">Sub-Category</label> 
					<select class="form-control" id="subcategory" name="subcategory">
						<!-- <option>Please select a Category</option> -->
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="productcode">Product code</label> <input
						class="form-control" id="productCode" name="productCode" placeholder="Product code">
				</div>
				<div class="form-group col-md-6">
					<label for="productname">Product Name</label> <input
						class="form-control" id="productName" name="productName" placeholder="Product Name">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-12">
					<label for="tags">image</label> <input class="form-control"
						id="image" type="file" name="image" onchange="loadFile(event)" />
					<div class="form-group col-md-12 mt-2"><img class="center-block" id="output" width="200px" /></div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
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
				 $("#subcategory").append("<option value="+data[i].subCategoryCode+">"+data[i].subCategoryName+"</option>");
			 }
		});
	}
	
	/* view image */
	var loadFile = function(event) {
		var image = document.getElementById('output');
		image.src = URL.createObjectURL(event.target.files[0]);
	};
</script>
