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
<a href=${pageContext.request.contextPath}"/body/byUserIdAllDate/3">Get all dates from Body Size by user ide </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byDateAndUserId/2018-06-23/2">Get record from Body Size by date and user id </a>
<br>
<a href=${pageContext.request.contextPath}"/body/getAll">Get all records from Body Size </a>
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
<a href=${pageContext.request.contextPath}"/user/getAll">Get all records from User (main info) </a>
<br>
<a href=${pageContext.request.contextPath}"/user/userDB/id/1">Get record from User (all info) where id=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getAllUsersInf">Get all records from User (all information) </a>
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
<a href=${pageContext.request.contextPath}"/limit/id/2">Get record from Daily limit where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/byUserId/1">Get record from Daily limit where userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/getAll">Get all records from Daily limit </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/add">Add Daily limits, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/update">Update record from Daily limits method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/limit/delete/4">Delete record where id=4 from Daily limits method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/meal/id/2">Get record from Meal where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/byDateAndDayId/2018-09-25/2">
    Get all records from Meal where date=2018-09-25 and dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/getAll">Get all records from Meal </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/add">Add Meal, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/update">Update record from Meal method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/meal/delete/4">Delete record where id=4 from Meal method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/day/id/2">Get record from Day where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getDayByDateAndUserId/2018-05-24/1/2">
    Get record from Day where date=2018-05-24, userId=1 and dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getDayDBbyDateAndUserId/2018-05-24/1">
    Get record from Day database where date=2018-05-24 and userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getAll">Get all records from DayDB </a>
<br>
<a href=${pageContext.request.contextPath}"/day/add">Add Day, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/day/update">Update record from Day method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/day/delete/4">Delete record where id=4 from Day method DELETE</a>
<br>




<hr>



<h2>
    Test m
</h2>

</body>
</html>