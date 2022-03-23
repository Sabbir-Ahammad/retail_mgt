<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<p id="myP">Hello</p>
<form action="/product/save" method="POST">
	Name<input type="text" name="name" /><br /> Quantity<input
		type="text" name="qty" /><br /> Price<input type="text" name="price" /><br />
	<input type="submit" value="Save" class="btn btn-success" />
</form>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />