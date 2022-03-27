<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-5">
		<div style="text-align: center;">
			<h4>Add New Product</h4>
		</div>
		<form id="productAddForm" name="productAddForm" method="post"
			action="/product/update" enctype="multipart/form-data">
			<label for="suppliercode">Supplier</label>
			<div class="form-row">
				<div class="form-group col-md-6">
					<select class="form-control" id="supplierName" name="supplierName">
						<c:forEach items="${data.suppliers}" var="s">
				    		<option>${s.supplierName}</option>
				    	</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="category">Category</label> 
					<select class="form-control" id="categoryName" name="categoryName">
						<c:forEach items="${data.categories}" var="c">
							<option value="${c.code}">${c.code}<span>-</span>${c.name}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="form-group col-md-6">
					<label for="subcategory">Sub-Category</label> 
					<select class="form-control" id="subCategoryName" name="subCategoryName">
						<!-- <option>Please select a Category</option> -->
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="productcode">Product code</label>
					<input
						type="hidden" class="form-control" id="id" name="id" value="${data.product.id}">
					<input
						class="form-control" id="productCode" name="productCode" value="${data.product.productCode}">
				</div>
				<div class="form-group col-md-6">
					<label for="productname">Product Name</label> <input
						class="form-control" id="productName" name="productName" placeholder="Product Name" value="${data.product.productName}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-12">
					<label for="tags">image</label> <input class="form-control"
						id="image" type="file" name="image" onchange="loadFile(event)" src="${data.imgLocation} + '\\' + ${data.product.productImage}"/>
					<div class="form-group col-md-12 mt-2"><img class="center-block" id="output" width="200px" /></div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Update Product</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
	$(document).ready(function() {
		callMe();
		$("#categoryName").change(function() {
			callMe();
		});
	});
	
	/* load subcategory */
	function callMe(){
		$.post( "/product/searchSubcat/"+$("#categoryName :selected").val(), function( data ) {
			 $("#subCategoryName").html("");
			 for(i=0; i<data.length; i++){
				 $("#subCategoryName").append("<option>"+data[i].subCategoryName+"</option>");
			 }
		});
	}
	
	/* view image */
	var loadFile = function(event) {
		var image = document.getElementById('output');
		image.src = URL.createObjectURL(event.target.files[0]);
	};
	
	var catCode =  "${data.catCode}";
	$("#categoryName option[value='"+catCode+"']").attr("selected", true);
	var subCatName =  "${data.product.subCategoryName}";
	$("#subCategoryName option[value='"+subCatName+"']").attr("selected", true);
	var supName =  "${data.product.supplierName}";
	$("#supplierName option[value='"+supName+"']").attr("selected", true);
</script>
