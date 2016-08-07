<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Note System</title>

    


<frameset rows="80,*" id="allFrameset" border=0 frameSpacing=0 frameBorder=no >
  <frame src="/note/head" />
	<frameset cols="350,*"  id="mainArea" border=0 frameSpacing=0 frameBorder=no>
		<frame src="/note/menu" name="leftFrame" scrolling="no">
		<frame src="/note/allNote" name="showframe" />
	</frameset> 	

</frameset>

<noframes>
<body>
<p>This page uses frames, but your browser doesn't support them.</p>
</body>
</noframes>

