<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/vendor/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/index.css">

<style>
 
</style>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Retail Management<!-- <br> Login Page --></h2>
            <!-- <p>Login or register from here to access.</p> -->
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="text" class="form-control" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password">
                  </div>
                  <button onclick="location.href='/admin/dashboard'" type="button" class="btn btn-black">
         			Login</button>
                  <!-- button type="submit" class="btn btn-black">Login</button>
                  <button type="submit" class="btn btn-secondary">Register</button> -->
               </form>
            </div>
         </div>
      </div>
      
      
	<!-- <div class="login-page">
	<div class="container">
		<div class="row">
			<div class="col-xl-8 m-auto col-sm-8 col-12">
				<div class="log-box">
					<div class="row">
						<div class="col-xl-5 col-sm-5 col-12 pad-right-0">
							<div class="logo-back">
							</div>
						</div>
						<div class="col-xl-7 col-sm-7 col-12 pad-left-0">
							<div class="log-content">
								<h1>LOGIN </h1>
								<div class="log-body">
								<div class="form-group myr-top">
								<label>Gmail</label>
									<input type="text" class="form-control custom" placeholder="Gmail">
								</div>
								<div class="form-group myr-top">
								<label>Password</label>
									<input type="password" class="form-control custom" placeholder="Password">
								</div>
								<div class="log-btn text-center">
									<a href="/admin/dashboard" class="btn btn-theme1">Login</a>
								</div>
								<div class="log-bottom-cotent">
								<p>Creat an account<a href="signup.html">Sign Up</a>
								<a href="forgotpassword.html" class="pull-right">Forgot Password</a>
								</p>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> -->
	<script src="/resources/vendor/js/jquery.js"></script>
	<script src="/resources/vendor/js/bootstrap.js"></script>
</body>
</html>