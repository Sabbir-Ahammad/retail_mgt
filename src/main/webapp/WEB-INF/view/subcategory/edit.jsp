<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/category/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-12">
	<div class="col-md-3"></div>
	<div class="col-md-9" style="margin-top: 10px">
		<div class="text-center"><h4>Edit Sub-category</h4></div>
		<form action="/category/update" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Category Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="catcode" name="code" placeholder="Enter category code" class="form-control" value="${c.code}"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label>Sub-category Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="catcode" name="code" placeholder="Enter category code" class="form-control" value="${c.code}"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Sub-category Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="catname" name="name" placeholder="Enter category name" class="form-control" value="${c.name}"> 
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
