<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/pricing/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Pricing Details</h4></div>
<table id="proTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Product name</th>
                <th>Category</th>
                <th>Sub-Category</th>
                <th>Supplier</th>
                <!-- <th>Unit Cost</th> -->
                <th>Tax Rate</th>
                <th>Discount</th>
                <th>Profit Margin</th>
                <!-- <th>Selling Price</th> -->
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${productsDetails}" var="p">
                <tr>
                    <td>${p.productName}</td>
                    <td>${p.categoryName}</td>
                    <td>${p.subCategoryName}</td>
                    <td>${p.supplierName}</td>
                    <%-- <td>${p.unitCost}</td> --%>
                    <td>${p.taxRate}</td>
                    <td>${p.discount}</td>
                    <td>${p.profitMargin}</td>
                    <%-- <td>${p.sellingPrice}</td> --%>
                    <td>
                        <a class="btn btn-primary" role="button" href="/pricing/setpricing/${p.id}">Edit</a>
                    </td>
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

