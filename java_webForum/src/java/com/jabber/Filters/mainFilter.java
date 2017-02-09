/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber.Filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class  mainFilter implements Filter {


    
 @Override
 public void init(FilterConfig filterConfig) throws ServletException
 {
     
 }
 
 @Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
       
        if (session == null || session.getAttribute("username") == null) {
            System.out.println("ERROR?----------------");
            response.sendRedirect(request.getContextPath() + "/logIn.jsp"); // No logged-in user found, so redirect to login page.
        } else {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
                 System.out.println("sucess?----------------");
        }
}

@Override
public void destroy(){
 
}

}
