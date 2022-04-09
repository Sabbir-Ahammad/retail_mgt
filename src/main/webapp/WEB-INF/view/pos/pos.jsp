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
						</div>
						<!-- <table id="sellProductTable" class="table table-striped table-bordered table-sm" style="width: 100%"> -->
					  <table id="t1">
					    <caption>Customer Table</caption>
					    <colgroup>
					        <col span="2" class="c2">
					        <col>
					        <col class="c1">
					    </colgroup>
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
					<div class="form-group col-md-6">
					<div class="form-group">
							<div class="input-group rounded">
							  <input type="search" class="form-control rounded" placeholder="Products" aria-label="Search" aria-describedby="search-addon" />
							  <span class="input-group-text border-0" id="search-addon" role="button">
							    <i class="fas fa-search"></i>
							  </span>
							</div>
					</div>
					<div class="row border p-2">
					<c:forEach items="${products}" var="p">
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
	$(document).ready(function() {
		
		// Find a <table> element with id="myTable":
		var table = document.getElementById("sellProductTable");
		// Create an empty <tr> element and add it to the 1st position of the table:
		var row = table.insertRow(0);
		// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);

		// Add some text to the new cells:
		cell1.innerHTML = "NEW CELL1";
		cell2.innerHTML = "NEW CELL2";
		//get ancor <a> tag value
			function insertData() {
		        var name = document.getElementById("inputCustomerName").value;
		        var address = document.getElementById("inputCustomerAddress").value;
		        var telephone = document.getElementById("inputCustomerTelephone").value;
		        document.getElementById("insertionPoint").innerHTML += "<tr><td>" + name + "</td><td>" + address + "</td><td>" + telephone + "</td></tr>";
		      
		        // The below part is to clear the values after the entry is added.
		        document.getElementById("inputCustomerName").value = "";
		        document.getElementById("inputCustomerAddress").value = "";
		        document.getElementById("inputCustomerTelephone").value = "";
		    }
		
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
