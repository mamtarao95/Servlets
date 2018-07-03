<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif}

/* Full-width input fields */
input[type=text] {
    width: 100%;
    padding: 6px 6px;
    margin: 12px 0px;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}


.container {
    padding: 16px;
   
}



/* The Modal (background) */
.modal {
    /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 30px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 40%; /* Could be more or less, depending on screen size */
height:20;

}

.login{
float:center;
margin-left:150px;
font-size:17px;

}

.submit{
font-size:20px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}

#overlay {
    position: fixed;
    display: none;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0,0,0,0.5);
    z-index: 2;
    cursor: pointer;
}

#text{
    position: absolute;
    top: 50%;
    left: 50%;
    font-size: 50px;
    color: white;
    transform: translate(-50%,-50%);
    -ms-transform: translate(-50%,-50%);
}
</style>
</head>
<body>

<div id="id01" class="modal">
  
  <form class="modal-content" action="regservlet" method="post">
    <div class="imgcontainer">
    </div>
    <h2 align=center>Sign Up</h2>
    <div class="container">
      <label>FirstName</label>
      <input type="text"  name="firstname" required>

      <label>LastName</label>
      <input type="text" name="lastname" required>
       
      <label>UserName</label>
      <input type="text" name="uname" required>

      <label>Password</label>
      <input type="text" name="password" required>

	<label>Enter Password Again</label>
      <input type="text" name="passwordAgain" required>

      <label>Email-ID</label>
      <input type="text" name="emailid" required>
 
	<label>MobileNumber</label>
      <input type="text" name="mobnum" required>

      <button type="submit" class="submit" onclick="on()"><b>Register</b></button>
<!--       <div id="overlay" onclick="off()">
  <div id="text">You are successfully registered!!!</div>
</div> -->
    <span class="login"><a href="index.jsp" style="text-decoration:none;">Login</a></span>
    </div>
    
  </form>
</div><!-- 

	<script>
		function on() {
			document.getElementById("overlay").style.display = "block";
		}

		function off() {
			document.getElementById("overlay").style.display = "none";
		}
	</script>
 -->
</body>
</html>
