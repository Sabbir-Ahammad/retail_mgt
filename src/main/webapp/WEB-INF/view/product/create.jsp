<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/product/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
	<div style="text-align: center;">
		<h4>Add New Product</h4>
	</div>
	<div>
		<form id="productAddForm" name="productAddForm">
		<div class="form-row">
			  <div class="form-group col-md-6">
			      <label for="categorycode">Category code</label>
			      <select class="form-control" id="categorycode" name="categorycode">
		    		<c:forEach items="${categorys}" var="c">
		    			<option>${c.code}<span>-</span>${c.name}</option>
		    		</c:forEach>
		    	</select>
			      <label for="suppliercode">Supplier code</label>
			      <select class="form-control" id="" name="">
		    		<%-- <c:forEach items="${categorys}" var="c">
		    			<option>${c.code}<span>-</span>${c.name}</option>
		    		</c:forEach> --%>
		    	</select>
			    </div>
			    <div class="form-group col-md-6">
			    <label for="categoryname">Category Name</label>
			      <input class="form-control" id="categoryname" placeholder="Category Name">
			      <label for="suppliername">Supplier Name</label>
			      <input class="form-control" id="suppliername" placeholder="Supplier Name">
			    </div>
		  </div>
		  
		  <div class="form-row">
			  <div class="form-group col-md-6">
			      <label for="productcode">Product code</label>
			      <input class="form-control" id="productcode" placeholder="Product code">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="productname">Product Name</label>
			      <input class="form-control" id="productname" placeholder="Product Name">
			    </div>
		  </div>
		  
		  <div class="form-group col-md-6">
			      <label for="tags">Tags</label>
			      <input class="form-control" id="tags" placeholder="Tags">
		  </div>
		  <div class="form-group col-md-6">
			      <label for="tags">image</label>
			      <input class="form-control" id="image" placeholder="Tags" >
		  </div>
		  <button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
<script type="text/javascript">
$(document).ready(function(){
    $("#categorycode").change(function(){
        var selectedcat = $(this).children("option:selected").val();
        /* console.log(selectedcat); */
        $("#productAddForm").ajaxSubmit({url: '/product/searchSubcat', type: 'post'})
    });
});
</script>
