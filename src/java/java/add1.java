
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
@WebServlet("/add1")
public class add1 extends HttpServlet {

    
    
    
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
           String id =request.getParameter("id");
      //  String sal = request.getParameter("sal");
        String fname = request.getParameter("fname");
     //   String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
       // System.out.println(fname);
       String userName=request.getParameter("userName");
         String password=request.getParameter("password");

       
         //   java.util.Date parsed = format.parse(request.getParameter("dob"));
          //  java.sql.Date dob = new java.sql.Date(parsed.getTime());
       //         java.util.Date dob = format.parse();
        String dob=request.getParameter("dob");
        String token=request.getParameter("token");
       String  persontype=request.getParameter("persontype");
       String gender=request.getParameter("gender");
       String address=request.getParameter("address");

        String phoneno = request.getParameter("phoneno");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String doj=request.getParameter("doj");
    
        //       java.util.Date parsed1 = format.parse(request.getParameter("doj"));
      //      java.sql.Date doj = new java.sql.Date(parsed1.getTime());
      //          java.sql.Date doj = format.parse(request.getParameter("doj"));
        String bankname = request.getParameter("bankname");
        
        String branchname = request.getParameter("branchname");
        Integer accno = Integer.parseInt(request.getParameter("accno"));
       // String dep = request.getParameter("dep");
        Float bs = Float.parseFloat(request.getParameter("bs"));
        //out.println(empid);
      //  out.println(fname);
       // out.println(email);
      //  out.println(phoneno);
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_database","root","nikita");
     //(FirstName,LastName,ID,DOB,Designation) 
            //String query = "INSERT INTO Employee " + " VALUES ('"+fname+"','"+lname+"','"+id+"','"+dob+"','"+phoneno+"','"+designation+"','"+date+"')";
            
            //   String query = "INSERT INTO table1 " + "VALUES ('" + name + "')";
       
        //   String query1 = "UPDATE salary SET BS='"+salary+"' WHERE EmployeeID='"+id+"'";
            PreparedStatement ps=con.prepareStatement("INSERT INTO person VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1,id);

                       // ps.setString(2,sal);
            ps.setString(2,fname);
          //  ps.setString(4,mname);
           ps.setString(3,lname);
           ps.setString(4, userName);
           ps.setString(5, password);
            ps.setString(6,dob);
            ps.setString(7, token);
            ps.setString(8, persontype);
            ps.setString(9, gender);
            ps.setString(10,address);
            ps.setString(11,phoneno);
            ps.setString(12,email);
            ps.setString(13,designation);
            ps.setString(14,doj);
            ps.setString(15,bankname);
           
            ps.setString(16,branchname);
             ps.setInt(17,accno);
           // ps.setString(14,dep);
            ps.setFloat(18,bs);
            int i;
            i=ps.executeUpdate();
            //System.out.println(i);
            if(i!=0)
             response.sendRedirect("welcomeaccountantz.jsp?userName=Employee Details Successfully added !!");
                else
                System.out.println("error");
                
       ps.close();
 con.close();
 }else
 {
   //out.println("<h4 style=\"color:red;margin-bottom: 5px;padding-left: 5px;\">Your session may be expired. You have to login first</h4>");
              
     response.sendRedirect("index.jsp?userName=Your session may be expired. You have to login first");
 }
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    }

    