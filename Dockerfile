FROM java:8
ADD target/converter-spring-boot.jar converter-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "converter-spring-boot.jar"]