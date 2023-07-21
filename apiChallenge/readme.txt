Framework: Postman

Test Data: Data for Testing CSV file.

Notes:
Run the complete Banco Pichincha collection using the Data for Testing file (DDT).
Select the "persist responses for a session" option to be able to see the JSON body responses after the execution.
Values within double curly brackets are variables gotten from the CSV file.

Execution steps:

1. Data needed for the first request: an already created username and password 
2. Get request to https://petstore.swagger.io/v2/user/login?username={{login_user}}&password={{password}} to log into the system
3. Tests performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response
4. Data needed for second request: id, username, first name, last name, email, phone, user status
5. Post request to: https://petstore.swagger.io/v2/user to create a new user, with a JSON body holding all the data from the right before step
6. Test performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response
7. Data needed for the third request: username
8. Get request to https://petstore.swagger.io/v2/user/{{user_name}} to get the information of the just created user
9. Test performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response
10. Data needed for the fourth request: id, username, new first name, last name, new email, phone, user status
11. Put request to https://petstore.swagger.io/v2/user/{{user_name}} to update the information of the just created user
12. Test performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response
13. Data needed for the fifth request: username
14. Get request to https://petstore.swagger.io/v2/user/{{user_name}} to get the information of the just update user
15. Test performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response
16. Data needed for the sixth request: none
17. Get request to https://petstore.swagger.io/v2/user/logout
18. Test performed: validation of 200 HTTP response, response time below 600 ms, expected values for every property of the JSON body response





