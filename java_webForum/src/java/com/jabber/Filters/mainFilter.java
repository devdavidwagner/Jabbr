/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber.Filters;

import java.io.IOException;
import javax.servlet.*;

/**
 *
 * @author David
 */
public class  mainFilter implements Filter {

   private  FilterConfig filterConfig = null;
    
 @override
 public void init(FilterConfig filterConfig)
 {
     this.filterConfig = filterConfig;
 }
 
 @override
public void doFilter(ServletRequest req, ServletResponse res,
      FilterChain chain) throws IOException, ServletException 
{

  if (isLoggedIn) {
    //if user is logged in, complete request
    chain.doFilter(req, res);
  } else {
    //not logged in, go to login page
    res.sendRedirect("/login");
    }
}

@override
public void destroy(){
    filterConfig = null;
}

}
