package java;

//package validator;

import java.io.*;
import java.sql.*;
import java.sql.SQLException;

public class LoginVerifier {
    
    public static boolean validate(String userName, String password) throws IOException, SQLException {
        
        boolean status = false;
        try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_database","root","nikita");
    
          PreparedStatement ps = con.prepareStatement("SELECT usertype from person WHERE userName=? and password=?");
          ps.setString(1, userName);
           ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
       //     if("parth".equals(uname) && "parth".equals(pass)) 
         if(rs.next())
         { 
             String pass1=password;
             if(password.equals(pass1))
            status = true;
          
            //rs.close();
            //ps.close();
            
           // con.close();
            
         }
        }
        catch(Exception e) {
            System.out.println(e);
        }   
        return status;
    }
}
