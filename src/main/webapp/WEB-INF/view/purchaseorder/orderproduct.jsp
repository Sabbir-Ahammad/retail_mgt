<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>Add a purchase order</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/product/save" enctype="multipart/form-data">
			<div class="row">
					<div class="form-group col-md-2">
						<div class="form-group">
							<label for="suppliercode">Lot number</label>
							<input class="form-control" id="lotNumber" name="lotNumber"/>
						</div>
						<div class="form-group">
							<label for="productcode">Product</label> <input
								class="form-control" id="productName" name="productName">
						</div><div class="form-group">
							<label for="productcode">Description</label> <input
								class="form-control" id="description" name="description">
						</div>
					</div>
					<div class="form-group col-md-3">
						<div class="form-group">
							<label for="productcode">Price</label> <input
								class="form-control" id="price" name="price">
						</div>
						<div class="row">
						<div class="form-group col-md-12"><label for="productcode">Discount</label> </div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="discountPercent" name="discountPercent">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="discount" name="discount">
								</div>
							</div>
						</div>
						<div class="row">
						<div class="form-group col-md-12"><label for="productcode">Tax</label> </div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="taxPercent" name="taxPercent">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="tax" name="tax">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="productname">Charged Price</label> <input
								class="form-control" id="chargedPrice" name="chargedPrice">
						</div>
						<div class="form-group">
							<label for="productname">Purchase Amount</label> <input
								class="form-control" id="purchaseAmount" name="purchaseAmount">
						</div>
					</div>
					<div class="form-group col-md-7">
					<div class="row">
						<div class="form-group col-md-4">
							<div class="form-group">
							<label for="suppliercode">Supplier</label>
							<select class="form-control" id="supplier" name="supplier">
								<c:forEach items="${data.suppliers}" var="s">
						    		<option>${s.supplierName}</option>
						    	</c:forEach>
							</select>
						</div>
						</div>
						<div class="form-group col-md-4">
							<div class="form-group">
							<label for="category">Category</label> 
							<select class="form-control" id="category" name="category">
								<c:forEach items="${data.categories}" var="c">
									<option value="${c.code}">${c.code}<span>-</span>${c.name}</option>
								</c:forEach>
							</select> 
						</div>
						</div>
						<div class="form-group col-md-4">
							<div class="form-group">
							<label for="subcategory">Sub-Category</label> 
							<select class="form-control" id="subcategory" name="subcategory">
								<!-- <option>Please select a Category</option> -->
							</select>
							</div>
						</div>
					</div>
					<div class="row">
						<table id="proTable" class="table table-striped table-bordered" style="width:100%">
						         <thead>
						            <tr class="tableText">
						                <th>Product name</th>
						                <th>Stored Amount</th>
						                <th>Average Price</th>
						            </tr>
						        </thead>
						        <%-- <tbody>
						            <c:forEach items="${products}" var="p">
						                <tr>
						                    <td>${p.productCode}</td>
						                    <td>${p.productName}</td>
						                    <td>${p.categoryName}</td>
						                    <td>${p.subCategoryName}</td>
						                    <td>${p.supplierName}</td>
						                    <td>
						                        <a class="btn btn-primary" role="button" href="/product/edit/${p.id}">Edit</a>
						                        <a class="btn btn-primary" role="button" href="/product/delete/${p.id}">Delete</a>
						                    </td>
						                </tr>
						            </c:forEach>
						        </tbody> --%>
						</table>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<!-- <script type="text/javascript">
 $('#proTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });
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