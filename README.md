# Agile Project - Calculus Learning WebApp

## Intro
###Goals of the project
There are several goals to this project:
* Learning to work in an *Agile* environment with a team of students
* Using the *AngularJS*, *EE4J*, *MVC* and *Spring* technologies
* Getting a real experience of group work for a client

###Description of the WebApp
The app is an easy and fun way to learn calculus to young children, and it runs like a game:
* The player has 3 lives 
* There are several difficulty levels (ranging from easy sums to difficult divisions)
* A way to track progress and past *tests* can be found for any logged user

##Demo
The Angular and front end has been reused, mostly, from another GitHub project for which a live demo can be found [here](http://sumitgouthaman.github.io/MathTutor/).

The full working demo will be up on Heroku second trimester of 2018. 

## Dependencies
You have to make sure that the modules have the proper dependencies, listed bellow
### Module calcul_mental_core
For this module, in the `pom.xml` file, you must have, it's packaging should be war:

|groupId   |artifactId      |  version | scope|
|----------|-------------|------|---|
| ${project.groupId |  | ${project.version}||
| org.springframework | spring-webmvc | 4.2.9.RELEASE | 
| org.springframework | spring-context-support | 4.2.9.RELEASE || 
| ch.qos.logback | logback-classic | 1.1.8 | |
| javax.inject | javax.inject | 1 |
| javax.servlet | javax.servlet-api | 3.1.0 | provided 

## DB 

## Deployment

## Logs