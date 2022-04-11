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
               <form action="userLogin">
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="text" class="form-control" placeholder="User Name" name="username">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password" name="password">
                  </div>
                  <button type="submit" class="btn btn-black">
         			Login</button>
                  <!-- button type="submit" class="btn btn-black">Login</button>
                  <button type="submit" class="btn btn-secondary">Register</button> -->
                  <input type="text" class="form-control" name="_csrf" value="${_csrf.token}">
               </form>
            </div>
         </div>
      </div>
	<script src="/resources/vendor/js/jquery.js"></script>
	<script src="/resources/vendor/js/bootstrap.js"></script>
</body>
</html>