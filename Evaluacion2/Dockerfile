FROM gradle:6.9.2-jdk11
COPY . .
RUN gradle build
COPY . .
RUN chmod +x docker-entrypoint.sh
EXPOSE 3000
CMD ["sh", "docker-entrypoint.sh"]



