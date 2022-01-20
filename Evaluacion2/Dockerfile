FROM gradle:6.9.2-jdk11

COPY . .


RUN 'chmod +x ./gradlew'
RUN "./gradlew build"
# copy project files and folders to the current working directory (i.e. 'app' folder)
COPY . .

EXPOSE 3000
CMD ["gradlew", "bootrun"]

#CMD ["http-server", "dist" ]

