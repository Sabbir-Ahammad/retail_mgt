<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/people/supplier/common.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-12">
	<div class="col-md-3"></div>
	<div class="col-md-9" style="margin-top: 10px">
		<div class="text-center"><h4>Edit Supplier</h4></div>
		<form action="/supplier/update" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Supplier Code<span class="text-danger"> *</span></label> 
		      <input type="hidden" id="id" name="id" class="form-control" value="${supplier.id}">
		      <input type="text" id="supplierCode" name="supplierCode" class="form-control" value="${supplier.supplierCode}"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Category Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="supplierName" name="supplierName" class="form-control" value="${supplier.supplierName}"> 
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="form-control-label px-3">Supplier Address</label> 
			<textarea class="form-control" id="supplierAddress" name="supplierAddress" rows="3" class="form-control">${supplier.supplierAddress}</textarea>
		  </div>
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Save</button> 
           </div>
		</form>
	</div>
	<div class="col-md-3"></div>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />
