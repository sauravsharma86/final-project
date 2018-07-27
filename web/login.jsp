
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onlive drive - Loginpage</title>
    </head>
    <body>
        <font color="red">
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<br/><br/>");
                out.println(error);
                out.println("<br/><br/>");
            }
        %>
        </font> 


        <form action="LoginServlet" method="post">
            email : <input type="text" name="email"/><br><br>
            Password : <input type="password" name="userPassword"/><br><br><br>
            <input type="submit" name="login"/>
        </form>
        <br><br>
        <a href="register.jsp"> New member? Register here! </a>
    </body>
</html>
