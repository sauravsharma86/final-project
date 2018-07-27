
<%@page import="java.util.List"%>
<%@page import="pojo.Content"%>
<%@page import="pojo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online drive - homepage</title>
    </head>
    <body>
        <%            User user = (User) session.getAttribute("loggedInUser");
        %>
        <table>
            <tr>
                <td style="width: 500px;text-align: -webkit-left;">
                    <h2> <font color="green">                         

                        <%=user.getFirstName() + " " + user.getLastName()%>
                        </font>  </h2>
                </td>
                <td style="width: 500px;text-align: -webkit-right;">
                    <h2><font color="red"><a href="LogoutServlet"> logout </a></font></h2>
                </td>
            </tr>
        </table>
        <br>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            attachment : <input type="file" name="attachment"/>
            <br><br>
            description : <input type="text" name="description"/>
            <br><br>
            <input type="submit" value="Upload"/>
        </form>
        <br><br><br>
        <%
            List<Content> ownContent = (List<Content>) request.getSession().getAttribute("ownContent");
            if (ownContent == null || ownContent.size() == 0) {
            } else {
                for (Content c : ownContent) {
        %>

        <a href="DownloadServlet?contentId=<%=c.getContentId()%>">
            <font color="green">
            <%=c.getFileName()%> uploaded at <%=c.getUploadedTime()%>
            </font>
        </a>
        <br>
        <p>
            <font color="red">
            <%=c.getDescription()%>
            </font>
        </p>
        <br><br>
        <%
                }
            }
        %>
    </body>
</html>
