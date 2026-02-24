💰 Gestor de Datos Personales – Backend API

API REST desarrollada con Spring Boot para la gestión de gastos personales.
Permite crear, consultar, actualizar y eliminar gastos, además de filtrarlos por categoría, monto y fecha.

🚀 Tecnologías Utilizadas

☕ Java 17

🌱 Spring Boot

🗄️ Spring Data JPA

🐘 MySQL / PostgreSQL

📦 Maven

🔄 Arquitectura REST

🔐 Manejo global de excepciones

🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

Controller → Service → Repository → Database
com.example.gestor_datos_personales
│
├── controller
├── service
├── repository
├── model
│   ├── entity
│   └── enumerador
├── dto
└── exception
🌐 Base URL
http://localhost:8080/api/expenses
📌 Endpoints
🔍 Obtener todos los gastos
GET /api/expenses
🔎 Obtener gasto por ID
GET /api/expenses/{id}
➕ Crear nuevo gasto
POST /api/expenses
Body (JSON)
{
"description": "Supermercado",
"amount": 50000,
"date": "2026-02-20",
"category": "FOOD"
}

Respuesta: 201 CREATED

✏️ Actualizar gasto
PUT /api/expenses/{id}
❌ Eliminar gasto
DELETE /api/expenses/{id}
🏷️ Filtrar por categoría
GET /api/expenses/category/{category}

Ejemplo:

GET /api/expenses/category/FOOD
💰 Filtrar por monto
GET /api/expenses/amount/{amount}
📅 Filtrar por fecha
GET /api/expenses/date/{date}

Formato:

YYYY-MM-DD
🧠 Modelo de Datos
📌 Expense
Campo	Tipo	Descripción
id	Long	Identificador único
description	String	Descripción del gasto
amount	BigDecimal	Valor del gasto
date	LocalDate	Fecha del gasto
category	CategoryEnum	Categoría del gasto
🛡️ Manejo de Errores

Se implementa un @RestControllerAdvice global para manejar excepciones y devolver respuestas HTTP adecuadas.

Ejemplo:

404 NOT FOUND → Cuando el recurso no existe

400 BAD REQUEST → Cuando el body es inválido

🔄 Configuración CORS

Permite conexión con frontend Angular:

http://localhost:4200
⚙️ Configuración del Proyecto
1️⃣ Clonar el repositorio
git clone https://github.com/tu-usuario/gestor-datos-personales.git
2️⃣ Configurar base de datos

En application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/gestor_db
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Ejecutar el proyecto
mvn spring-boot:run

Servidor disponible en:

http://localhost:8080
🧪 Pruebas

Puedes probar los endpoints con:

Postman

Thunder Client (VS Code)

Curl

Ejemplo:

curl -X GET http://localhost:8080/api/expenses
🔮 Mejoras Futuras

🔐 Autenticación con JWT

📄 Documentación con Swagger/OpenAPI

📊 Paginación y ordenamiento

🧪 Tests unitarios (JUnit + Mockito)

🐳 Dockerización

🔍 Filtros dinámicos con Specification API

📈 Dashboard con estadísticas

👨‍💻 Autor

Steven Urieles Rangel
Desarrollador Full Stack en formación 🚀