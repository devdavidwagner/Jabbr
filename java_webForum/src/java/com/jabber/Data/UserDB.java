package com.jabber.Data;

import com.jabber.Models.User;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class UserDB {
    
    
    public static boolean checkUserExits(User user)
    {
        
        int userID = 0;
        boolean exists = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
            Connection conn = DriverManager.getConnection(dbURL, "admin","admin");
            
            try{
                
                String preparedSQL = "SELECT userID FROM user WHERE username = ?";
                
                PreparedStatement ps = conn.prepareStatement(preparedSQL);
                
                ps.setString(1, user.getUsername());
            
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {
                    userID = rs.getInt(1);
                }
                
               
                
                 conn.commit(); // This statement fixed the problem
                conn.close();
                  System.out.println("Inserted record in the table");
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.printStackTrace();
                
            }
            
            
        } catch(Exception e){
            System.out.println("ERRORRR");
            e.printStackTrace();
            
        }
        
         if(userID > 0)
             exists = true;
          
        return exists;
        
        
        
    }

    public static long insert(User user) {
        
        int status = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
            Connection conn = DriverManager.getConnection(dbURL, "admin","admin");
            
            try{
                
                String preparedSQL = "INSERT INTO user (userID, username, password, salt)" +
                        "VALUES (?,?,?,?)";
                
                PreparedStatement ps = conn.prepareStatement(preparedSQL);
                
                ps.setString(1, null);
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getSalt());
                
                status = ps.executeUpdate();
                
                 conn.commit(); // This statement fixed the problem
                conn.close();
                  System.out.println("Inserted record in the table");
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.printStackTrace();
                
            }
            
            
        } catch(Exception e){
            System.out.println("ERRORRR");
            e.printStackTrace();
            
        }
        
        
        return status;
        
   
      
    }
}
