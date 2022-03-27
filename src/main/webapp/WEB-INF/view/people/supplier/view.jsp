<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/people/supplier/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Suppliers</h4></div>
<table id="supTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Category code</th>
                <th>Category name</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${suppliers}" var="s">
                <tr>
                    <td>${s.supplierCode}</td>
                    <td>${s.supplierName}</td>
                    <td>${s.supplierAddress}</td>
                    <td>
                        <a class="btn btn-primary" role="button" href="/supplier/edit/${s.id}">Edit</a>
                        <a class="btn btn-primary" role="button" href="/supplier/delete/${s.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />

<script>
    $('#supTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });

</script>

