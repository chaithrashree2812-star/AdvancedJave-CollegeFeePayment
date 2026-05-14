<%@ page import="java.sql.*" %>

<%
String id = request.getParameter("id");

String studentName="";
String amount="";
String status="";

boolean found=false;

if(id != null){

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"chai@28"
);

PreparedStatement ps =
con.prepareStatement(
"select * from feepayments where PaymentID=?");

ps.setInt(1,Integer.parseInt(id));

ResultSet rs = ps.executeQuery();

if(rs.next()){

found=true;

studentName = rs.getString("StudentName");
amount = rs.getString("Amount");
status = rs.getString("Status");

}

con.close();

}catch(Exception e){

out.println(e);

}
}
%>

<html>

<head>

<title>Delete Payment</title>

<style>

body{
margin:0;
font-family:Arial;
background:linear-gradient(135deg,#102b72,#1e3c8f);
display:flex;
justify-content:center;
align-items:center;
height:100vh;
}

.box{
background:#f2f2f2;
width:600px;
padding:40px;
border-radius:25px;
text-align:center;
}

h1{
color:#e12626;
font-size:65px;
}

input{
width:90%;
padding:15px;
margin:15px 0;
font-size:20px;
border-radius:10px;
border:1px solid #ccc;
}

button{
background:#2d56d3;
color:white;
padding:15px 35px;
border:none;
border-radius:10px;
font-size:22px;
cursor:pointer;
font-weight:bold;
}

.deletebtn{
background:#e12626;
}

.details{
background:#fff;
padding:25px;
border-radius:15px;
text-align:left;
margin-top:20px;
font-size:20px;
}

a{
display:block;
margin-top:25px;
text-decoration:none;
font-size:25px;
font-weight:bold;
color:#102b72;
}

</style>

</head>

<body>

<div class="box">

<h1>Delete Payment</h1>

<%
if(id == null){
%>

<form method="get">

<input type="number"
name="id"
placeholder="Enter Payment ID"
required>

<br>

<button type="submit">
Delete
</button>

</form>

<%
}
else if(found){
%>

<div class="details">

<p><b>Record ID :</b> <%=id%></p>

<p><b>Student Name :</b> <%=studentName%></p>

<p><b>Amount :</b> Rs. <%=amount%></p>

<p><b>Status :</b> <%=status%></p>

</div>

<h2 style="color:#e12626;">
Are you sure you want to delete this record?
</h2>

<form action="DeleteFeePaymentServlet" method="post">

<input type="hidden"
name="paymentID"
value="<%=id%>">

<button type="submit" class="deletebtn">
Delete Payment
</button>

</form>

<%
}
else{
%>

<h2 style="color:red;">
Payment ID does not exist
</h2>

<a href="feepaymentdelete.jsp">
Try Again
</a>

<%
}
%>

<a href="index.jsp">Back</a>

</div>

</body>

</html>