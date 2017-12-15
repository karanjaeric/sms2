<%-- 
    Document   : LoginPage
    Created on : Oct 22, 2017, 8:57:31 AM
    Author     : ekaranja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <form action="LoginServlet"> 
            Please enter your username <input type="text" name="username"/><br> 
            Please enter your password <input type="text" name="password"/> 
            <input type="submit" value="Log In"> 
        </form>
    </body>
</html>
