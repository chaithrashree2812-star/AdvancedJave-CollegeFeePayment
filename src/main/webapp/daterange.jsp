<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Date Range</title>

<style>

body{
margin:0;
font-family:Arial;
background:linear-gradient(135deg,#102b72,#1e3c8f);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.box{
background:#f2f2f2;
width:500px;
padding:50px;
border-radius:25px;
text-align:center;
}

h1{
font-size:55px;
color:#1f3fa3;
}

input{
width:90%;
padding:15px;
margin:15px 0;
font-size:18px;
border-radius:10px;
border:1px solid #ccc;
}

button{
background:#3558d4;
color:white;
padding:15px 30px;
border:none;
border-radius:10px;
font-size:22px;
cursor:pointer;
font-weight:bold;
}

a{
display:block;
margin-top:25px;
text-decoration:none;
font-size:24px;
font-weight:bold;
color:#1f3fa3;
}

</style>

</head>

<body>

<div class="box">

<h1>Date Range Collection</h1>

<form action="ReportServlet" method="get">

<input type="hidden"
name="type"
value="range">

<label><b>From Date</b></label><br>

<input type="date"
name="fromDate"
required>

<br>

<label><b>To Date</b></label><br>

<input type="date"
name="toDate"
required>

<br><br>

<button type="submit">
Generate Report
</button>

</form>

<a href="reports.jsp">
Back
</a>

</div>

</body>

</html>