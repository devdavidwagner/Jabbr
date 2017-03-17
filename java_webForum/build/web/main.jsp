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


<sql:query dataSource="${thread}" var="reply">
SELECT * FROM jabber.reply;
</sql:query>

<sql:query dataSource="${thread}" var="recentThreads">
SELECT * FROM jabber.thread
ORDER BY postedTime DESC;
</sql:query>


    <section>
        <div id ="tray">
            <h1 style="width: 200px;">New Jab! </h1>
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
                <h2 id="titles"><c:out value="${row.threadTitle}"/></h2>
                <div>
                    <p  style="font-style: italic; text-decoration: underline; font-size: 15px;">By: <c:out value="${row.username}"/></p>
                    <p style="font-size: 12px;"><c:out value="${row.postedTime}"/></p>
                    <hr>
                    
                    
                    
        
                </div>
                    
                    <div id="content">
                        
                        <p><c:out value="${row.threadContent}"/></p>
                        
                        
                        <hr>
                    </div>
                    <div id ="replies">
                       
                            
                        <c:forEach var="replyRow" items="${reply.rows}">
                             <c:if test="${row.threadID == replyRow.threadID}">
                                   
                                 <p  style="font-style: italic; text-decoration: underline; font-size: 12px;"><c:out value="${replyRow.username}"/></p>
                                    <p style="font-style: italic; font-size: 8px;"><c:out value="${replyRow.postedTime}"/></p>
                                    <hr>
                                   <p><c:out value="${replyRow.replyContent}"/></p>
                                   <hr>
                                  
                             </c:if>
                        </c:forEach>  
                       
                            
                            
                            
                    </div>
                
             
             
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
               <button type="Submit" class = "btnReply"  value="reply" id="${row.threadID}">Reply</button>
               <p style="color:red; font-weight: bold;">${messageReply}</p>
                           <div class ="hideTheseReply" id="t${row.threadID}">
                           <form action = "reply" method ="post">
                                
                                <label for="content">
                                  <textarea cols="25" rows="7" name="replyContent" class="replyContent"></textarea> <br>
                                </label>
                         
                                 
                                 <input type="text" name="threadReply" value="${row.threadID}" hidden>
                                <button type="Submit" class = "btn"  value="Submit" id="sub">Submit Reply</button>
                               
                                </form>
                               </div>
                         </div>   
            </div>
                        
                  
       
        
        </c:forEach></section>




<jsp:include page="/includes/forumFooter.jsp" />
