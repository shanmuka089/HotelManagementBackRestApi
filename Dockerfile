FROM openjdk:17

LABEL maintainer="Shanmukha <shanmuka089@gmail.com>"

COPY target/HotelManagementApplicationBack-0.0.1-SNAPSHOT.jar  /usr/app/HotelManagementApplicationBack.jar

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", HotelManagementApplicationBack.jar]