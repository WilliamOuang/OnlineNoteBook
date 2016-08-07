<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <style>
    
     
body
{
font:italic arial,sans-serif; 
    margin: 0;
  
}

a:link {
text-decoration: none;
color: white;
}
a:visited {
text-decoration: none;
color: white;
}
a:hover {
text-decoration: none;
color: white;
}
a:active {
text-decoration: none;
color: white;
}
</style>
<BODY style="background-color:#6960EC;padding-top:15px;padding-left:10px;padding-right:10px;" bottomMargin=0 leftMargin=0 topMargin=0 rightMargin=0 marginwidth=0>
<table>
    <sec:authorize access="hasRole('ROLE_USER')">
   <a href="/note/noteClass" target ="showframe">New NoteClass</a>
   </sec:authorize>
    <c:forEach var="noteClass" items="${noteClasss}">
	<tr>
		<td width="150">
                                       <a href="../note/allNoteByNoteClassId/${noteClass.id}" target ="showframe">

                                           ${noteClass.className} </a>
                </td>
		
		<td><a href="/note/noteClassUpdate/${noteClass.id}" target ="showframe">Edit</a></td>
                <!--
                <td><a href="noteClassDelete/${noteClass.id}" target ="showframe">Delete</a></td>
                -->
                
               
               <td><a href="note/${noteClass.id}" target ="showframe">Add Note</a></td>
               <td>
                   <a href="../note/allNoteByNoteClassId/${noteClass.id}" target ="showframe">
                       View Note</a></td>
	</tr>
	</c:forEach>
    
    </table>

 


</body>
</html>
