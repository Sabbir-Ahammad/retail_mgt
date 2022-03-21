<jsp:include page="/WEB-INF/view/common/header.jsp" />
<jsp:include page="/WEB-INF/view/category/common.jsp" />

<style>
.center_div{
    margin: 0 auto;
    width:80% /* value of your choice which suits your alignment */
}
</style>

<div class="center_div">
		<div class="text-center mt-4 mb-4"><h4>Add Category</h4></div>
		<form action="/category/save" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label>Category Code<span class="text-danger"> *</span></label> 
		      <input type="text" id="catcode" name="code" placeholder="Enter category code" class="form-control"> 
		    </div>
		    <div class="form-group col-md-6">
		      <label class="form-control-label px-3">Category Name<span class="text-danger"> *</span></label> 
	          <input type="text" id="catname" name="name" placeholder="Enter category name" class="form-control"> 
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="form-control-label px-3">Category Description</label> 
			<textarea class="form-control" id="catdescription" name="description" rows="3" class="form-control"></textarea>
		  </div>
		  <div class="form-group col-sm-6"> 
               <button type="submit" class="btn btn-block btn-primary">Add Category</button> 
           </div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />
