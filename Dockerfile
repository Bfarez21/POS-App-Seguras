# Usa una imagen base con Java
FROM openjdk:17-jdk-slim

# Crea un directorio en el contenedor
WORKDIR /app

# Copia el .jar compilado al contenedor
COPY target/POS-App-Seguras.jar app.jar

# Expone el puerto del Spring Boot (puedes cambiarlo si usas otro)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
