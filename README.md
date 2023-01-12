# Email Backend

Payments backend microservice stores data about all payments and creates payment requests in external source (Stripe).

## Production version

BaseUrl: http://34.168.23.255:8100/

Swagger: http://34.168.23.255:8100/swagger-ui/index.html

## DockerHub

[https://hub.docker.com/r/bizjak3/email_backend](https://hub.docker.com/r/bizjak3/email_backend)

## Running DEV server
1. Compile `mvn package`
2. Run fatjar `java -jar ./api/target/api-0.0.1-SNAPSHOT.jar`
