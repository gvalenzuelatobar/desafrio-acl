# Desafio

Repositorio para obtener el proyecto
https://github.com/gvalenzuelatobar/desafrio-acl.git

En el Archivo application.properties, se encuentra la configuracion de Swagger y la BD H2
En el Archivo schema.sql, se encuentra el script de la creacion de la BD

url swagger , documentacion de los controladores
http://localhost:8080/swagger/swagger-ui/index.html

JDBC 
dbc:h2:mem:test

Credenciales 
username: sa
password: 

url BD H2
http://localhost:8080/h2-console

tablas ocupadas
select * from tabla;



Segun el menseaje, se analizo que a la tabla  de entrada se le asigna un los siguientes valores 

Pruebas con Postman

- Para el ingreso del mensaje
POST

SI el ID NO existe en la BD, se crea en la BD
http://localhost:8080/tabla/ingreso

{
    "id": 20,
    "descripcion": "registro iniciado  ",
    "fechaCreacion": "2024-12-12",
    "vigente": true
}

SI el ID  existe en la BD, se actualizan los valor

{
    "id": 25,
    "descripcion": "registro actualizado ",
    "fechaCreacion": "2000-10-10",
    "vigente": false
    
}

- Para obtener todos los valores BD
GET
http://localhost:8080/tabla/todos




