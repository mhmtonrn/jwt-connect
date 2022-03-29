# jwt-connect 

jwt-connect is a security app for your java web app

you should add your pom.xml or settings.xml this repository description

````
<repositories>
     <repository>
         <id>github</id>
         <name>GitHub mhmtonrn Apache Maven Packages</name>
         <url>https://maven.pkg.github.com/mhmtonrn/jwt-connect</url>
     </repository>
 </repositories>
````

also you should add dependency in your pom.xml

````xml
<dependency>
    <groupId>com.softengine</groupId>
    <artifactId>jwt-connect</artifactId>
    <version>${spring.app.version}</version>
</dependency>
````

if you want to use your database for your security app you can exculede **h2** database  from pom.xml

````xml
<dependency>
    <groupId>com.softengine</groupId>
    <artifactId>jwt-connect</artifactId>
    <version>${spring.app.version}</version>
    <exclusions>
        <exclusion>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </exclusion>
    </exclusions>
</dependency>
````