<%-- 
    Document   : addClassNote
    Created on : 2016-1-26, 18:40:07
    Author     : WeiliangOuyang
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <sec:csrfMetaTags/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
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
    </head>
    <body style="padding-top:15px;padding-left:10px;padding-right:10px;">
    
	<table>
		<tr>
			<td>Title: </td>
			<td>${noteview.title} </td>
		</tr>
		<tr>
			<td>Content: </td>
			<td>
                        ${noteview.content}
                        </td>
		</tr>
		<tr>
			<td>Reminder Time: </td>
			<td>${noteview.reminderTime}</td>
		</tr>
                
            
	</table>
	
    </body>
</html>
