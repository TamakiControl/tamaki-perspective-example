# Setup
This project was bootstrapped with maven using the following command.

```
mvn archetype:generate \
-DarchetypeGroupId=com.inductiveautomation.ignitionsdk \
-DarchetypeArtifactId=perspective-component-archetype \
-DarchetypeVersion=1.3.0-SNAPSHOT
```

# Requirements to Run

## Development Requirements

This project will only require jdk 11 and docker to run (and docker is optional but makes life much easier).
* Java 11
* Docker

**Linux**

    apt install docker openjdk-11-jdk

**Windows**

    choco install docker docker-compose openjdk-11

**OSX**

    brew install docker openjdk11

# To Run
This module is setup with docker and maven so that it's very easy to transport between machines. Docker will generate a running Ignition/SQL database, and maven will compile and install the module for you.

## To Build a Test Ignition Server

    docker-compose up -d

## To Compile/Install the Module

    ./mvnw install

### Docker Debugging
If the docker container does not work right away, make sure you have done these steps:
- Make sure you are not running a localhost Ignition server
- Run docker as administrator if you get an error starting ports like 'An attempt was made to access a socket in a way forbidden by its access permissions.'

