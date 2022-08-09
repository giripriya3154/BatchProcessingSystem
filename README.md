#Batch-Pprocessing application

#Step to run application

1. Open terminal at batch-processing directory
2. Write command in terminal "docker-compose up"
3. post request in postman with "http://localhost:8086/authenticate" with username and password
    #For ADMIN role
   {
   "username":"Prabhat",
   "password":"Gyawali"
   }
   
   #for USER role 
   {
   "username":"Tirtha",
   "password":"Khanal"
   }
     #this request generate token if the username and password is valid if not it will not create token
4. Again post request in postman with "http://localhost:8086/jobs/students/import"
   to load data from csv file into the database(Note:only with token of admin role can load data)
5. To check whether data from csv file load into database get request with
   "http://localhost:8086/students". (NOTE: token of both user and admin role can see a list of data from database )
