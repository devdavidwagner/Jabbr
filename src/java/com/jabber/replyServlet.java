/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber;

import com.jabber.Data.ReplyDB;
import com.jabber.Models.ThreadPost;
import com.jabber.Models.User;
import com.jabber.Models.Reply;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class replyServlet extends HttpServlet {

  

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        
      String isReply = request.getParameter("isReply");
      if(isReply == null)
      {
            System.out.println("--------- original reply ------!!!!");

            String content = request.getParameter("replyContent");
            User user = (User) session.getAttribute("user");
            String threadID = request.getParameter("threadReply");
             LocalDate time = LocalDate.now();


           String url = "";

            String errorMessage = "";
            Boolean error = false;

            //validations
            if(user == null)
            {
                errorMessage += "User not logged in!";
                error = true;
            }


            if(content == "")
            {
                errorMessage += "You must enter some content for your reply!";
                error = true;
            }

           if(error == false)
           {
              Reply reply = new Reply();
              reply.setContent(content);
              reply.setUsername(user.getUsername());
              reply.setTime(time);
              reply.setThreadID(threadID);

              ReplyDB.insert(reply);

             url = "/main.jsp";

           }
           else
           {
                url = "/main.jsp";
               request.setAttribute("messageReply", errorMessage);
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
            else
            {
                System.out.println("--------- child reply ------!!!!");
                
                String content = request.getParameter("replyContent");
            User user = (User) session.getAttribute("user");
             String replyID = request.getParameter("parentReply");
              String threadID = request.getParameter("threadReply");
             LocalDate time = LocalDate.now();


           String url = "";

            String errorMessage = "";
            Boolean error = false;

            //validations
            if(user == null)
            {
                errorMessage += "User not logged in!";
                error = true;
            }


            if(content == "")
            {
                errorMessage += "You must enter some content for your reply!";
                error = true;
            }

           if(error == false)
           {
              Reply reply = new Reply();
              reply.setContent(content);
              reply.setUsername(user.getUsername());
              reply.setTime(time);
              reply.setThreadID(threadID);
              reply.setParentReplyID(replyID);

              ReplyDB.insertSubReply(reply);

             url = "/main.jsp";

           }
           else
           {
                url = "/main.jsp";
               request.setAttribute("messageReply", errorMessage);
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
    
    }

    


