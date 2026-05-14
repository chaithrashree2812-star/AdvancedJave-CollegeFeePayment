<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Reports</title>

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
width:600px;
padding:50px;
border-radius:25px;
text-align:center;
}

h1{
font-size:70px;
color:#1f3fa3;
margin-bottom:40px;
}

a{
display:block;
background:#3558d4;
color:white;
text-decoration:none;
padding:18px;
margin:18px 0;
font-size:24px;
font-weight:bold;
border-radius:15px;
}

.home{
background:#2faf40;
}

</style>

</head>

<body>

<div class="box">

<h1>Reports</h1>

<a href="ReportServlet?type=overdue">
Overdue Students
</a>

<a href="daterange.jsp">
Date Range Collection
</a>

<a href="ReportServlet?type=paid">
Paid Students
</a>

<a href="index.jsp" class="home">
Home
</a>

</div>

</body>

</html>