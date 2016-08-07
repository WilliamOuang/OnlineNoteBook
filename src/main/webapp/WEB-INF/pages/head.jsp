<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<BODY style="background-color:#108AC6;color: white;" bottomMargin=0 leftMargin=0 topMargin=0 rightMargin=0 marginwidth=0 style="font-size:14px; font-family:宋体;background:url(images/bg1.png) repeat-x "  >
<div height=50px; style="float:left;font-size:24px;text-align:right;padding-top:10px; padding-left:10px;">
OnLine Note System
</div>
<div height=50px; style="float:right;text-align:right;padding-bottom: 20px;padding-top:25px;padding-right:25px;">
<span>
    <sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			
		</c:if>


	</sec:authorize>
   

</div>
</BODY>
