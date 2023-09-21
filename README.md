# Pizzeberus

![image text](https://github.com/Serri23/Pizzeberus/blob/develop/assets/arquitectura-pizzeberus.png)

# Guía de Uso
1. ``git clone https://github.com/Serri23/Pizzeberus.git``
2. ``mvn clean install`` para instalar las dependencias del proyecto.
3. ``docker-compose up`` para levantar Rabbitmq,Zipkin,Postgres y PgAdmin.
4. Arrancar desde el IDE el servicio Config Server.
5. Arrancar desde el IDE el servicio Eureka Server.
6. Arrancar desde el IDE el servicio Gateway Server.
7. Arrancar desde el IDE los servicios pizza-write,pizza-read,user-crud.

# Documentación
- Config server: http://localhost:8888/<nombre_servicio>/default
- Eureka server: http://localhost:8761/
- Gateway: http://localhost:9000/
- user-crud: http://localhost:8080/swagger-ui.html
- pizza-read: http://localhost:8081/swagger-ui.html
- pizza-write: http://localhost:8082/swagger-ui.html
- pg-admin: http://localhost:80
- Zipkin: http://localhost:9411
- Rabbitmq: http://localhost:15672/
 
# Autor
Álvaro Serrano Andrés

