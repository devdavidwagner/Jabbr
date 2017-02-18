<%-- 
    Document   : main
    Created on : 7-Feb-2017, 7:47:18 PM
    Author     : David
--%>

<jsp:include page="/includes/forumBannerUser.jsp" />
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<sql:setDataSource var="thread" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true"
     user="admin"  password="admin"/>


<!--Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/jabber?relaxAutoCommit=true";  
            Connection conn = DriverManager.getConnection(dbURL, "admin","admin");
-->


<sql:query dataSource="${thread}" var="recentThreads">
SELECT * FROM jabber.thread;
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
            
            
            <button type="Submit" value="submit">Post</button>
            </form>
                
                
            
        </div>
            
        <c:forEach var="row" items="${recentThreads.rows}">
                <form action="post">
                    
                    <input type="Submit" value ="Edit" class="btn" id ="edit"/>
                    <input type="text" name="threadID" value="${row.threadID}" hidden>
                </form>
                <form>
                    
                    <input type="Submit" value ="Delete" class = "btn" d ="delete"/>
                    
                </form>
            <div id = "posts">
                <h1><c:out value="${row.threadTitle}"/></h1>
                <div>
                    <p  style="font-style: italic;"><c:out value="${row.username}"/></p>
                    <p style="font-size: 2px;"><c:out value="${row.postedTime}"/></p>
                    <hr>
                    
                    
                    
        
                </div>
                    
                    <div>
                        
                        <p><c:out value="${row.threadContent}"/></p>
                        
                        
                        
                    </div>
                
             
                <hr>
                
                   
                
            </div>
        
        
        </c:forEach></section>




<jsp:include page="/includes/forumFooter.jsp" />
