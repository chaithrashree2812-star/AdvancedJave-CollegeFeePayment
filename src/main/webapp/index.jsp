<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>College Fee Management</title>

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

.box{
background:#f2f2f2;
width:600px;
padding:50px;
border-radius:25px;
text-align:center;
box-shadow:0 0 20px rgba(0,0,0,0.3);
}

h1{
font-size:65px;
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
transition:0.3s;
}

a:hover{
background:#1f3fa3;
}

.view{
background:#16a34a;
}

.view:hover{
background:#15803d;
}

</style>

</head>

<body>

<div class="box">

<h1>College Fee Management</h1>

<a href="feepaymentadd.jsp">
Add Payment
</a>

<a href="DisplayFeePaymentServlet">
View Records
</a>

<a href="UpdateListServlet">
Update Payment
</a>

<a href="feepaymentdelete.jsp">
Delete Payment
</a>

<a href="reports.jsp">
Reports
</a>

</div>

</body>

</html>