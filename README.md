# BankRESTFullAPI
Bank RESTfull web services developed using Spring MVC, Hibernate and JPA specification

This source code highlights the Java implimentation of the main operations/transactions carried out in a bank, as well as the web services that are necessary for the integration of a shopping cart functionality.

The app is developed using Spring MVC, RESTfull web services, Hibernate and JPA specification. It interacts with Mysql DBMS and is deployed on tomcat application server. All the configurations (Root application context, Dispatcher servlet application context and Servlet mapping for the DispatcherServlet) are java-based configuration (not xml configuration)

# How to test the API ?
To test the API, simply download the application and import it into eclipse. Then deploye it into tomcat application server. Create a databese with database name: bank1_db in Mysql DBMS. You gonna have to modify some informarmation (databaseUserName and databaseUserPassword) within the file ConnectMysqlDB.java, located in the package com.bank.constant, according to your Mysql installation, so as to facilitate the JDBC connexion. Finally, run the the API using a RESTful client like Postman or WizTools. I choose to use Postman.

Tables card and carditem before running the API

![post3](https://user-images.githubusercontent.com/1300982/49336561-80424780-f63f-11e8-8f77-0023ca9ea1b4.png)

The following screenshots are the results obtained for each request method:

http://localhost:8080/BankRESTFullAPI/rest/card with POST request method

![post4](https://user-images.githubusercontent.com/1300982/49336640-14f97500-f641-11e8-910a-be75004a3359.png)

This request produces the following result

![post7](https://user-images.githubusercontent.com/1300982/49336740-c9e06180-f642-11e8-8f75-4c4c3e56918d.png)

 http://localhost:8080/BankRESTFullAPI/rest/card/yZr5SZd7wax00PiE0SXxAkyFIMasVlSK with GET request method will produce the following result

![get1](https://user-images.githubusercontent.com/1300982/49336799-eaf58200-f643-11e8-9ef8-9df20c9c1373.png)

http://localhost:8080/BankRESTFullAPI/rest/card/8 with PUT request method. Let's modify the quantities of both items from 5 to 10 for the first one, and from 11 to 15 for the second, as shown in the following screenshot.

![put1](https://user-images.githubusercontent.com/1300982/49336930-02ce0580-f646-11e8-9fde-691376b605ce.png)

We get the following results in the database:

![put3](https://user-images.githubusercontent.com/1300982/49337018-28a7da00-f647-11e8-99dc-e987cc77e065.png)

Let's try to delete the cart we have been manipulating by applying the DELETE request method on the URI: http://localhost:8080/BankRESTFullAPI/rest/card/yZr5SZd7wax00PiE0SXxAkyFIMasVlSK as shown in the following screenshot

![delete1](https://user-images.githubusercontent.com/1300982/49337103-c51eac00-f648-11e8-8f07-358913f4fda4.png)

The cart with cart id: yZr5SZd7wax00PiE0SXxAkyFIMasVlSK is deteleted, as well as all its cart items, and we end up with the initial states of the tables card and carditem
