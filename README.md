# SFG117V
## SFG Assignment 2


This project topic idea is solely created to streamline the monitoring and tracking of everyday activities. Considering our daily schedules, it becomes impossible to keep a track of our daily appointments, events, meetings. To handle this issue, this project concentrates on creating a Weekly Task Alerting System for devices that can remind users of all the tasks and appointments that are scheduled for the day. The project is essentially a reminder app backed by an AI chatbot that alerts users of all the daily tasks


### SERVER REQUIREMENTS

**URL Download** https://github.com/wildfly/wildfly/releases/download/31.0.1.Final/wildfly-31.0.1.Final.zip


- All you need to build this project is Java 11.0 (Java SDK 11) or later and Maven 3.6.0 or later.


### Configs to get up and running

1. Update mysql datasource URL, username and password on `applications.properties` file 
2. Start mysql server
3. Build WAR file - `mvn clean package -Dmaven.test.skip=true`
4. Copy war file to `wildfly/standalone/deployments/`
5. Run server `./Standalone.sh`

### Testing Endpoints

- This is our basic health check - `http://localhost:8080/TaskService/task/v1/health-check`
- To create a task in mysql db - `http://localhost:8080/TaskService/task/v1/create/task`

**Request**
`{
    "taskName": "Postkid",
    "taskStartDate": "2024-04-10T08:45:00.000+02:00",
    "taskEndDate" : "2024-04-10T09:45:00.000+02:00",
    "taskDescription": "Take a walk while playing",
    "taskStatus": 1
}`


**Response**

`{
    "taskID": 74,
    "taskName": "Postkid",
    "taskStartDate": "2024-04-10T06:45:00.000+00:00",
    "taskEndDate": "2024-04-10T07:45:00.000+00:00",
    "taskDescription": "Take a walk while playing",
    "taskStatus": true
}`
