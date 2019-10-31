<%--
  Created by IntelliJ IDEA.
  User: czar
  Date: 31/10/2019
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h3>Spring REST API Health Calendar</h3>
<hr>

<a href=${pageContext.request.contextPath}"/test/hello">Hello </a>

<hr>
<a href=${pageContext.request.contextPath}"/body/id/1">Get Body Size where id=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byLastDate/2">Get last date measure from Body Size DB where user id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byUserIdAllDate/3">Get all dates from Body Size DB by user ide </a>
<br>
<a href=${pageContext.request.contextPath}"/body/byDateAndUserId/2018-06-23/2">Get Body Size by date and user id </a>
<br>
<a href=${pageContext.request.contextPath}"/body/getAll">Get all records from Body Size DB</a>
<br>
<a href=${pageContext.request.contextPath}"/body/add">Add Body Size to database, method POST </a>
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
<a href=${pageContext.request.contextPath}"/body/delete/3">Delete record where id=3 from Body size DB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/user/getUserDTO/id/2">Get UserDTO (main info) where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getUsersDTO">Get all UsersDTO (main info) </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getUser/id/1">Get User (all info) where id=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/user/getUsers">Get all records Users (all info) </a>
<br>
<a href=${pageContext.request.contextPath}"/user/addUser">Add User to database, method POST </a>
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
<a href=${pageContext.request.contextPath}"/user/update">Update record UserDB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/user/delete/4">Delete record where id=4 from UserDB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/limit/id/2">Get Daily limit DB where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/byUserId/1">Get Daily limit DB where userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/getAll">Get all records Daily limit DB</a>
<br>
<a href=${pageContext.request.contextPath}"/limit/add">Add Daily limits DB to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/limit/update">Update record Daily limits DB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/limit/delete/4">Delete record where id=4 from Daily limits DB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/meal/id/2">Get MealDB where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/getDietDTOByDayId/2">
    Get daily Diet where dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/getAll">Get all records MealDB </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/add">Add MealDB to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/meal/update">Update record MealDB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/meal/delete/4">Delete record where id=4 from MealDB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/training/id/2">Get TrainingDB where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/training/getAllTrainingsDTOByDayId/2">
    Get all trainings by day from Training where dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/training/getAll">Get all records TrainingDB </a>
<br>
<a href=${pageContext.request.contextPath}"/training/add">Add TrainingDB to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/training/update">Update record TrainingDB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/training/delete/4">Delete record where id=4 from TrainingDB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/note/id/2">Get NoteDB where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/note/getHeadersByDayId/2">
    Get list Headers by day where dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/note/getNotesByDayId/2">
    Get list Nodes by day where dayId=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/note/getAll">Get all records NoteDB </a>
<br>
<a href=${pageContext.request.contextPath}"/note/add">Add NoteDB to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/note/update">Update record NoteDB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/note/delete/4">Delete record where id=4 from NoteDB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/day/id/2">Get DayDB where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getDayDTOByDateAndUserId/2018-05-24/1">
    Get Day (main info) where date=2018-05-24 and userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getDayId/2018-05-24/1">
    Get day id where date=2018-05-24 and userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getDayDBbyDateAndUserId/2018-05-24/1">
    Get DayDB (all info) where date=2018-05-24 and userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/day/getAll">Get all records DayDB </a>
<br>
<a href=${pageContext.request.contextPath}"/day/add">Add DayDB to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/day/update">Update record DayDB method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/day/delete/4">Delete record where id=4 from DayDB method DELETE</a>
<br>


<hr>
<a href=${pageContext.request.contextPath}"/shortDay/id/2">Get ShortDay where id=2 </a>
<br>
<a href=${pageContext.request.contextPath}"/shortDay/byDateAndUserId/2018-05-24/1">
    Get Short Days where date=2018-05-24 (30 day plus and 30 day minus) and userId=1 </a>
<br>
<a href=${pageContext.request.contextPath}"/shortDay/getAll">Get all records ShortDay </a>
<br>
<a href=${pageContext.request.contextPath}"/shortDay/add">Add ShortDay to database, method POST </a>
<br>
<a href=${pageContext.request.contextPath}"/shortDay/update">Update record ShortDay method PUT</a>
<br>
<a href=${pageContext.request.contextPath}"/shortDay/delete/4">Delete record where id=4 from ShortDay method DELETE</a>
<br>

<hr>

<h2>
    Test m
</h2>

</body>
</html>
