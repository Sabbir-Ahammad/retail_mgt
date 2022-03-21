<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/category/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Categories</h4></div>
<table id="catTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Category code</th>
                <th>Category name</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categories}" var="c">
                <tr>
                    <td>${c.code}</td>
                    <td>${c.name}</td>
                    <td>${c.description}</td>
                    <td>
                        <a class="btn btn-primary" role="button" href="/category/edit/${c.code}">Edit</a>
                        <a class="btn btn-primary" role="button" href="/category/delete/${c.code}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />

<script>
    $('#catTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    });

</script>

