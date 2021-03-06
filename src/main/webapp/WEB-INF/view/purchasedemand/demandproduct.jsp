<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/purchasedemand/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>Add a purchase order</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/purchasedemand/saveProductDemand" enctype="multipart/form-data">
			<div class="row">
					<div class="form-group col-md-2">
						<div class="form-group">
							<label>Date</label>
							<input class="form-control" id=orderDate name="orderDate" readonly/>
						</div>
						<div class="form-group">
							<label for="suppliercode">Order No.</label>
							<input class="form-control" id=purchaseOrderCode name="purchaseDemandCode"/>
						</div>
						<div class="form-group">
							<label for="suppliercode">Lot number</label>
							<input class="form-control" id="lotNumber" name="lotNumber"/>
						</div>
						<div class="form-group">
						<input class="form-control" id="productCode" name="productCode" value="" type="hidden">
						<input class="form-control" id="productImage" name="productImage" value="" type="hidden">
							<label for="productcode">Product</label> <input
								class="form-control" id="productName" name="productName" value="">
						</div>
						<!-- <div class="form-group">
							<label for="productcode">Description</label> <input
								class="form-control" id="description" name="description">
						</div> -->
					</div>
					<div class="form-group col-md-3">
						<div class="form-group">
							<label for="productcode">Price</label> <input
								class="form-control" id="statedPrice" name="statedPrice">
						</div>
						<div class="row">
						<div class="form-group col-md-12"><label>Discount</label> </div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="discountRate" name="discountRate" oninput="discountCalculate()">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="discount" name="discount" readonly>
								</div>
							</div>
						</div>
						<div class="row">
						<div class="form-group col-md-12"><label>Tax</label> </div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="taxRate" name="taxRate" oninput="taxCalculate()">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="form-group">
									<input
										class="form-control" id="tax" name="tax" readonly>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="productname">Purchase Amount</label> <input
								class="form-control" id="quantity" name="quantity" oninput="chargedPriceCalculate()">
						</div>
						<div class="form-group">
							<label for="productname">Charged Price</label> <input
								class="form-control" id="purchasePrice" name="purchasePrice" readonly>
						</div>
					</div>
					<div class="form-group col-md-7">
					<div class="row">
						<div class="form-group col-md-4">
							<div class="form-group">
							<label>Supplier</label>
							<select class="form-control" id="supplierName" name="supplierName">
								<c:forEach items="${data.suppliers}" var="s">
						    		<option>${s}</option>
						    	</c:forEach>
							</select>
						</div>
						</div>
						<div class="form-group col-md-4">
							<div class="form-group">
							<label for="category">Category</label> 
							<select class="form-control" id="categoryName" name="categoryName">
							<c:forEach items="${data.cats}" var="s">
						    		<option>${s}</option>
						    	</c:forEach>
							</select> 
						</div>
						</div>
						<div class="form-group col-md-4">
							<div class="form-group">
							<label for="subcategory">Sub-Category</label> 
							<select class="form-control" id="subCategoryName" name="subCategoryName">
								<!-- <option>Please select a Category</option> -->
								<c:forEach items="${data.subcats}" var="s">
						    		<option>${s}</option>
						    	</c:forEach>
							</select>
							</div>
						</div>
					</div>
					<div class="row border p-2">
					<%-- <table id="dtDynamicVerticalScrollExample" class="table table-striped table-bordered table-sm" style="width: 100%">
					  <!-- width="100%" cellspacing="0" -->
					  <thead>
					    <tr>
					      <th class="th-sm">Name</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${data.products}" var="p">
					    <tr>
					      <td class="nr">${p.productName}</td>
					    </tr>
					   </c:forEach>
					  </tbody>
					</table> --%>
					<c:forEach items="${data.products}" var="p">
						<div class="form-group col-md-2 res">
						<span role="button" tabindex="0" class="a">
						<a id="${p.productName}" title="${p.productCode}">
							<div class="card mb-3">
								
							  <img src="/resources/image/${p.productImage}" class="card-img-top" alt="...">
							  <div class="card-text">
							    <p class="card-title">${p.productName}</p>
							  </div>
							</div>
						</span> 
						</a>
						</div>
				    </c:forEach>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add Purchase Order</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
	/* $('#proTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    }); */
	$(document).ready(function() {
		//get div value
		/* $(document.body).on('click','div',function(evt){
			  var currentID = this.id || "No ID!";
			  $(this).html(currentID);
			}) */
		
		//get ancor <a> tag value
		$(function(){
			  $('div.res a').click(function(){
			    var i = ($(this).attr('title'));
			    $("#productCode").val(i);
			    // or alert($(this).hash();
			  });
			});
			$(function(){
				  $('div.res a').click(function(){
				    var i = ($(this).attr('id'));
				    $("#productName").val(i);
				    // or alert($(this).hash();
				  });
			});
			$(function(){
				$('div.res img').click(function(){
					 var i = ($(this).attr('src'));
					 $("#productImage").val(i);
					    // or alert($(this).hash();
					 });
			});
		
		/* $('#dtDynamicVerticalScrollExample').DataTable({
		    "scrollY": "50vh",
		    "scrollCollapse": true,
		  });
		  $('.dataTables_length').addClass('bs-select'); */
		  
		  /* $("#dtDynamicVerticalScrollExample tr").click(function() {
			    alert('values: ' + this.innerText);
			}); */
		  
			/* $(".use-address").click(function() {
			    var $row = $(this).closest("tr");    // Find the row
			    var $text = $row.find(".nr").text(); // Find the text
			    
			    // Let's test it out
			    alert($text);
			}); */
			
			/* get the product from table */
			/* var ppp;
			[].slice.call (document.querySelectorAll("#dtDynamicVerticalScrollExample tr"), 1).forEach(function(row){
			      row.addEventListener("click", function(){
			           var ths = document.querySelectorAll("#dtDynamicVerticalScrollExample th");
			           var obj = [].reduce.call(ths, function(obj, th, i){
			               obj[th.textContent] = row.cells[i].textContent;
			               ppp =row.cells[i].textContent;
			               document.getElementById("productName").value = ppp;
			               return row.cells[i].textContent;
			           }, {});
			           console.log(obj); 
			       }); 
			}); */
			
			
		//getCategory();
		//getSubCategory();
		onDropdownvalueChange();
		$("#supplierName").change(function() {
			getCategory();
		});
		$("#categoryName").change(function() {
			getSubCategory();
		});
	});
    
    var d = new Date();
    var month = d.getMonth()+1;
    var day = d.getDate();
    var date = (day<10 ? '0' : '') + day + '/' +
        (month<10 ? '0' : '') + month + '/' +
        d.getFullYear();
    
    $('#orderDate').val(date);
    
    var minusDiscount;
    var plusTax;
    var chargedPrice;
    function discountCalculate(){
    	var dis = $('#discountRate').val()* $('#statedPrice').val();
    	$('#discount').val(dis);
    	
    	var sta = $('#statedPrice').val();
        var disc = $('#discount').val();
        minusDiscount = sta - disc;
    }
    
    function taxCalculate(){
    	var tax = $('#taxRate').val()* minusDiscount;
    	$('#tax').val(tax);
    	plusTax = minusDiscount + tax;
    	console.log(plusTax);
    }
    
    function chargedPriceCalculate(){
    	chargedPrice = $('#quantity').val() * plusTax;
    	$('#purchasePrice').val(chargedPrice);
    }
    
    
    
	/* load product */
	function getCategory(){
		$.post( "/purchasedemand/searchCategory/"+$("#supplierName :selected").val(), function( data ) {
			 $("#categoryName").html("");
			 for(i=0; i<data.length; i++){
				 $("#categoryName").append("<option>"+data[i]+"</option>");
			 }
		});
	}
	function getSubCategory(){
		$.post( "/purchasedemand/searchSubCategory/"+$("#categoryName :selected").val(), function( data ) {
			 $("#subCategoryName").html("");
			 for(i=0; i<data.length; i++){
				 $("#subCategoryName").append("<option>"+data[i].subCategoryName+"</option>");
			 }
		});
	}
	/* get multiple dropdown onchange event */
	function onDropdownvalueChange(){
		$('form select').on('change', function(){
			/* $.ajax({
				  method: "POST",
			      url: "/purchasedemand/getProducts",
			      data: { supplierName: "supplierName", categoryName: "categoryName", subCategoryName: "subCategoryName"}
			}); */
			$.post( "/purchasedemand/getProducts/"+$("#supplierName :selected").val()+","+$("#categoryName :selected").val()+","+$("#subCategoryName :selected").val(), function( data ) {
				 /* $("#subCategoryName").html("");
				 for(i=0; i<data.length; i++){
					 $("#subCategoryName").append("<option>"+data[i].subCategoryName+"</option>");
				 } */
			});
		});
	}
	/* view image */
	/* var loadFile = function(event) {
		var image = document.getElementById('output');
		image.src = URL.createObjectURL(event.target.files[0]);
	};  */
</script>
