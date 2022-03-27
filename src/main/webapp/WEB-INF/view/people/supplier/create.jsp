<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/people/supplier/common.jsp"/>
<style>
.center_div{
    margin: 0 auto;
    width:80% /* value of your choice which suits your alignment */
}
</style>
<div class="center_div">
		<div class="text-center mt-4 mb-4"><h4>Add Supplier</h4></div>
		<form action="/supplier/save" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Supplier Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="supplierCode" name="supplierCode" placeholder="Enter Supplier code" class="form-control"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Supplier Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="supplierName" name="supplierName" placeholder="Enter Supplier name" class="form-control"> 
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="form-control-label px-3">Supplier Address</label> 
			<textarea class="form-control" id="supplierAddress" name="supplierAddress" rows="3" class="form-control"></textarea>
		  </div>
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Add Supplier</button> 
           </div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />