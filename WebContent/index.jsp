<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
/* Set a style for all buttons */
.button1 {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;

}
.button2{
width:60px;
color:white;
background-color:blue;
cursor: pointer;
float:right;

}

button:hover {
    opacity: 0.8;
}


/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 30%;
    border-radius: 10%;
    height:20%;
}

.container {
    padding: 16px;
}
.error{
color:red;
text-align:center;

}
span.psw {
    float: right;
    padding-top:-50px;
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
    background-color: hotpink; /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
   
  border: 2px solid black;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */
height:30;

  filter: alpha(opacity=60);

}

div.modal-content p {
  margin: 5%;
  font-weight: bold;
  color: #000000;
}

</style>

<script>
function myFunction() {
    var x = document.getElementById("myPassword");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
</script>
</head>
<body>



<div id="id01" class="modal">
  
  <form class="modal-content" action="logservlet" method="post">
    <div class="imgcontainer">

      <img src="login2.png" class="avatar" alt="images">
    </div>

    <div class="container">
   
    <label class="error">${error}</label>
    <br>
   
    <button type="reset" class="button2">Reset</button>
      <label for="uname"><b>User name</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" id="myPassword" required>
      <input type="checkbox" onclick="myFunction()">Show Password
        
      <button type="submit" style="font-size:16px;" class="button1"><b>Login</b></button>
    
    </div>

    <div class="container" style="background-color:#f1f1f1">
    <span class="reg">Don't have an account? <a href="<%=request.getContextPath()%>/register" style="text-decoration:none;"> Register </a></span>
      <span class="psw">Forgot <a href="forgotPassword.jsp" style="text-decoration:none;">password?</a></span>
    </div>
  </form>
</div>
</body>
</html>
