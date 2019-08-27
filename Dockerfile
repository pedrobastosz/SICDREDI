FROM openjdk:8-jdk
RUN apt-get update && \
    apt-get install dos2unix && \
    apt-get clean
ADD target/ms-votacao-*.war application.war
COPY wait-for-it.sh /wait-for-it.sh
RUN dos2unix /wait-for-it.sh
RUN chmod +x /wait-for-it.sh