<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/subcategory/common.jsp" />
  
<table id="subCatTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Category code</th>
                <th>Sub-category code</th>
                <th>Sub-category name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${subCategory}" var="sc">
                <tr>
                    <td>${sc.categoryCode}</td>
                    <td>${sc.subCategoryCode}</td>
                    <td>${sc.subCategoryName}</td>
                    <td>
                        <a class="btn btn-primary" role="button" href="/subcategory/edit/${sc.subCategoryCode}">Edit</a>
                        <a class="btn btn-primary" role="button" href="/subcategory/delete/${sc.subCategoryCode}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script>
    $('#subCatTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });

</script>
