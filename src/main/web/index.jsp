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
<a href=${pageContext.request.contextPath}"/user/id/2">Get record from User (main info) where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getAllUsers">Get all record from User (main info) </a>
<br>
<a href=${pageContext.request.contextPath}"/user/userAllInf/id/2">Get record from User (all info) where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getAllUsersInf">Get all record from User (all information) </a>
<br>
<a href=${pageContext.request.contextPath}"/user/addUser">Add user, method POST </a>
<br>
{
"firstName": "Fiona1",
"nick": "shrek1231",
"email": "fiona1@gmail.com",
"poneNumber": 846152111,
"loginName": "Shrek1",
"password": "test21",
"sex": 1,
"dailyWaterDemand": 3201,
"dailyKcalDemand": 2801
}
<br>
<a href=${pageContext.request.contextPath}"/user/update">Update record from User method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/user/delete/4">Delete record where id=4 from User method DELETE</a>
<br>


<hr>


<br>
<br>
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