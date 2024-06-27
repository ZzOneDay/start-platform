FROM openjdk:24-oracle

WORKDIR /app

# Копируем JAR файл вашего приложения в контейнер и называем его app.jar
COPY build/libs/dmenu-admin-0.0.1-SNAPSHOT.jar app.jar

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "app.jar"]

#WORKDIR /app
#COPY --from=builder /build/build/libs ./
#CMD ["java", "-jar", "titan-backend-api.jar"]

# docker build -t dmenu-application .

# docker run -p 8080:8080 --name dmenu dmenu-application