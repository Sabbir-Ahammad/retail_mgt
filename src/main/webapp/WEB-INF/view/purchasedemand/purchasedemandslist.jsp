<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/purchasedemand/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Demands</h4></div>
<table id="purchaseDemandTable" class="table table-striped table-hover" style="width:100%">
         <thead>
            <tr>
	            <th>Demand Code</th>
	            <th>Lot Number</th>
	            <th>Product Name</th>
	            <th>Quantity</th>
	            <th>Price</th>
	            <th>Supplier Name</th>
	            <th>Category Name</th>
	            <th>Status</th>
	            <th>Order Date</th>
	            <th>Update Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pd}" var="p">
                <tr>
	                <td>${p.purchaseDemandCode}</td>
	                <td>${p.lotNumber}</td>
                    <td>${p.productName}</td>
                    <td>${p.quantity}</td>
                    <td>${p.purchasePrice}</td>
                    <td>${p.supplierName}</td>
                    <td>${p.categoryName}</td>
                    <td>${p.status}</td>
                    <td>${p.orderDate}</td>
                    <td>
                    	<a class="btn btn-primary" role="button" href="/purchasedemand/updatestatus/${p.id}">Received</a>                    
                    </td>
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

