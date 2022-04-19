<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/people/customer/common.jsp"/>
<style>
.center_div{
    margin: 0 auto;
    width:80% /* value of your choice which suits your alignment */
}
</style>
<div class="center_div">
		<div class="text-center mt-4 mb-4"><h4>Customer Info.</h4></div>
		<form action="/customer/save" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Customer Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="customerCode" name="customerCode" class="form-control"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Customer Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="customerName" name="customerName" class="form-control"> 
		    </div>
		  </div>
		  <div class="form-row">
		    <div class="form-row col-md-6">
		      <label>Customer Contract(Phone No.)<span class="text-danger"> *</span></label> 
		      <input type="text" id="customerContract" name="customerContract" class="form-control"> 
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="form-control-label px-3">Customer Address</label> 
			<textarea class="form-control" id="customerAddress" name="customerAddress" rows="3" class="form-control"></textarea>
		  </div>
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Add Customer</button> 
           </div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />