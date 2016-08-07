<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<%-- 
    Document   : allNote
    Created on : 2016-1-26, 17:26:24
    Author     : WeiliangOuyang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
    
     
body
{
font:italic arial,sans-serif; 
    margin: 0;
  
}

a:link {
text-decoration: none;
    color: #108AC6;
}
a:visited {
text-decoration: none;
color: #108AC6;
}
a:hover {
text-decoration: none;
color: #108AC6;
}
a:active {
text-decoration: none;
color: #108AC6;
}
</style>
<BODY style="padding-top:15px;padding-left:10px;padding-right:10px;" bottomMargin=0 leftMargin=0 topMargin=0 rightMargin=0 marginwidth=0>
    <table>
<c:forEach var="allNote" items="${allNotes}">
	<tr>
		<td width="200">${allNote.title}</td>
                <td width="150">${allNote.reminderTime}</td>
		<td><a href="/note/viewNote/${allNote.id}" target ="showframe">view</a></td>
		<td><a href="/note/noteUpdate/${allNote.id}" target ="showframe">edit</a></td>
                <!--
                  <td><a href="books/delete/${noteClass.id}">delete</a></td>
                -->
             
	</tr>
	</c:forEach>
        </table>
    </body>
</html>
