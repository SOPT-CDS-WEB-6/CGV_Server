FROM openjdk:11
ARG JAR_FILE=./build/libs/cgv-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} cgv.jar
ENTRYPOINT ["java","-jar","cgv.jar"]