<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/subcategory/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-12">
	<div class="col-md-3"></div>
	<div class="col-md-9" style="margin-top: 10px">
		<div class="text-center"><h4>Edit Sub-category</h4></div>
		<form action="/subcategory/update" method="POST">
		  <div class="form-row">
			    <div class="form-group col-md-6">
			    	<label>Select Category</label> 
			    	<select class="form-control" id="categorycode" name="categorycode">
			    		 <c:forEach items="${data.category}" var="c">
			    			<option value="${c.code}">${c.code}<span>-</span>${c.name}</option>
			    		</c:forEach> 
			    	</select>
			  	</div>
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Sub-category Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="scatcode" name="scatcode" class="form-control" value="${data.subCategory.subCategoryCode}"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Sub-category Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="scatname" name="scatname" class="form-control" value="${data.subCategory.subCategoryName}"> 
		    </div>
		  </div>
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Save</button> 
           </div>
		</form>
	</div>
	<div class="col-md-3"></div>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />
 <script>
var catCode =  "${data.subCategory.categoryCode}";
$("#categorycode option[value='"+catCode+"']").attr("selected", true);
</script>