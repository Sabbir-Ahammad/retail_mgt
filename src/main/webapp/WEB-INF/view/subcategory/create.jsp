<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/subcategory/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<style>
.center_div{
    margin: 0 auto;
    width:80% /* value of your choice which suits your alignment */
}
</style>

<div class="center_div">
		<div class="text-center"><h4>Add a Sub-Category</h4></div>
		<form action="/subcategory/save" method="POST">
		<div class="form-row">
		    <div class="form-group col-md-6">
		    	<label>Select Category<span class="text-danger"> *</span></label> 
		    	<select class="form-control" id="categorycode" name="categorycode">
		    		<c:forEach items="${categorys}" var="c">
		    			<option>${c.code}<span>-</span>${c.name}</option>
		    		</c:forEach>
		    	</select>
		  	</div>
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Sub-Category Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="catcode" name="subcode" placeholder="Enter Sub-category code" class="form-control"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Sub-Category Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="subname" name="subname" placeholder="Enter Sub-category name" class="form-control"> 
		    </div>
		  </div>
		  <!-- <div class="form-group">
		    <label class="form-control-label px-3">Category Description</label> 
			<textarea class="form-control" id="catdescription" name="description" rows="3" class="form-control"></textarea>
		  </div> -->
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Add a Sub-Category</button> 
           </div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />
