<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Products</h4></div>
<table id="purchaseDemandTable" class="table table-striped table-hover" style="width:100%">
         <thead>
            <tr>
            <th>purchaseDemandCode</th>
            <th>lotNumber</th>
            <th>productName</th>
            <th>quantity</th>
            <th>purchasePrice</th>
            <th>supplierName</th>
            <th>categoryName</th>
            <th>status</th>
            <th>orderDate</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
	                <td>${p.purchaseDemandCode}</td>
	                <td>${p.lotNumber}</td>
                    <td>${p.productName}</td>
                    <td>${p.quantity}</td>
                    <td>${p.purchasePrice}</td>
                    <td>${p.supplierName}</td>
                    <td>${p.status}</td>
                    <td>${p.productName}</td>
                    <td>${p.orderDate}</td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />

<script>
    $('#proTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });

</script>

