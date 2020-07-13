/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Parth_Lathiya
 */
@WebServlet("/updatebyacc1")
public class updatebyacc1 extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        try {
           // PrintWriter out = response.getWriter() ;
            HttpSession session=request.getSession();
 if(session.getAttribute("username")!=null)           
 {      
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        //Date parsed = format.parse("20110210");DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
    // String pid=request.getParameter("pid");
     //   String empid =(String)session.getAttribute("id");
     //   String sal = request.getParameter("sal");
      String userName = request.getParameter("userName");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob=request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phoneno = request.getParameter("phoneno");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String doj=request.getParameter("doj");
        String bankname = request.getParameter("bankname");
        String branchname = request.getParameter("branchname");
        Integer accno = Integer.parseInt(request.getParameter("accno"));
        Float bs = Float.parseFloat(request.getParameter("bs"));
        
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_database","root","nikita");
     
            PreparedStatement ps=con.prepareStatement("UPDATE person SET firstName=?,lastName=?,dob=?,gender=?,address=?,contactNumber=?,email=?,designation=?,dateofjoin=?,bankname=?,branch=?,accno=?,salary=? WHERE userName=?");
            //ps.setString(1,pid); 
            ps.setString(1,fname);
           // ps.setString(3,mname);
           ps.setString(2,lname);
            ps.setString(3,dob);
            ps.setString(4,gender);
            ps.setString(5,address);
            ps.setString(6,phoneno);
            ps.setString(7,email);
            ps.setString(8,designation);
            ps.setString(9,doj);
            ps.setString(10,bankname);
            //ps.setString(13,dep);
            ps.setString(11,branchname);
            ps.setInt(12,accno);
            ps.setFloat(13,bs);
            ps.setString(14, userName);
            //ps.setString(15,empid);
            int i;
            i=ps.executeUpdate();
            //System.out.println(i);
            if(i!=0)
             response.sendRedirect("welcomeaccountant1.jsp?userName=Employee Details Successfully updated !!");
                else
                System.out.println("error");
                
       ps.close();
 con.close();
 }else
 {
   //out.println("<h4 style=\"color:red;margin-bottom: 5px;padding-left: 5px;\">Your session may be expired. You have to login first</h4>");
              
     response.sendRedirect("index_1.jsp?userName=Your session may be expired. You have to login first");
 }
        }catch(Exception e){
        e.printStackTrace();
        }
    }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
