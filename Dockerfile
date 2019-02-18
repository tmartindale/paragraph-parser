FROM openjdk:8-jre-alpine

ADD paragraph-parser.tar /

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar","/paragraph-parser/lib/paragraph-parser.jar"]