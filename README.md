# Proyecto de Gestión de Portafolio 📁

Este repositorio contiene un proyecto complementario para obtener información de una base de datos de proyectos. Proporciona una API pública para acceder a los datos almacenados en la base de datos.

## Tecnologías Utilizadas 🛠️

- Spring Framework: Para la creación de la aplicación web y la gestión de los controladores REST.
- Lombok: Para la reducción de código boilerplate en las clases Java.
- JDBC: Para la persistencia de datos en una base de datos MySQL sin utilizar un ORM.
- MySQL: Como sistema de gestión de base de datos relacional.

## Consideraciones 
Al utilizar jdbc, deberas tener la base de datos creada junto a las tablas correspondientes.
Aun falta las imagenes, estoy en busca de un blob storage gratuito...

![image](https://github.com/CarlosCommit/BackGetProjects/assets/103321225/9cb4c6d5-0392-40a5-840c-fb4070a510af)



## Configuración 🔧

1. Clona este repositorio en tu máquina local.
2. Crea una base de datos MySQL llamada `portfolio`.
3. Ejecuta el script `database.sql` ubicado en la carpeta `src/main/resources` para crear las tablas necesarias en la base de datos.
4. Actualiza las credenciales de acceso a la base de datos en el archivo `application.properties` ubicado en la carpeta `src/main/resources`.

## Ejecución ▶️

1. Abre una terminal en el directorio raíz del proyecto.
2. Ejecuta el comando `mvn spring-boot:run` para compilar y ejecutar la aplicación.

## Uso 🚀

Una vez que la aplicación esté en funcionamiento, puedes acceder a la API pública para obtener información sobre los proyectos. Aquí hay un ejemplo de cómo hacerlo utilizando cURL:

```bash
curl http://localhost:8080/proyectos
