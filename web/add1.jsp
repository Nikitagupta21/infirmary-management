
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
  <li><a href="add1.jsp">Add Employee</a></li>
  <!--view employee list-->
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>
        <div class="well1">
      
        <form method="post" action="add">
        <table style="margin-left:5px;align-content:center;width:100%;margin-top: 30px;border-spacing: 0.9em;font-family: tahoma">
            <tr><td>Employee ID</td><td><input type="text" clospan="7" name="empid"></td>
                <td>Salutation</td><td><input type="text" name="sal"></td></tr>
            <tr>    <td>First Name</td><td><input type="text" name="fname"></td>
            <td>Middle Name</td><td><input type="text" name="mname"></td>
            <td>Last Name</td><td><input type="text" name="lname"></td></tr>
            <tr><td>Date Of Birth<br>(YYYY-MM-DD)</td><td><input type="date" name="dob"></td>
            <td>Phone No</td><td><input type="text" name="phoneno"></td>
            <td>Email Id</td><td><input type="email" name="email"></td></tr>
            <tr> <td>Date Of Joining<br>(YYYY-MM-DD)</td><td><input type="date" name="doj"></td>
            <td>Designation</td><td><input type="text" name="designation"></td>
            <td>Bank Name</td><td><input type="text" name="bankname"></td></tr>
            <tr><td>Account No</td><td><input type="text" name="accno"></td>
            
            <td>Branch Name</td><td><input type="text" name="branchname"></td>
            <td>Department</td><td><input type="text" name="dep"></td>
            
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
     response.sendRedirect("index_1.jsp?id=Your session may be expired. You have to login first");

    
 }
 
        %>
    </body>
</html>
