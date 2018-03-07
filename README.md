# Agile Project - Calculus Learning WebApp

## Intro
###Goals of the project
There are several goals to this project:
* Learning to work in an Agile environment with a team of students
* Using the AngularJS, EE4J, MVC and Spring technologies
* Getting an real experience of group work

###Description of the WebApp
The app is an easy and fun way to learn calculus to young children, and it runs like a game:
* The player has 3 lives 
* 

## DB 
* Reuse the schema named `yncrea_pw03`
* We assume that your DB credentials are `root:root`

## pw04-web
### Dependencies
Create a new Maven module called **pw04-web**. Its packaging is `war`

For this module, you have to declare, in the `pom.xml` file, the following dependencies.

|groupId   |artifactId      |  version | scope|
|----------|-------------|------|---|
| ${project.groupId | pw04-core | ${project.version}||
| org.springframework | spring-webmvc | 4.2.9.RELEASE | 
| org.springframework | spring-context-support | 4.2.9.RELEASE || 
| org.apache.velocity| velocity | 1.7 | |
| org.webjars | bootstrap | 3.3.7-1 | |
| ch.qos.logback | logback-classic | 1.1.8 | |
| javax.inject | javax.inject | 1 |
| javax.servlet | javax.servlet-api | 3.1.0 | provided 

For this module, we won't write any `web.xml`  file, because everything will be configured with Java

### Initializer
In the `yncrea.pw04.web` package, create a class named `Initializer` which extends `AbstractAnnotationConfigDispatcherServletInitializer` (_hey, that's what I call an accurate name!_)

3 methods to implement:
- `getRootConfigClasses()` which returns an array filled with `AppConfig` and `DBConfig`, theses classes are provided by the core module.
- `getServletConfigClasses()` which returns an array filled with `WebConfig`, a class you will write later.
- `getServletMappings()` which returns a String array with the following entry : `"/"`

If you wonder how to create arrays in Java, check this out : http://mathbits.com/MathBits/Java/arrays/Initialize.htm

### WebConfig
In the `yncrea.pw04.web.config` package, create the `WebConfig` class which extends `WebMvcConfigurerAdapter`.
- Annotate this class with `@EnableWebMVC` in order to start Spring WebMVC.
- Annotate this class with `@Configuration`
- Annotate this class with `@ComponentScan` and configure this annotation to tell Spring to check the `yncrea.pw04.web.controller` package.
- Override the `addResourceHandlers` with the following code : `registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");`
- Declare a bean of type `VelocityConfigurer`
  - `"/WEB-INF/velocity"` is the path you should pass to the `ResourceLoaderPath` method of that bean.
- Declare a bean of type `VelocityViewResolver`
  - `".vm"` is the suffix configured in that bean (check the available methods of that bean)
  
### StudentController
In the `yncrea.pw04.web.controller` package, create the `StudentController` class.
- Annotate this class with `@Controller`
- Inject the `StudentService`
- Create a method `getListOfStudents`
  - it takes a parameter of type `ModelMap`
  - it returns a String
  - its implementation is quite simple, it loads all the students from the DB with `findAllWithCourses` method from the service, puts it in the modelMap with the key `students` then returns `"studentsList"` (it will load the provided template in `src/main/webapp/WEB-INF/velocity/studentsList.vm`)
  - annotate this method with `@RequestMapping` with the path `/list`
  
Check the provided files in the `resources` directory of that practice. Copy the files where they should be ;)

## Deployment
Deploy your app in a Tomcat then test your page!

## Let's continue
### StudentController

Create a `getForm` method which returns a `String` and takes a `ModelMap` parameter
- create a new instance of `Student` then stores it in the map.
- return `"studentForm"`
- add the correct annotation in order to map this method to the `/form` URL.

Create a `submitForm` method
- it returns a `String`
- it takes a `Student` parameter, annotated with `@ModelAttribute("student")`
- it saves the student in the DB
- it returns `"redirect:list` (remember the "redirect after submit" pattern?)
- annotate this method with `@RequestMapping` with the `/form` path and the `POST` HTTP method.

## Deployment
Deploy your app in a Tomcat then test your form.

## Let's continue
### StudentController
Because you are a smart student, read the HTML template of the "trash" button then implement the deletion of a  student, followed by a refresh of the list.

## Logs
Inside the `src/main/resources` directory of the web module, paste the `logback.xml` file then check how the logs are formatted. Do not hesitate to play with this config to understand the concept of logging. You can also add some logging in your code.