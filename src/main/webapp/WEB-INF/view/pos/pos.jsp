<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/purchasedemand/common.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>POS</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/purchasedemand/saveProductDemand" enctype="multipart/form-data">
			<div class="row">
					<div class="form-group col-md-6">
						
						<div class="form-group">
							<div class="input-group rounded">
							  <input type="search" class="form-control rounded" placeholder="Walk in Customer" aria-label="Search" aria-describedby="search-addon" />
							  <span class="input-group-text border-0" id="search-addon" role="button">
							    <i class="fas fa-search"></i>
							  </span>
							</div>
						</div>
						<div class="form-group">
							<label for="suppliercode">Customer</label><br>
							<label for="suppliercode">MR. A</label>
							<div class="float-right">
								<button class="btn btn-light">Add Customer</button>
							</div>
						</div>
						<hr>
						<!-- <table id="sellProductTable"  style="width: 100%"> -->
					<div style="height: 250px; overflow-y: scroll">
					  <table id="sellProductTable" class="table table-striped table-bordered table-sm">
					    <thead>
					        <tr>
					            <th>Product Name</th>
					            <th>Quantity</th>
					            <th>Price</th>
					        </tr>
					    </thead>
					    <tbody id="insertionPoint">
					      
					    </tbody>
					</table>
				</div>
					
					</div>
					<div class="form-group col-md-6">
					<div class="form-group">
							<div class="input-group rounded">
							  <input type="search" class="form-control rounded" placeholder="Products" aria-label="Search" aria-describedby="search-addon" />
							  <span class="input-group-text border-0" id="search-addon" role="button">
							    <i class="fas fa-search"></i>
							  </span>
							</div>
					</div>
					<div class="row border p-2" style="height: 350px; overflow-y: scroll">
					<c:forEach items="${products}" var="p">
						<div class="form-group col-md-2 res">
						<span role="button" tabindex="0" class="a" onclick="insertData()">
						<a id="${p.productName}" title="${p.productCode}">
							<div class="card mb-3" >
							  <img src="/resources/image/${p.productImage}" class="card-img-top" alt="..." >
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
			<button type="submit" class="btn btn-primary">PAY</button>
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
    var i;
    function insertData() {
    	
    	var name;
        var address;
        var telephone;
    	/* $(function(){ */
			  $('div.res a').click(function(){
			     var j = ($(this).attr('title'));
			     i =j;
			     //console.log(i);
			    //$("#productCode").val(i);
			  });
			/* }); */
    	console.log(i);
    	$.post( "/posController/productDetail/"+i, function( data ) {
    		document.getElementById("insertionPoint").innerHTML += "<tr><td>" + data.productName + "</td><td>" + 
    		data.productName + "</td><td>" + data.productName + "</td></tr>";
		});
        
    }	
    
	$(document).ready(function() {
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
