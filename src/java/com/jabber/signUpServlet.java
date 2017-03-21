/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber;

import com.jabber.Data.UserDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jabber.Models.User;
import org.mindrot.jbcrypt.BCrypt;



public class signUpServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, 
    HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = "/index.jsp";
        
       
             String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            String salt = BCrypt.gensalt();
            String hashed = BCrypt.hashpw(password, salt);
            
            
            User user = new User(username, password, salt);
            
            String message = "";
            
            //validations
            
            if(username == null || username.length() < 3 || username.isEmpty())
            {
                message += "Please provide a username that is atleast 3 characters" + "<br>";
                  url = "/signUp.jsp";
            }
            else if(password == null || password.length() < 6 || password.isEmpty() )
            {
                message += "Please provide a password that is:" + "<br>" + "more than 6 characters";
                url = "/signUp.jsp";
            }
            else
            {
 
                
                if(UserDB.checkUserExits(user) == true)
                {
                    message = "Username taken!";
                    url = "/signUp.jsp";
                }
                else
                {
                       user.setPassword(hashed);
                UserDB.insert(user);
                message = null;
                url = "/thankYou.jsp";
                }
                
             
            }
        
           request.setAttribute("user", user);
           request.setAttribute("message", message);
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
     }
  
}
