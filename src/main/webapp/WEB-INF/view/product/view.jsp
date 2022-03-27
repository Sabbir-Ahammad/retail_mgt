<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Products</h4></div>
<table id="proTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Product Code</th>
                <th>Product name</th>
                <th>Category</th>
                <th>Sub-Category</th>
                <th>Supplier</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.productCode}</td>
                    <td>${p.productName}</td>
                    <td>${p.categoryName}</td>
                    <td>${p.subCategoryName}</td>
                    <td>${p.supplierName}</td>
                    <td>
                        <a class="btn btn-primary" role="button" href="/product/edit/${p.id}">Edit</a>
                        <a class="btn btn-primary" role="button" href="/product/delete/${p.id}">Delete</a>
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

