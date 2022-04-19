<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/people/customer/common.jsp" />

<div class="text-center mt-4 mb-4"><h4>Suppliers</h4></div>
<table id="supTable" class="table table-striped table-bordered" style="width:100%">
         <thead>
            <tr>
                <th>Customer code</th>
                <th>Customer name</th>
                <th>Contract</th>
                <th>Address</th>
                <!-- <th>Action</th> -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="c">
                <tr>
                    <td>${c.customerCode}</td>
                    <td>${c.customerName}</td>
                    <td>${c.customerContract}</td>
                    <td>${c.customerAdderss}</td>
                    <%-- <td>
                        <a class="btn btn-primary" role="button" href="/supplier/edit/${s.id}">Edit</a>
                        <a class="btn btn-primary" role="button" href="/supplier/delete/${s.id}">Delete</a>
                    </td> --%>
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

