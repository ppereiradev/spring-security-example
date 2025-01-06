FROM ubuntu:24.04
LABEL maintainer="paulopereira.dev"

EXPOSE 8080

RUN mkdir -p /home/springsecurityexample

COPY ./springsecurityexample /home/springsecurityexample

RUN apt-get update \
    && apt-get install -y wget openjdk-21-jdk

RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz \
    && tar xf apache-maven-3.9.9-bin.tar.gz -C /opt \
    && rm apache-maven-3.9.9-bin.tar.gz

ENV M3_HOME=/opt/apache-maven-3.9.9
ENV MAVEN_HOME=/opt/apache-maven-3.9.9
ENV PATH=$M3_HOME/bin:$PATH

WORKDIR /home/springsecurityexample

ENTRYPOINT ["tail"]
CMD ["-f","/dev/null"]
