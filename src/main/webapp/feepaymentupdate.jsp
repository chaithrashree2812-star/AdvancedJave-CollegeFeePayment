<%@ page import="java.sql.*" %>

<%
String id = request.getParameter("id");

String paymentID="";
String studentID="";
String studentName="";
String paymentDate="";
String amount="";
String status="Paid";

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

paymentID = rs.getString("PaymentID");
studentID = rs.getString("StudentID");
studentName = rs.getString("StudentName");
paymentDate = rs.getString("PaymentDate");
amount = rs.getString("Amount");
status = rs.getString("Status");

}

con.close();

}catch(Exception e){

out.println(e);

}
%>

<html>

<head>

<title>Update Payment</title>

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
width:500px;
padding:40px;
border-radius:20px;
text-align:center;
}

h1{
color:#102b72;
font-size:50px;
}

input,select{
width:100%;
padding:15px;
margin:12px 0;
border-radius:10px;
border:1px solid #ccc;
font-size:16px;
box-sizing:border-box;
}

button{
background:#2d56d3;
color:white;
padding:15px 30px;
border:none;
border-radius:10px;
font-size:20px;
cursor:pointer;
}

a{
text-decoration:none;
font-size:22px;
font-weight:bold;
color:#102b72;
}

.idbox{
background:#ddd;
font-weight:bold;
}

</style>

</head>

<body>

<div class="box">

<h1>Update Payment</h1>

<form action="UpdateFeePaymentServlet" method="post">

<input type="hidden"
name="paymentID"
value="<%=paymentID%>">

<input type="text"
value="Payment ID : <%=paymentID%>"
class="idbox"
readonly>

<input type="text"
name="studentID"
value="<%=studentID%>"
required>

<input type="text"
name="studentName"
value="<%=studentName%>"
required>

<input type="text"
name="paymentDate"
value="<%=paymentDate%>"
required>

<input type="text"
name="amount"
value="<%=amount%>"
required>

<select name="status">

<option value="Paid"
<%=status.equals("Paid")?"selected":""%>>
Paid
</option>

<option value="Overdue"
<%=status.equals("Overdue")?"selected":""%>>
Overdue
</option>

</select>

<br><br>

<button type="submit">
Update Payment
</button>

</form>

<br>

<a href="UpdateListServlet">
Back
</a>

</div>

</body>

</html>