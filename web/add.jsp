
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" media="screen,projection" type="text/css" href="./main.css" />

     <style>
            select
            {
                height: 30px;
                width:150px;
            }
            
            img
            {
                width:150px;
                height:100px;
                margin-left: 70px;
                margin-top: -5px;
            }
            strong
            {
            position: absolute;
            right: 15px;
            top :35px
                
            }
        </style>
 
 <title>Add</title>
    </head>
    <body>
          <% if(session.getAttribute("username")!=null){ %>
        <img src="cc.jpg">
           <strong><% out.println("Welcome "+session.getAttribute("username"));%></strong>
        
           <div class="well">  <ul>
  <li><a href="generatepayslipbyaccz.jsp">Generate Pay-Slip</a></li>
  <li><a href="generatereportbyaccz.jsp">Generate Report</a></li>
  <li><a href="add.jsp">Add Employee</a></li>
  <li><a href="updatebyaccz.jsp">Update Employee</a></li>
 
  <li><a href="addaccountant.jsp">Add Accountant</a></li>
  <li><a href="displayemployee">View Employee List</a></li>
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>
        <div class="well1">
      
        <form method="post" action="add1">
        <table style="margin-left:5px;align-content:center;width:100%;margin-top: 30px;border-spacing: 0.9em;font-family: tahoma">
            <tr><td>person Id</td><td><input type="text" clospan="7" name="id"></td>
             <td>First Name</td><td><input type="text" name="fname"></td>
             <td>Last Name</td><td><input type="text" name="lname"></td></tr>
            <tr> <td>user Name</td><td><input type="text" name="userName"></td>
             <td>password</td><td><input type="password" name="password"></td></tr>
            <tr><td>Date Of Birth<br>(YYYY-MM-DD)</td><td><input name="dob"></td>
                <td>token</td><td><input type="text" name="token"></td></tr>
            <td>person Type</td><td><input type="text" name="persontype"></td>
            <td>gender</td><td><input type="text" name="gender"></td></tr>
              <td>Address</td><td><input type="text" name="address"></td>
              <td>contact number</td><td><input type="text" name="phoneno"></td></tr>
          <tr> <td>Email Id</td><td><input type="email" name="email"></td>
            
            <td>Designation</td><td><input type="text" name="designation"></td></tr>
          <tr>  <td>Date Of Joining<br>(YYYY-MM-DD)</td><td><input type="date" name="doj"></td>
              <td>Bank Name</td><td><input type="text" name="bankname"></td></tr>
            <tr><td>Branch Name</td><td><input type="text" name="branchname"></td>
            
                <td>Account No</td><td><input type="text" name="accno"></td>
            
        
            
        <td>Basic Salary</td><td><input type="text" name="bs"></td></tr>
            <tr><td/><td><button class="btn" type="submit">ADD</button></td>
            <td></td>
            <td></td>
            <td></td></tr>
        </table>
        </form></div>
   <%
 }
        else
 {
     response.sendRedirect("index.jsp?userName=Your session may be expired. You have to login first");

    
 }
 
        %>
    </body>
</html>
