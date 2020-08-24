

<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" media="screen,projection" type="text/css" href="./main.css" />
        <style>
          
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
           
            td{padding-left: 10px}
        </style>
    </head>
    <body>
        <img src="health.jpg">
           <strong><% out.println("Welcome "+session.getAttribute("username"));%></strong>
        
           <div class="well">  <ul>
  <li><a href="generatepayslipbyaccz.jsp">Generate Pay-Slip</a></li>
  <li><a href="generatereportbyaccz.jsp">Generate Report</a></li>
  <li><a href="add.jsp">Add Employee</a></li>
  <li><a href="updatebyaccz.jsp">Update Employee</a></li>
  <!--view employee list-->
  <li><a href="addaccountant.jsp">Add Accountant</a></li>
  <li><a href="displayemployee">View Employee List</a></li>
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>
        <div class="well1">
        <%
  
     //  HttpSession session=request.getSession();
 if(session.getAttribute("username")!=null)           
 {
      //    PrintWriter out = response.getWriter() ;
        String userName = request.getParameter("userName");
 try {       
      Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medic","root","nikita");
     //(FirstName,LastName,ID,DOB,Designation) 
           
            PreparedStatement ps = con.prepareStatement("select * from person where userName=?");
            ps.setString(1, userName);
               ResultSet rs = ps.executeQuery();
            rs.next();
            PreparedStatement ps1 = con.prepareStatement("select * from payslip where userName=?");
            ps1.setString(1, userName);
               ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()==true)
            {
        %>
        <form method="post" action="updatebyaccz">
        <table style="margin-left:5px;align-content:center;width:100%;margin-top: 30px;border-spacing: 0.9em;font-family: tahoma">
             <tr>  <td>personID</td><td><input type="text" name="pid" Value="<%= rs.getString(1)%>" disabled></td>
            <td>First Name</td><td><input type="text" name="fname" Value="<%= rs.getString(2)%>"></td>
            <td>Last Name</td><td><input type="text" name="lname" value="<%= rs.getString(3)%>"></td></tr>
                     <tr>  <td>userName</td><td><input type="text" name="userName" Value="<%= rs.getString(4)%>"></td>
                             <td>password</td><td><input type="password" name="password" Value="<%= rs.getString(5)%>"disabled></td></tr>
            <tr><td>Date Of Birth<br>(YYYY-MM-DD)</td><td><input  name="dob" value="<%= rs.getString(6)%>"></td>
                     <td>token</td><td><input type="text" name="token" Value="<%= rs.getString(7)%>" disabled></td>
                           <td>personType</td><td><input type="text" name="personType" Value="<%= rs.getString(8)%>" disabled></td>
                           <td>gender</td><td><input type="text" name="gender" Value="<%= rs.getString(9)%>"></td></tr>
            <tr> <td>address</td><td><input type="text" name="address" Value="<%= rs.getString(10)%>"></td>
             
                <td>Phone No</td><td><input type="text" name="phoneno" value="<%= rs.getString(11)%>"></td>
            <td>Email Id</td><td><input type="email" name="email" value="<%= rs.getString(12)%>"></td></tr>
                        <tr><td>Designation</td><td><input type="text" name="designation" value="<%= rs.getString(13)%>"></td>
            <td>Date Of Joining<br>(YYYY-MM-DD)</td><td><input type="date" name="doj" value="<%= rs.getDate(14)%>"></td></tr>

           <tr> <td>Bank Name</td><td><input type="text" name="bankname" value="<%= rs.getString(15)%>"  ></td>
             <td>Branch Name</td><td><input type="text" name="branchname" value="<%= rs.getString(16)%>"></td>
                 <td>Account No</td><td><input type="text" name="accno" value="<%= rs.getInt(17)%>"  ></td></tr>
          
       
     
        <td>Basic Salary</td><td><input type="text" name="bs" value="<%= rs.getFloat(18)%>"></td>
             <tr><td><button class="btn" type="submit">Update</button></td></tr>
        
        </table>
        </form></div><%
            }
            else
            {
            response.sendRedirect("updatebyaccz.jsp?userName=Please enter valid employeeid !!");
             
            }
      rs.close();
        ps.close();
        con.close();
      }catch(Exception e){System.out.println(e);}

 }
        else
 {
     response.sendRedirect("indexPay.jsp?userName=Your session may be expired. You have to login first");

    
 }
 
        %>
    </body>
</html>
