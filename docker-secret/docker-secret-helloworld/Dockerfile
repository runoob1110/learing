FROM eclipse-temurin:11-jre

RUN ln -sf /usr/share/zoneinfo/{TZ} /etc/localtime && echo "{TZ}" > /etc/timezone

ADD docker-secret-helloworld.jar /app.jar
ENTRYPOINT ["java","-jar","./app.jar","--spring.profiles.active=docker"]