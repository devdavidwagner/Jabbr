/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber.Data;

import com.jabber.Models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author David
 */
public class authDB {
    public static String getUserSalt(String username) {
        String salt = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
              //  String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
          //  Connection conn1 = DriverManager.getConnection(dbURL, "admin","admin");
             String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
             Connection conn = DriverManager.getConnection(dbURL, "root","Conestoga1");
            
            try{
                
                String preparedSQL = "SELECT salt FROM user WHERE username = ?"; 
                
                PreparedStatement ps = conn.prepareStatement(preparedSQL);
                
                
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {
                   salt = rs.getString("salt");
                }
                
                 conn.close();
                 
                System.out.println(salt);
                
            
               
                
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.printStackTrace();
                
            }
            
            
        } catch(Exception e){
            System.out.println("ERRORRR");
            e.printStackTrace();
            
        }
        
        
        return salt;
        
    }
    
     public static String logInUser(User user) {
        
        
        String hashedPass = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    //  String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
          //  Connection conn1 = DriverManager.getConnection(dbURL, "admin","admin");
             String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
             Connection conn = DriverManager.getConnection(dbURL, "root","Conestoga1");
            
            try{
                
                String preparedSQL = "SELECT password FROM user WHERE username = ?"; 
                
                PreparedStatement ps = conn.prepareStatement(preparedSQL);
                
                
                ps.setString(1, user.getUsername());

                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {
                   hashedPass = rs.getString("password");
                     
                }
                
                 conn.close();
                 
                
                
            
               
                
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.printStackTrace();
                
            }
            
            
        } catch(Exception e){
            System.out.println("ERRORRR");
            e.printStackTrace();
            
        }
        
        
        return hashedPass;
        
   
      
    }
}
