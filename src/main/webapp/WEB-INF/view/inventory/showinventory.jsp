<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/purchasedemand/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Inventory</h4></div>
<table id="purchaseDemandTable" class="table table-striped table-hover" style="width:100%">
         <thead>
            <tr>
	            <th>ID</th>
	            <th>Product Name</th>
	            <th>Category Name</th>
	            <th>Sub-Category Name</th>
	            <th>Received Date</th>
	            <th>Supplier Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${in}" var="i">
                <tr>
	                <td>${i.id}</td>
	                <td>${i.productName}</td>
	                <td>${i.categoryName}</td>
	                <td>${i.subcategoryName}</td>
	                <td>${i.receivedDate}</td>
	                <td>${i.supplierName}</td>
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

