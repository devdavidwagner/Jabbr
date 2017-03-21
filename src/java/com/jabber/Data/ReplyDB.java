/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber.Data;

import com.jabber.Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;

/**
 *
 * @author David
 */
public class ReplyDB {
    
     public static long insert(Reply reply) {
        
        int status = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
             //  String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
          //  Connection conn1 = DriverManager.getConnection(dbURL, "admin","admin");
             String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
             Connection conn1 = DriverManager.getConnection(dbURL, "root","Conestoga1");
             
             int userID = 0;
             String preparedSQL2 = "SELECT userID from user WHERE username = ?";
            PreparedStatement ps2 = conn1.prepareStatement(preparedSQL2);
            
            ps2.setString(1, reply.getUsername());

                ResultSet rs = ps2.executeQuery();
                
                while(rs.next())
                {
                   userID = rs.getInt("userID");
                }
         
            
            String preparedSQL = "INSERT INTO reply (replyID, username, userID, replyContent, postedTime, threadID)" +
                        "VALUES (?,?,?,?,?,?);";
              PreparedStatement ps = conn1.prepareStatement(preparedSQL);
                ZonedDateTime zdt = ZonedDateTime.now();
            
                ps.setString(1, null);
                ps.setString(2, reply.getUsername());
                ps.setInt(3, userID);
                ps.setString(4, reply.getContent());
                ps.setString(5, reply.getTime().toString() + " " + zdt.toString() );
                ps.setString(6, reply.getThreadID());
           
               
                
                status = ps.executeUpdate();
                
                conn1.commit(); // This statement fixed the problem
                conn1.close();
                
                  System.out.println("Inserted reply in the table");
            } catch (Exception e)
            {
                System.out.println("ERRORRR");
                e.toString();
                
            }
            
            
       
        
        
        return status;
        
   
      
    }
}
