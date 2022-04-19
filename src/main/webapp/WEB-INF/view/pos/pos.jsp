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
			<input type="hidden" value="${data.transactionCode}" name="transactionCode">
			<div class="d-flex justify-content-end">
			<div class="form-group col-md-10"></div>
			<div class="form-group col-md-2">
				<input class="form-control" id="salesDate" readonly/>
			</div>
			</div>
			<div class="row">
					<div class="form-group col-md-6">
						
						<div class="form-group">
							<div class="input-group rounded">
								<label style="margin-right: 10px">Search Customer:</label>
								  <input class="form-control rounded" list="customers" name="customer" id="customer">
								  <datalist id="customers">
								  	<option value="WC">Walk in Customer</option>
								  	<c:forEach items="${data.customers}" var="c">
										<option>${c.customerCode} ${c.customerName}</option>
								    </c:forEach>
								  </datalist>
							</div>
						</div>
							<h4 id="customerData">Walk in Customer</h4>
							<a role="button" href="/customer/addCustomer">Add Customer</a>
							<!-- <button type="button" class="btn btn-light" href="/customer/addCustomer">Add Customer</button> -->
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
					<c:forEach items="${data.products}" var="p">
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
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
			  Invoice
			</button>
		</form>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Invoice</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="printThis"> <!-- to print added printThis -->
        ...
        <div class="page-content container modifyMe"> <!-- to print added modifyMe class -->
		    <div class="page-header text-blue-d2">
		        <h1 class="page-title text-secondary-d1">
		            Transaction
		            <small class="page-info">
		                <i class="fa fa-angle-double-right text-80"></i>
		                CODE: # ${data.transactionCode}
		            </small>
		        </h1>
		
		        <div class="page-tools">
		            <div class="action-buttons">
		                <!-- <a class="btn bg-white btn-light mx-1px text-95" href="#" data-title="Print">
		                    <i class="mr-1 fa fa-print text-primary-m1 text-120 w-2"></i>
		                    Print
		                </a> -->
		                <button id="btnPrint">Print</button>
		                <!-- <a class="btn bg-white btn-light mx-1px text-95" href="#" data-title="PDF">
		                    <i class="mr-1 fa fa-file-pdf-o text-danger-m1 text-120 w-2"></i>
		                    Export
		                </a> -->
		            </div>
		        </div>
		    </div>
		
		    <div class="container px-0">
		        <div class="row mt-4">
		            <div class="col-12 col-lg-12">
		                <div class="row">
		                    <div class="col-12">
		                        <div class="text-center text-150">
		                            <i class="fa fa-book fa-2x text-success-m2 mr-1"></i>
		                            <span class="text-default-d3">Retail Management</span>
		                        </div>
		                    </div>
		                </div>
		                <!-- .row -->
		
		                <hr class="row brc-default-l1 mx-n1 mb-4" />
		
		                <div class="row">
		                    <div class="col-sm-6">
		                        <div>
		                            <span class="text-sm text-grey-m2 align-middle">To:</span>
		                            <span class="text-600 text-110 text-blue align-middle"><div id="supName"></div></span>
		                        </div>
		                        <div class="text-grey-m2">
		                            <div class="my-1">
		                                Street, City
		                            </div>
		                            <div class="my-1">
		                                State, Country
		                            </div>
		                            <div class="my-1"><i class="fa fa-phone fa-flip-horizontal text-secondary"></i> <b class="text-600">111-111-111</b></div>
		                        </div>
		                    </div>
		                    <!-- /.col -->
		
		                    <div class="text-95 col-sm-6 align-self-start d-sm-flex justify-content-end">
		                        <hr class="d-sm-none" />
		                        <div class="text-grey-m2">
		                            <div class="mt-1 mb-2 text-secondary-m1 text-600 text-125">
		                                Invoice
		                            </div>
		
		                            <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Code:</span> # ${data.transactionCode}</div>
		
		                            <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Issue Date:</span><span id="date"></span></div>
		
		                            <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Status:</span> <span class="badge badge-warning badge-pill px-25">Unpaid</span></div>
		                        </div>
		                    </div>
		                    <!-- /.col -->
		                </div>
		                
		                <div class="row border-b-2 brc-default-l2"></div>
		
		                    <!-- or use a table instead -->
		                   
			            <div class="table-responsive">
			                <table class="table table-striped table-borderless border-0 border-b-2 brc-default-l1" id="invoice">
			                    <thead class="bg-none bgc-default-tp1">
			                        <tr class="text-white">
			                            <th class="opacity-2">#</th>
			                            <th>Description</th>
			                            <th>Qty</th>
			                            <th>Unit Price</th>
			                            <th width="140">Amount</th>
			                        </tr>
			                    </thead>
			
			                    <tbody class="text-95 text-secondary-d3">
			                    </tbody>
			                </table>
			            </div>
		           
		
		                    <div class="row mt-3">
		                        <!-- <div class="col-12 col-sm-7 text-grey-d2 text-95 mt-2 mt-lg-0">
		                            Extra note such as company or payment information...
		                        </div> -->
		
		                        <div class="col-12 col-sm-5 text-grey text-90 order-first order-sm-last">
		                            <!-- <div class="row my-2">
		                                <div class="col-7 text-right">
		                                    SubTotal
		                                </div>
		                                <div class="col-5">
		                                    <span class="text-120 text-secondary-d1">$2,250</span>
		                                </div>
		                            </div>
		
		                            <div class="row my-2">
		                                <div class="col-7 text-right">
		                                    Tax (10%)
		                                </div>
		                                <div class="col-5">
		                                    <span class="text-110 text-secondary-d1">$225</span>
		                                </div>
		                            </div> -->
		
		                            <div class="row my-2 align-items-center bgc-primary-l3 p-2">
		                                <div class="col-7 text-right">
		                                    Total Amount
		                                </div>
		                                <div class="col-5">
		                                    <span class="text-150 text-success-d3 opacity-2"><div id="totalValSales"></div></span>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		
		                    <hr />
		
		                    <div>
		                        <span class="text-secondary-d1 text-105">Thank you for your business</span>
		                        <!-- <a href="#" class="btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0">Pay Now</a> -->
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
      </div>
    </div>
  </div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
//print modal
document.getElementById("btnPrint").onclick = function () {
    printElement(document.getElementById("printThis"));
    
    var modThis = document.querySelector("#printSection .modifyMe");
    modThis.appendChild(document.createTextNode(" new"));
    
    window.print();
}

function printElement(elem) {
    var domClone = elem.cloneNode(true);
    
    var $printSection = document.getElementById("printSection");
    
    if (!$printSection) {
        var $printSection = document.createElement("div");
        $printSection.id = "printSection";
        document.body.appendChild($printSection);
    }
    
    $printSection.innerHTML = "";
    
    $printSection.appendChild(domClone);
}
//end printing modal
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
	var allSoldProducts = [];
	function salesCart(){
		  checkTheTableforExisting();
		  $("#salesCart > tbody").html("");
		  for(i=0;i<addSales.length;i++){
			  $('#salesCart > tbody:last-child').append("<tr><td>"+addSales[i][0]+"</td><td>" 
		  				+ addSales[i][1] + "</td><td class='storedInventory'>" + 
		  				addSales[i][2] + "</td><td>" + addSales[i][2]*addSales[i][3]
		  				+ "</td><td><input type='hidden' name='product_code[]' value='"+ addSales[i][0]
		  				+"'/><input type='hidden' name='product_quantity[]' value='"+ $('#quantityChange').val()+"'/></td></tr>");
			}
		  var sumTotalSales = 0;
		  for(i=0;i<addSales.length;i++){
			  sumTotalSales += (addSales[i][2]*addSales[i][3]);
			  console.log(sumTotalSales);
		  }
		  $('#totalValSales').html(sumTotalSales);
		  $("#invoice > tbody").html("");
		  for(i=0;i<addSales.length;i++){
			  $('#invoice > tbody:last-child').append("<tr><td>"+addSales[i][0]+"</td><td>" 
		  				+ addSales[i][1] + "</td><td class='storedInventory'>" + 
		  				addSales[i][2] + "</td><td>" + addSales[i][2]*addSales[i][3]
		  				+ "</td><td><input type='hidden' name='product_code[]' value='"+ addSales[i][0]
		  				+"'/><input type='hidden' name='product_quantity[]' value='"+ $('#quantityChange').val()+"'/></td></tr>");
			}
		  $("#sellProductTable > tbody").html("");
	}
		  
		  /* var table = $("#salesCart tbody");
		    table.find('tr').each(function (i) {
		        var $tds = $(this).find('td'),
		            productId = $tds.eq(0).text(),
		            product = $tds.eq(1).text(),
		            Quantity = $tds.eq(2).text();
		        	price = $tds.eq(3).text();
		        if(productId == data.productCode){
		        	//console.log("match found");
		        	//quantity =data.storedAmount - Quantity;
		        }
		        // do something with productId, product, Quantity
		        console.log('Row ' + (i + 1) + ':\nId: ' + productId
		              + '\nProduct: ' + product
		              + '\nQuantity: ' + Quantity
		              + '\nQuantity: ' + price);
		    }); */
		  
	
	function checkTheTableforExisting(){
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
		      //console.log(a[index]);
		      //console.log("    Value in col " + (index + 1) + " : " + colVal.trim());
		    });
		    for(i=0;i<addSales.length;i++){
			    if(addSales[i][0] == a[0]){
			    	addSales[i][2]= parseInt(addSales[i][2])+parseInt(a[2]);
			    	return;
			    }
		    }
		    addSales.push(a);
		  });
	}
	
    var i;
    var remainingStoreAmount = 0;
	var quantity;
	var totalAdded = 0;
	
    $('div.res a').click(function(){
	     i = ($(this).attr('title'));
	     $.post( "/posController/productDetail/"+i, function( data ) {
	    	 /* for(i=0;i<addSales.length;i++){
	    		 if(addSales[i][0] == data.productCode){
	    			 quantity = addSales[i][2];
	    			 if(quantity != undefined){
	    			   	var quant = parseInt(quantity);
	    			   	totalAdded = totalAdded + quant;
	    			   	remainingStoreAmount = data.storedAmount - totalAdded;
	    			 }
	    			 //remainingStoreAmount = data.storedAmount - addSales[i][2];
	    			 $('#sellProductTable > tbody:last-child').append("<tr id="+data.productCode+"><td>"+data.productCode+"</td><td>" 
	 	    				+ data.productName + "</td><td class='storedInventory'>" + 
	 	    				remainingStoreAmount + "</td><td>" + data.sellingPrice + "</td></td></tr>");
	    			 return;
	    		 }
			  } */
			  /* $('#salesCart tr').each(function() {
				    var code = $(this).find("#P101").html();
				    console.log("procode"+code);
				    if(code!=undefined){
				    	console.log(code);
				    	//$('#quantityChange').val(code);
				    }
				 }); */
				 quantity =data.storedAmount;
				 var table = $("#salesCart tbody");
				    table.find('tr').each(function (i) {
				        var $tds = $(this).find('td'),
				            productId = $tds.eq(0).text(),
				            product = $tds.eq(1).text(),
				            Quantity = $tds.eq(2).text();
				        if(productId == data.productCode){
				        	//console.log("match found");
				        	quantity =data.storedAmount - Quantity;
				        }
				        // do something with productId, product, Quantity
				       /*  console.log('Row ' + (i + 1) + ':\nId: ' + productId
				              + '\nProduct: ' + product
				              + '\nQuantity: ' + Quantity); */
				    });
	    	 $('#sellProductTable > tbody:last-child').append("<tr><td>"+data.productCode+"</td><td>" 
	    				+ data.productName + "</td><td class='storedInventory'>" + 
	    				quantity + "</td><td>" + data.sellingPrice + "</td></tr>");
	    		/* document.getElementById("insertionPoint").innerHTML += "<tr><td>" + data.productName + "</td><td>" + 
	    		data.productName + "</td><td>" + data.productName + "</td><td><input type='hidden' name='product_name[]' value='"+ data.productName+"'/></td></tr>"; */
			});
	});
    
	$(document).ready(function() {
		$("#customer").change(function() {
			let text = $("#customer").val()
			let myarray = text.split(" ");
			$('#customerData').text($("#customer").val())
			$('#supName').text(myarray[1])
		});
	});
	
	/* function getCustomer(){
		$.post( "/purchasedemand/searchCategory/"+$("#supplierName :selected").val(), function( data ) {
			 $("#categoryName").html("");
			 for(i=0; i<data.length; i++){
				 $("#categoryName").append("<option>"+data[i]+"</option>");
			 }
		});
	} */
    
    var d = new Date();
    var month = d.getMonth()+1;
    var day = d.getDate();
    var date = (day<10 ? '0' : '') + day + '/' +
        (month<10 ? '0' : '') + month + '/' +
        d.getFullYear();
    
    $('#salesDate').val(date);
    $('#date').html(date);
    
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
