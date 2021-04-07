# projectGlobal - project for rainfall measurement

This is java project for rainfall measurement.

## Instalation

For working in java, [jdk](https://www.oracle.com/java/technologies/javase-downloads.html) (Java Development Kit) is needed.
Also [java](https://www.java.com/download/ie_manual.jsp) itself.
This project is made in [Intellij IDE](https://www.jetbrains.com/idea/download/#section=windows) (community version is enough).
Local [mysql database](https://sourceforge.net/projects/wampserver/) (this database is for demonstration and test usage).

## Build

For better usage, Maven is used in this project. To run it, some dependencies are needed:
```maven
        <groupId>com.googlecode.json-simple</groupId>
        <artifactId>json-simple</artifactId>
        <version>1.1.1</version>
```
Or any json-working dependencies.

For running temporary server:
```maven
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-rest</artifactId>
        <version>2.4.3</version>
```
and
```maven
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot</artifactId>
        <version>2.4.3</version>
```

To connect to local mysql database:
```maven
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version>
```

## Usage

First of all, to run Spring server, you need to specify, which class will be running the server.

### Spring Boot server

To do so, add annotation before any class to make it SpringBoot application.
```java 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
```

To work with server, controller class is needed. If controller is in other package, path specification is needed in boot application.
```java
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "path")
@SpringBootApplication
public class App {
```

Now when everything is set, server can be started using command *SpringApplication.run(App.class, args)*.
To explain: SpringApplication.run needs class type as first argument, which is App (SpringBoot Application) and args.
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "path")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```
And now, server is running and you can start working.
(Also don't forget to import specified commands)

### MYSQL database

Before connecting to MYSQL database via java, be sure that you have running MYSQL database.
To do so, launch WAMP and click on MYSQL console. Type your user and password (root user is default) and you can start creating your own database.

```MYSQL
CREATE DATABASE name;
```

To work with specified database, you need to "connect" to it using:

```MYSQL
USE name;
```

Now you are in your database and you can start creating your own tables.

```MYSQL
CREATE TABLE name(...);
```

### Use
Now when everything is set, SpringBoot server and MYSQL database, using your default browser or apps like [Postman](https://www.postman.com/downloads/) you can test this project.

#### Postman
To get specified result, check what path you need in java:
```java
@GetMapping("/path/to")
```

*GetMapping* means, that it will give result. To get this result, in Postman, connect to :
*localhost:8080/path/to*

Also when in default browser, just type: *http://localhost:8080/path/to*

*localhost:8080* is port for SpringBoot server. If taken by other service, change port in java application.
