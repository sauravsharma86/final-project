
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onlive drive - Register page.</title>
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


        <form action="RegisterServlet" method="post">
            First Name : <input type="text" name="fn"/><br><br>
            Last Name : <input type="text" name="ln"/><br><br>
            Phone Number : <input type="text" name="pn"/><br><br>
            Address : <input type="text" name="addr"/><br><br>
            Email : <input type="text" name="email"/><br><br>
            Password : <input type="text" name="userPassword"/><br><br><br>
            <input type="submit" name="Register"/>
        </form>        
    </body>
</html>
