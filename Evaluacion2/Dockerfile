FROM openjdk:15.0.1-oracle

COPY /build/libs/Evaluacion2-0.0.1-SNAPSHOT.jar Evaluacion2-0.0.1-SNAPSHOT.jar

COPY docker-entrypoint.sh /

RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["bash", "docker-entrypoint.sh"]

EXPOSE 3000
