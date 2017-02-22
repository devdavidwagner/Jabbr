/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber;

import com.jabber.Data.UserDB;
import com.jabber.Data.authDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jabber.Models.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author David
 */
public class logInServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, 
    HttpServletResponse response)
            throws ServletException, IOException 
    {
         String url = "/index.jsp";
        
       
         String username = request.getParameter("Username");
         String password = request.getParameter("Password");
         String salt = authDB.getUserSalt(username);
            User user = new User(username, password, salt );
            
            String message = "";
            
            //validations
            
            if(username == null || username.length() < 3 || username.isEmpty())
            {
                message += "Please provide a username that is atleast 3 characters" + "<br>";
                  url = "/logIn.jsp";
            }
            else if(password == null || password.length() < 3 || password.isEmpty() )
            {
                message += "Please proved a password that is:" + "<br>" + "more than 6 characters";
                url = "/logIn.jsp";
            }
            else
            {
               
               
                 
                String hashed = BCrypt.hashpw(password, salt);
             
                user.setPassword(hashed);
         
                 
               String oldHash = authDB.logInUser(user);
              
                if(oldHash.equals(user.getPassword()))
                {
                    
                    message = null;
                    url = "/main.jsp";
                
                    try
                    {
                         
                     HttpSession session = request.getSession();
                     session.setAttribute("user", user);
                    
                    }catch(Exception e)
                    {
                        System.out.println("---------------!!!!" + e.toString());
                    }
                  
                }
                else
                {
                  message += "Wrong password for user: " + user.getUsername();
                  url = "/logIn.jsp"; 
                }
            }
        HttpSession session = request.getSession(true);
        
        session.setAttribute("user", user);
        
        
        
            request.setAttribute("username", user.getUsername());
           request.setAttribute("message", message);
       try{
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
       }
       catch(Exception e){
           System.out.println("---------------!!!!" + e.toString());
       }
       
       }
     }


