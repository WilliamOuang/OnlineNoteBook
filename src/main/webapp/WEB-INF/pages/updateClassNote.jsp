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
        <title>JSP Page</title>
    </head>
    <body>
<form action="../noteClassUpdate2/${noteClass.id}/" method="post">
	<table>
		<tr>
			<td>Class Name</td>
			<td><input type="text" name="className" value="${noteClass.className}" /> </td>
		</tr>
		<tr>
			<td>Note Type</td>
			<td><input type="text" name="noteType" value="${noteClass.noteType}" /> </td>
		</tr>
		
	</table>
	<input type="submit" value="Update"/>
	</form>
    </body>
</html>
