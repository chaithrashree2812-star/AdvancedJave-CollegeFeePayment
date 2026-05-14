<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
java.text.SimpleDateFormat sdf =
new java.text.SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");

String currentDate = sdf.format(new java.util.Date());
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Add Payment</title>

<style>

body{
margin:0;
font-family:Arial;
background:linear-gradient(135deg,#0b1d51,#27408b);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.container{
background:white;
padding:40px;
width:500px;
border-radius:25px;
text-align:center;
}

h1{
color:#1f3fa3;
font-size:65px;
margin-bottom:10px;
}

.time{
text-align:right;
font-size:18px;
font-weight:bold;
color:#1f3fa3;
margin-bottom:20px;
}

input,select{
width:90%;
padding:15px;
margin:12px;
font-size:18px;
border:1px solid #ccc;
border-radius:12px;
}

button{
background:#2d56d3;
color:white;
padding:15px 30px;
border:none;
border-radius:12px;
font-size:22px;
cursor:pointer;
font-weight:bold;
}

a{
display:block;
margin-top:25px;
text-decoration:none;
font-weight:bold;
font-size:25px;
color:#1f3fa3;
}

</style>

</head>

<body>

<div class="container">

<h1>Add Payment</h1>

<div class="time">
<%=currentDate%>
</div>

<form action="AddFeePaymentServlet" method="post">

<input type="number"
name="studentID"
placeholder="Enter Student ID"
required>

<input type="text"
name="studentName"
placeholder="Enter Student Name"
required>

<input type="number"
step="0.01"
min="1"
name="amount"
placeholder="Enter Amount"
required>

<select name="status">

<option>Paid</option>

<option>Overdue</option>

</select>

<br><br>

<button type="submit">
Add Payment
</button>

</form>

<a href="index.jsp">Back</a>

</div>

</body>

</html>