# HealthCalendar

### Description
The application has been created for active people who want to easily manage and archive the results of their hard work.

Functionality is based on a calendar. Each user has a number of options for entering basic data per each day:
- the number of liquids drunk (in portions of 250ml)
- the number of meals eaten, along with their calorie content
- number of snacks / alcohol consumed (if any)
- performed trainings with the type, duration along with the amount of burned calories 
- additional notes, e.g. a holiday trip, sick leave etc.

Additionally, each user can check work progress by updating body measurement, i.e.:
weight, neck size, arm size, chest size, waist size, hip size, thigh size, calf size.
So it has the ability to compare the current results with the previous ones.

> Frontend is being created by a colleague, who has been working on it from the beginning of the project

For security reasons, the application requires authorization via token.

The application uses relational database MySQL, dependency diagram below.

(Table dependency diagram)


#### Creation purpose

The project has been created at the request of my fiancee and her active friends.
They will determinate how the application will look like in the future.

#### Usage

A Swagger UI is implemented in the project. It can be helpful in navigating the API.

Initially, you need to authenticate the received an access token.
You can do this by login at URL `**/login`. 

##### Specific day
To receive basic information about a specific day, send the request by using the GET method to URL 
`**/api/report/{date}/{userId}` (with a Bearer Token).
This endpoint returns the object report, which contains:
```
Long id;
LocalDate date;
Long userId;
int portionsDrink;
int portionsAlcohol;
int portionsSnack;
String nick;
String lastDateMeasureBody;
boolean isAchievedDrink;
boolean isAchievedKcal;
```

To receive other data from a specific day, send the request by using GET methods (with a Bearer Token) 
to following addresses:
- `**/api/meal/dto/date/user-id/{date}/{userId}` to get DailyDiet object
- `**/api/training/trainings-summary/{dayId}` to get TrainingsSummary object
- `**/api/note/day-id/{dayId}` to get List<Note> collection of Note object
- `**/api/short-report/{date}/{userId}` to get short report 30 days before and after 
the date entered.

It is possible to receive all information for a specific day, from the endpoint
`**/api/report/long/{date}/{userId}` GET method (with a Bearer Token).

##### Body measurement
To receive a body measurement result from a specific day send the request by using GET method to URL 
`**/api/body/{date}/{userId}` (with a Bearer Token) 

##### User
To receive information about user send the request by using GET method to URL 
`**/api/user/login-name/{loginName}` (with a Bearer Token)

## Applied technologies

Backend:
- Maven
- Spring Boot
- Spring Security
- JPA API
- REST API
- application container Tomcat
- Swagger UI (/HealthCalendar/swagger-ui.html)
- Lombok

## To do
- get/add certificate
- add validation input value/object
- add tests