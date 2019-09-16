
FROM openjdk:13-alpine
VOLUME /tmp
ENV TZ=Europe/Madrid
RUN ln -snf "/usr/share/zoneinfo/$TZ/" "etc/localtime" && echo "$TZ" > "/etc/timezone"
COPY tests-excel-0.0.1-SNAPSHOT.jar tests-excel.jar
EXPOSE 9094
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xmx128m","tests-excel.jar"]
