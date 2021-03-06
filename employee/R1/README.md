# API CZAR generated server

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application  


### Running the Server
To build the api with maven, please execute the following:

```
mvn clean package
```

If you are using gradle, please execute the following:

```
gradle clean build
```

To host the api:

```
- Launch tomcat manager on your machine on http://localhost:8080
- Press on "Manager App" and enter your admin credentials
- In the "WAR file to deploy" section, choose the war file you created from the project
- Press on deploy
```

To query the api:

```
http://localhost:8080/[apiBasePath]/[resourceName]s
```

### Unit Testing

To run the unit tests:
```
mvn test
```

### Pact Testing

To create the pacts:
```
mvn clean package
```
or
```
gradle clean build
```

To verify the pacts against your api:

Run you api on tomcat server, then:
```
mvn pact:verify
```
or
```
gradle pactVerify
```

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties