# CSE360

[![Build Status](https://travis-ci.org/daniel-dsouza/CSE360.svg?branch=master)](https://travis-ci.org/daniel-dsouza/CSE360)

all code will be hosted here.

## Files in this project
Explanation of folders in this directory.

app             - contains Models, Views, and Controllers for the interface of the webapp  
core            - contains program logic, as well as the MySQL database interface.  
gradle/wrapper  - contains resources for the build script needed for Travis CI  
.travis.yml     - Travis CI script  
build.gradle    - Universal build script, builds both app and core modules  
gradlew         - compiled build script needed for travis CI  
gradlew.bat     - not sure if needed...  
settings.gradle - project information.  

## How to run this project
In a terminal session enter:
```
git clone https://github.com/daniel-dsouza/CSE360.git
```
Next, you need to initialize Gradle by running the script in the project directory.
```
./gradlew
```
Now you can build the project using:
```
./gradlew clean build
```
The executable will be zipped into app/build/libs/ and you can run it with.
```
java -jar app/build/libs/teamone-spring-boot-0.1.0.war
```
Navigate to http://localhost:8080/ to see the webapp!

