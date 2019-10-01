<html>
<body>

<h3>Spring CRM REST Demo</h3>
<hr>

<a href=${pageContext.request.contextPath}"/test/hello">Hello </a>
<hr>

<a href=${pageContext.request.contextPath}"/user/listUsers">The list of users </a>
<hr>

<a href=${pageContext.request.contextPath}"/day/listDays">List days </a>
<hr>

//MySql see date 1 day earlier
<a href=${pageContext.request.contextPath}"/day/dateAndUser/1/2018-05-24">Request GET Day by userId and date </a>
<hr>

<h2>
    Test p
</h2>

</body>
</html>