<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/purchasedemand/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Inventory</h4></div>
<table id="purchaseDemandTable" class="table table-striped table-hover" style="width:100%">
         <thead>
            <tr>
	           
	            <th>Product Name</th>
	            <th>Customer Name</th>
	            <th>profit</th>
	            <th>salesDate</th>
	            <th>sellingPrice</th>
	            <th>salesQuantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pos}" var="p">
                <tr>
	            
	                <td>${p.productName}</td>
	                <td>${p.customerName}</td>
	                <td>${p.profit}</td>
	                <td>${p.salesDate}</td>
	                <td>${p.sellingPrice}</td>
	                <td>${p.salesQuantity}</td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />

<script>
    $('#purchaseDemandTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });

</script>

