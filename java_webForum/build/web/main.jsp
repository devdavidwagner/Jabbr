<%-- 
    Document   : main
    Created on : 7-Feb-2017, 7:47:18 PM
    Author     : David
--%>

<%@page import="com.jabber.Models.User"%>
<jsp:include page="/includes/forumBannerUser.jsp" />
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<sql:setDataSource var="thread" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true"
     user="admin"  password="admin"/>




<sql:query dataSource="${thread}" var="recentThreads">
SELECT * FROM jabber.thread
ORDER BY postedTime;
</sql:query>


    <section>
        <div id ="tray">
            <p style="color:red; font-weight: bold;">${message}</p>
            <form action = "main" method ="post">
                <label for="title">Title
                    
                    <input type="text" name ="title" required><br>
                </label>
                <label for="content">
                    <textarea cols="25" rows="7" name="content"></textarea> <br>
            </label>
            
            
            <button type="Submit" class = "btn"  value="submit"id="sub">Post</button>
            </form>
                
                
            
        </div>
            
        <c:forEach var="row" items="${recentThreads.rows}">
          
            <div id = "posts">
                <h4><c:out value="${row.threadTitle}"/></h4>
                <div>
                    <p  style="font-style: italic;">By: <c:out value="${row.username}"/></p>
                    <p style="font-size: 12px;"><c:out value="${row.postedTime}"/></p>
                    <hr>
                    
                    
                    
        
                </div>
                    
                    <div id="content">
                        
                        <p><c:out value="${row.threadContent}"/></p>
                        <p hidden  id="asd"><c:out value="${row.threadID}"/></p>
                        
                        
                    </div>
                
             
                <hr>
                <div id="options">
                   
                    <c:if test="${user.username == row.username}">
                    <form action="edit">
                       <input type="text" name="threadID" value="${row.threadID}" hidden>   
                    <input type="Submit" value ="Edit" class="btn" id ="edit"/>
                    </form>
                    
                    
                    <form action="delete" method = "post">
                         <input type="text" name="threadID" value="${row.threadID}" hidden>
                         <input type="Submit" value ="Delete" class = "btn" id ="delete"/>
                    
                    </form>
                </c:if>
               
                       
                      
                      
                    
                 
                </div>
                
                       
                     <div class="replyFormDiv">
               <button type="Submit" class = "btn"  value="reply" id="reply">Reply</button>
                           <div class ="hideTheseReply" id="${row.threadID}" >
                           <form action = "reply" method ="post">

                                <label for="content">
                                  <textarea cols="25" rows="7" name="content" class="replyContent"></textarea> <br>
                                </label>
                         
                                
                       
                                <button type="Submit" class = "btn"  value="Submit" id="sub">Submit Reply</button>
                               
                                </form>
                               </div>
                         </div>   
            </div>
                        
                  
       
        
        </c:forEach></section>




<jsp:include page="/includes/forumFooter.jsp" />
