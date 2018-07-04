<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<style>
.container {
	position: relative;
	max-width: 800px; /* Maximum width */
	margin: 0 auto; /* Center it */
}

.container .content {
	position: absolute; /* Position the background text */
	margin-top: 120px; top : 0;
	/* At the bottom. Use top:0 to append it to the top */
	background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
	color: #f1f1f1; /* Grey text */
	width: 100%; /* Full width */
	padding: 20px;
	top: 0 /* Some padding */
}

.button {
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	border-radius: 5px;
}
</style>
</head>
<body>

	<div class="container">
		<img src="regbackground.jpg" alt="Notebook" style="width: 100%;">
		<div class="content">
			<h1>Hello</h1> 
			<h1>${sessionScope.user}</h1>
			<p>You are Successfully registered</p>
			<label>Kindly login to access our services</label>
			<a href="index.jsp"><button class="button" type="submit">Login</button></a>
	

		</div>

	</div>


</body>
</html>