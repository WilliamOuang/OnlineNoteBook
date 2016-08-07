<%-- 
    Document   : addClassNote
    Created on : 2016-1-26, 18:40:07
    Author     : WeiliangOuyang
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  
  <script>
  $(function() {
    $( "#reminderTime" ).datepicker();
  });
  </script>
  <sec:csrfMetaTags/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       	<form action="../addnote/${noteClassid}" method="post">
	<table>
		<tr>
			<td>Title</td>
			<td><input type="text" name="title" value="" /> </td>
		</tr>
		<tr>
			<td>Content</td>
			<td>
                            <textarea name="Content" rows="10" cols="30">

</textarea>
                             </td>
		</tr>
		<tr>
			<td>Reminder Time</td>
			<td><input type="text" name="reminderTime" id="reminderTime" value="" /> </td>
		</tr>
                
            
	</table>
	<input type="submit" value="submit"/>
	</form>
    </body>
</html>
