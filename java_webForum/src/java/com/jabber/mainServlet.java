/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber;

import com.jabber.Data.PostDB;
import com.jabber.Models.ThreadPost;
import com.jabber.Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class mainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
    HttpServletResponse response)
            throws ServletException, IOException 
    {
         HttpSession session = request.getSession();
        
           String title = request.getParameter("title");
          String content = request.getParameter("content");
          User user = (User) session.getAttribute("user");
           LocalDate time = LocalDate.now();
          
         
         String url = "";
          
          String errorMessage = "";
          Boolean error = false;
          
          //validations
          
          if(title == "")
          {
              errorMessage += "You must enter a title!";
              error = true;
          }
          
          if(content == "")
          {
              errorMessage += "You must enter some content!";
              error = true;
          }
          
         if(error == false)
         {
             ThreadPost thread = new ThreadPost();
            thread.setContent(content);
            thread.setTitle(title);
            thread.setUsername(user.getUsername());
            thread.setTime(time);
            
            PostDB.insert(thread);
            
           url = "/main.jsp";
            
         }
         else
         {
              url = "/main.jsp";
             request.setAttribute("message", errorMessage);
         }
         
         
        
        
               
                  
                  try{
                      getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                  }catch(Exception e)
                  {
                         System.out.println("---------"+ e.toString() +"------!!!!");
                  }
          
       }
        
        
    }
    
    
    
   

