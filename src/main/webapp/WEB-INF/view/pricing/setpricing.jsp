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
			<input type="hidden" id="id" name="id" value="${pDetail.id}">
					<div class="form-group col-md-3">
						<div class="form-group">
							<label for="suppliercode">Supplier</label>
							<input class="form-control" id="supplier" name="supplier" value="${pDetail.supplierName}" readonly>
						</div>
						<div class="form-group">
							<label for="product">Product</label> 
							<input class="form-control" id="product" name="product" value="${pDetail.productName}" readonly>
						</div>
					</div>
					<div class="form-group col-md-3 border">
						<div class="form-group">
							<label for="productcode">Cost per unit</label> <input
								class="form-control" id="unitCost" name="unitCost" value="${pDetail.unitCost}">
						</div>
						<div class="form-group">
							<label for="productname">Tax rate</label> <input
								class="form-control" id="taxRate" name="taxRate" value="${pDetail.taxRate}">
						</div>
						<div class="form-group">
							<label for="productname">Discount</label> <input
								class="form-control" id="discount" name="discount" value="${pDetail.discount}">
						</div>
					</div>
					<div class="form-group col-md-3 border">
					<div class="form-group">
							<label for="productname">Margin Rate</label> <input
								class="form-control" id="marginrate" name="marginrate" value="">
						</div>
						<div class="form-group">
							<label for="productname">Charged Price Per Unit</label> <input
								class="form-control" id="sellingPrice" name="sellingPrice" value="${pDetail.sellingPrice}" readonly>
						</div>
					</div>
			</div>
			<button type="submit" class="btn btn-primary">Set Pricing</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
var a = $('#unitCost').val();
$( "input" ).change(function() {
	var unitCostf = parseFloat($('#unitCost').val());
	var discountf = (parseFloat($('#taxRate').val())) * unitCostf;
	var lessDiscount = unitCostf - discountf;
	var taxratef = (parseFloat($('#discount').val())) * lessDiscount;
	var lesstax =  lessDiscount + taxratef;
	var margin = (parseFloat($('#marginrate').val())) * lesstax;
	var withProfit = lesstax + margin;
	var chargedPrice = unitCostf - discountf - taxratef;
	$('#sellingPrice').val(withProfit);
	});

</script>