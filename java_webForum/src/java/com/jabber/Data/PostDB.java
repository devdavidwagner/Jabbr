package com.jabber.Data;

import com.jabber.Models.ThreadPost;
import com.jabber.Models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class PostDB {
    public static long delete(int threadID) {
        int status = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
            Connection conn1 = DriverManager.getConnection(dbURL, "admin","admin");
            
            

            
            
                String preparedSQL = "DELETE FROM reply WHERE threadID = ?;" ;
                
              String preparedSQL2 = "DELETE FROM thread WHERE threadID = ?;";
              PreparedStatement ps = conn1.prepareStatement(preparedSQL);
              PreparedStatement ps2 = conn1.prepareStatement(preparedSQL2);
              
              ps.setInt(1, threadID);
              ps2.setInt(1, threadID);
              status = ps.executeUpdate();
              ps2.executeUpdate();
              conn1.commit(); // This statement fixed the problem
              conn1.close();
            
            
        }
        
        catch(Exception e){
            
              System.out.println("ERRORRR  " + e.toString());
                
        }
        
        return status;
    }
    public static long insert(ThreadPost post) {
        
        int status = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
            Connection conn1 = DriverManager.getConnection(dbURL, "admin","admin");
     
            int userID = 0;
             String preparedSQL2 = "SELECT userID from user WHERE username = ?";
            PreparedStatement ps2 = conn1.prepareStatement(preparedSQL2);
            
            ps2.setString(1, post.getUsername());

                ResultSet rs = ps2.executeQuery();
                
                while(rs.next())
                {
                   userID = rs.getInt("userID");
                }
            
            String preparedSQL = "INSERT INTO thread (threadID, username, userID, threadTitle, postedTime, threadContent)" +
                        "VALUES (?,?,?,?,?,?);";
              PreparedStatement ps = conn1.prepareStatement(preparedSQL);
                ZonedDateTime zdt = ZonedDateTime.now();
            
                ps.setString(1, null);
                ps.setString(2, post.getUsername());
                ps.setInt(3, userID);
                ps.setString(4, post.getTitle());
                ps.setString(5, post.getTime().toString() + " " + zdt.toString() );
                ps.setString(6, post.getContent());
           
               
                
                status = ps.executeUpdate();
                
                conn1.commit(); // This statement fixed the problem
                conn1.close();
                
                  System.out.println("Inserted record in the table" + userID);
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.toString();
                
            }
            
            
       
        
        
        return status;
        
   
      
    }
}
