# LearnFromHome
small prototype for a student management system for a teacher

# REST API
## Get lists
Retrieve a list of students   
```GET /api/students```   

Retrieve a list of teachers   
```GET /api/teachers```
## Get a single user
Retrieve a single student by id   
```GET /api/students/{id}```

Retrieve a single teacher by id   
```GET /api/teachers/{id}```
## Insert a new user
Insert a new student   
```POST /api/students```

Insert a new teacher   
```POST /api/teachers```
## Delete user
Delete a student by id   
```DELETE /api/students/{id}```

Delete a teacher by id   
```DELETE /api/teachers/{id}```
## Update user
Update student, need to provide id in JSON body   
```PUT /api/students```   

Update teacher, need to provide id in JSON body   
```PUT /api/teachers```

# Registration form
Added possibility to register students via /new/registration   
<p align="center">
  <img src="https://pix.my/o/xbkyQu?1613381665" width="300" height="400" align="left">
</p>



