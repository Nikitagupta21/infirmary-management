
//package validator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String usertype = request.getParameter("usertype");//its actually db name
         if(usertype.equals("0"))
             response.sendRedirect("indexPay.jsp?userName=Please select User type");
               
       try {Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medic","root","nikita");
    
          PreparedStatement ps = con.prepareStatement("SELECT * from "+usertype+" WHERE userName=?");
          ps.setString(1, uname);
           //ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
       //     if("parth".equals(uname) && "parth".equals(pass)) 
         if(rs.next())
         { 
             String pass1=rs.getString("password");
             if(pass.equals(pass1))
             {
             
            HttpSession session=request.getSession();
            String username1=rs.getString("firstname")+" "+rs.getString("lastname");
            session.setAttribute("username",username1);
            session.setAttribute("userName",uname);
            session.setAttribute("usertype",usertype);
            if(usertype.equals("person")) {   
                RequestDispatcher rd = request.getRequestDispatcher("welcomeemployee.jsp");
                rd.forward(request, response);
            }
            if(usertype.equals("accountant")) {   
                RequestDispatcher rd = request.getRequestDispatcher("welcomeaccountant1.jsp");
                rd.forward(request, response);
            }

            
         }
         rs.close();
         ps.close();
         con.close();
         }
       
         
        else {
                 rs.close();
                 ps.close();
                 con.close();

                //out.println("<h4 style=\"color:red;\">Invalid username & password</h4>");
                response.sendRedirect("indexPay.jsp?userName=Invalid username or password");
                //RequestDispatcher rd = request.getRequestDispatcher("index.html");
                //rd.include(request, response);
                
        
        }
        }
       catch(Exception e){System.out.println(e);}
       
    }
}
