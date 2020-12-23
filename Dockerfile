FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
WORKDIR /usr/share/selenium-docker
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD book-flight.xml book-flight.xml
ADD search-module.xml search-module.xml

ADD healthcheck.sh healthcheck.sh
ENTRYPOINT sh healthcheck.sh

