FROM boxfuse/flyway:latest
RUN apt-get update && \
    apt-get install dos2unix && \
    apt-get clean
RUN mkdir /flyway/bin
ADD wait-for-it.sh /flyway/bin/wait-for-it.sh
RUN dos2unix /flyway/bin/wait-for-it.sh
RUN chmod +x /flyway/bin/wait-for-it.sh

ADD ./sql /flyway/sql	