<%-- 
    Document   : userLogged
    Created on : Oct 22, 2017, 9:52:34 AM
    Author     : ekaranja
--%>

<%@page import="com.sms.inventorymodels.YesNo"%>
<%@page import="com.sms.inventorymodels.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged In user</title>
    </head>
    <body>

    <center> 
        <% User currentUser = (User) (session.getAttribute("currentSessionUser"));%> 
        Welcome <%= currentUser.getUserName() + " " + currentUser.getUserProfile().getInventoryAccess()%>

        <%
            if (currentUser.getUserProfile().getInventoryAccess() == YesNo.YES) {
        %>
        You are allowed Access
        <%
            }else{

            %>
            You are not allowed access
<%
            }

            
        %>
    </center>

</body>
</html>
