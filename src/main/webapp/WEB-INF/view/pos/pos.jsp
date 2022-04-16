<jsp:include page="/WEB-INF/view/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="border m-2 p-1">
		<div style="text-align: center;">
			<h4>POS</h4>
		</div>
		<hr></hr>
		<form id="purchaseOrderForm" name="purchaseOrderForm" method="post"
			action="/posController/posSave">
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
					  <table id="salesCart" class="table table-striped table-bordered table-sm">
					    <thead>
					        <tr>
					        	<th>Product Code</th>
					            <th>Product Name</th>
					            <th>Quantity</th>
					            <th>Price</th>
					             <th>Action</th>
					        </tr>
					    </thead>
					    <tbody id="">
					      
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
					<div class="row border p-2" style="height: 250px; overflow-y: scroll">
					<c:forEach items="${products}" var="p">
						<div class="form-group col-md-2 res">
						<span role="button" tabindex="0" class="a">
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
					<div style="height: 150px; overflow-y: scroll">
					<h6>Inventory</h6>
					  <table id="sellProductTable" class="table table-striped table-bordered table-sm" onclick="a()">
					    <thead>
					        <tr>
					        	<th>Product Code</th>
					            <th>Product Name</th>
					            <th>Quantity</th>
					            <th>Price</th>
					            
					        </tr>
					    </thead>
					    <tbody id="insertionPoint">
					      
					    </tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-md-6"><label>Select Quantity</label></div>
					<div class="col-md-6" ><input id="quantityChange"></div>
				</div>
				<div class="col-md-2"> <button onclick="salesCart()" type="button">add</button> </div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">PAY</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
	function a(){
		$('#sellProductTable tr').each(function() {
		    var quantity = $(this).find(".storedInventory").html();
		    if(quantity!=undefined){
		    	console.log(quantity);
		    	$('#quantityChange').val(quantity);
		    }
		 });
	}
	var addSales = [];
	function salesCart(){
		var a = [];
		var tb = $('#sellProductTable:eq(0) tbody');
		  var size = tb.find("tr").length;
		  //console.log("Number of rows : " + size);
		  tb.find("tr").each(function(index, element) {
		    var colSize = $(element).find('td').length;
		    //console.log("  Number of cols in row " + (index + 1) + " : " + colSize);
		    $(element).find('td').each(function(index, element) {
		      var colVal = $(element).text();
		      a[index] = colVal.trim();
		      if(a[2] != undefined){
		    	  a[2] = $('#quantityChange').val();
		      }
		      console.log(a[index]);
		      //console.log("    Value in col " + (index + 1) + " : " + colVal.trim());
		    });
		    addSales.push(a);
		    //addSales[index][2]=$('#quantityChange').val();
		    /* console.log($('#quantityChange').val()); */
		  });
		  $('#salesCart > tbody:last-child').append("<tr><td>"+a[0]+"</td><td>" 
  				+ a[1] + "</td><td class='storedInventory'>" + 
  				$('#quantityChange').val() + "</td><td>" + a[3]*$('#quantityChange').val() 
  				+ "</td><td><input type='hidden' name='product_name[]' value='"+ a[0]
  				+"'/><input type='hidden' name='product_quantity[]' value='"+ $('#quantityChange').val()+"'/></td></tr>");
		  $("#sellProductTable > tbody").html("");
	}
	
	
    var i;
    var remainingStoreAmount = 0;
	var quantity;
	var totalAdded = 0;
    $('div.res a').click(function(){
	     i = ($(this).attr('title'));
	     $.post( "/posController/productDetail/"+i, function( data ) {
	    	 for(i=0;i<addSales.length;i++){
	    		 if(addSales[i][0] == data.productCode){
	    			 quantity = addSales[i][2];
	    			 if(quantity != undefined){
	    			   	var quant = parseInt(quantity);
	    			   	totalAdded = totalAdded + quant;
	    			   	remainingStoreAmount = data.storedAmount - totalAdded;
	    			 }
	    			 //remainingStoreAmount = data.storedAmount - addSales[i][2];
	    			 $('#sellProductTable > tbody:last-child').append("<tr id="${data.productCode}"><td>"+data.productCode+"</td><td>" 
	 	    				+ data.productName + "</td><td class='storedInventory'>" + 
	 	    				remainingStoreAmount + "</td><td>" + data.sellingPrice + "</td></td></tr>");
	    			 return;
	    		 }
			  }
	    	 $('#sellProductTable > tbody:last-child').append("<tr><td>"+data.productCode+"</td><td>" 
	    				+ data.productName + "</td><td class='storedInventory'>" + 
	    	    		data.storedAmount + "</td><td>" + data.sellingPrice + "</td></tr>");
	    		/* document.getElementById("insertionPoint").innerHTML += "<tr><td>" + data.productName + "</td><td>" + 
	    		data.productName + "</td><td>" + data.productName + "</td><td><input type='hidden' name='product_name[]' value='"+ data.productName+"'/></td></tr>"; */
			});
	});
    
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
