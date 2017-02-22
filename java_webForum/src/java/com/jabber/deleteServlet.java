/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber;

import com.jabber.Data.PostDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class deleteServlet extends HttpServlet {

  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int threadID = Integer.parseInt(request.getParameter("threadID"));
        String url ="";
        String message ="";
        
        try{
                PostDB.delete(threadID);
                message = "Thread deleted!";
        }
        catch(Exception e)
                {
                    message = "Thread does not exist!";
                }
        finally{
            
            request.setAttribute("message", message);
            url= "/main.jsp";
            
            
              getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
    
      
        
    
    }

   
}
