<html>
<body>

<h3>Spring REST API Health Calendar</h3>
<hr>

<a href=${pageContext.request.contextPath}"/test/hello">Hello </a>

<hr>
<a href=${pageContext.request.contextPath}"/body/id/1">Get record from Body Size where id=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byLastDate/2">Get last date measure from Body Size where user id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byUserIdAllDate/3">Get all date from Body Size by user ide </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byDateAndUserId/2018-06-13/9">Get record from Body Size by date and user id </a>
<br>
<a href=${pageContext.request.contextPath}"/body/getAll">Get all record from Body Size </a>
<br>
<a href=${pageContext.request.contextPath}"/body/addBody">Add body size, method POST </a>
<br>
{
"bodyWeight": 12,
"neckSize": 22,
"armSize": 32,
"bustSize": 42,
"waist": 52,
"femoralSize": 72,
"calf": 82,
"date": [
2018,
5,
3
],
"userId": 2,
"hipSize": 62
}
<br>
Brak update, żeby nikt nie oszukiwał. Można tylko usunąc lub dodać
<br>
<a href=${pageContext.request.contextPath}"/body/delete/3">Delete record where id=3 from Body size method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/user/id/2">Get record from User where id=2 </a>

<hr>
<a href=${pageContext.request.contextPath}"/day/listDays">List days </a>

<hr>
//MySql see date 1 day earlier
<a href=${pageContext.request.contextPath}"/day/dateAndUser/1/2018-05-24">Request GET Day by userId and date </a>
<hr>

//MySql see date 1 day earlier
<a href=${pageContext.request.contextPath}"/body/dateAndUser/1/2018-05-22">Request GET BodySize by userId and date </a>
<hr>

<h2>
    Test m
</h2>

</body>
</html>