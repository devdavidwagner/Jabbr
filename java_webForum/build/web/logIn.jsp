<%-- 
    Document   : logIn
    Created on : 7-Feb-2017, 7:18:45 PM
    Author     : David
--%>

<jsp:include page="/includes/forumBanner.jsp" />


<section id="logInSec">
    
    <h1>Log-In</h1>
    
        <c:if test="${message != null}">
        <p style="font-color: red;"><i>${message}</i></p>
        </c:if>
        
    <form action="logIn" method="post">
        <label for="Username">Username</label><br>
        <input type="text" name="Username" value="${user.username}" required="true"><br>
        <label for="Password">Password</label><br>
        <input type="password" name="Password" id="pass" value="${user.password}" password required="true"><br>
    
        <input type="Submit" name="Submit" value="Log In">
    </form>
    
</section>



<jsp:include page="/includes/forumFooter.jsp" />
