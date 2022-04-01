Create

    Typ: POST
    Path: localhost:8080/student-management-system/api/v1/sms/
    Behöver en JSON body med email(som inte redan existerar i databasen), ett firstName och ett lastName.
    phoneNumber är upp till användaren om hen vill lägga till eller inte.
    Kastar en exception om användaren redan finns i databasen eller om inkorrekt data har matats in.
    exempel:
    {"firstName": "Börje",
    "lastName": "Björk",
    "email": "b@db.com",
    "phoneNumber": 123}

Get by mail:

    Typ: GET 
    Path: localhost:8080/student-management-system/api/v1/sms/STUDENTEMAILHÄR
    Kastar en exception om email adressen inte existerar i databasen.

Update:

    Typ: PUT
    Path:localhost:8080/student-management-system/api/v1/sms/
    Behöver en JSON body med email(tillhörande den användare som ska uppdateras), ett firstName och ett lastName.
    phoneNumber är upp till användaren om hen vill lägga till eller inte.
    Kastar en exception om inkorrekt data matats in eller om användaren inte existerar i databasen.
    exempel:
    {"firstName": "Börje",
    "lastName": "Björk",
    "email": "b@db.com",
    "phoneNumber": 123}

Delete:

    Typ: DELETE
    Path: Path: localhost:8080/student-management-system/api/v1/sms/STUDENTEMAILHÄR
    Kastar en exception om inte användaren finns i databasen
    
Get All:

    Typ: GET
    Path: localhost:8080/student-management-system/api/v1/sms/all

Get By Last Name:

    Typ: GET
    Path: localhost:8080/student-management-system/api/v1/sms/lastname
    Behöver en queryParam som heter lastName. Retunerar sedan alla studenter med det efternamnet.
    exempel: http://localhost:8080/student-management-system/api/v1/sms/lastname?lastName=Andersson

Problem:

    Hade en hel del problem med att skrubba datorn ren från en gammal h2db installering vilket skapade konflikter.
