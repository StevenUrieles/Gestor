<div>
  <img style="100%" src="https://capsule-render.vercel.app/api?type=waving&height=100&section=header&reversal=false&fontSize=70&fontColor=FFFFFF&fontAlign=50&fontAlignY=50&stroke=-&descSize=20&descAlign=50&descAlignY=50&theme=cobalt"  />
</div>

###

<h1 align="center">💰 Gestor de Datos Personales – Backend API</h1>

###

<h3 align="left">API REST desarrollada con Spring Boot para la gestión de gastos personales.<br>Permite crear, consultar, actualizar y eliminar gastos, además de filtrarlos por categoría, monto y fecha.</h3>

###

<p align="left">🚀 Tecnologías Utilizadas<br><br>☕ Java 17<br>🌱 Spring Boot<br>🗄️ Spring Data JPA<br>🐘 MySQL / PostgreSQL<br>📦 Maven<br>🔄 Arquitectura REST<br>🔐 Manejo global de excepciones<br>🏗️ Arquitectura</p>

###

<h3 align="left">🔥 El proyecto sigue una arquitectura en capas:</h3>

###

<p align="left">Controller → Service → Repository → Database<br>com.example.gestor_datos_personales<br>│<br>├── controller<br>├── service<br>├── repository<br>├── model<br>│   ├── entity<br>│   └── enumerador<br>├── dto<br>└── exception</p>

###

<p align="left">🌐 Base URL<br>http://localhost:8080/api/expenses<br>📌 Endpoints<br>🔍 Obtener todos los gastos<br>GET /api/expenses<br>🔎 Obtener gasto por ID<br>GET /api/expenses/{id}<br>➕ Crear nuevo gasto<br>POST /api/expenses</p>

###

<p align="left">Body (JSON)<br>{<br>"description": "Supermercado",<br>"amount": 50000,<br>"date": "2026-02-20",<br>"category": "FOOD"<br>}<br><br>Respuesta: 201 CREATED</p>

###

<p align="left">✏️ Actualizar gasto<br>PUT /api/expenses/{id}<br>❌ Eliminar gasto<br>DELETE /api/expenses/{id}<br>🏷️ Filtrar por categoría<br>GET /api/expenses/category/{category}<br><br>Ejemplo:<br><br>GET /api/expenses/category/FOOD<br>💰 Filtrar por monto<br>GET /api/expenses/amount/{amount}<br>📅 Filtrar por fecha<br>GET /api/expenses/date/{date}<br><br>Formato:<br><br>YYYY-MM-DD<br>🧠 Modelo de Datos<br>📌 Expense<br>Campo	Tipo	Descripción<br>id	Long	Identificador único<br>description	String	Descripción del gasto<br>amount	BigDecimal	Valor del gasto<br>date	LocalDate	Fecha del gasto<br>category	CategoryEnum	Categoría del gasto<br>🛡️ Manejo de Errores<br><br>Se implementa un @RestControllerAdvice global para manejar excepciones y devolver respuestas HTTP adecuadas.<br><br>Ejemplo:<br><br>404 NOT FOUND → Cuando el recurso no existe<br><br>400 BAD REQUEST → Cuando el body es inválido<br><br>🔄 Configuración CORS<br><br>Permite conexión con frontend Angular:<br><br>http://localhost:4200<br>⚙️ Configuración del Proyecto<br>1️⃣ Clonar el repositorio<br>git clone https://github.com/tu-usuario/gestor-datos-personales.git<br>2️⃣ Configurar base de datos<br><br>En application.properties:<br><br>spring.datasource.url=jdbc:mysql://localhost:3306/gestor_db<br>spring.datasource.username=root<br>spring.datasource.password=tu_password<br><br>spring.jpa.hibernate.ddl-auto=update<br>spring.jpa.show-sql=true<br>3️⃣ Ejecutar el proyecto<br>mvn spring-boot:run<br><br>Servidor disponible en:<br><br>http://localhost:8080<br>🧪 Pruebas<br><br>Puedes probar los endpoints con:<br><br>Postman<br><br>Thunder Client (VS Code)<br><br>Curl<br><br>Ejemplo:<br><br>curl -X GET http://localhost:8080/api/expenses<br>🔮 Mejoras Futuras<br><br>🔐 Autenticación con JWT<br><br>📄 Documentación con Swagger/OpenAPI<br><br>📊 Paginación y ordenamiento<br><br>🧪 Tests unitarios (JUnit + Mockito)<br><br>🐳 Dockerización<br><br>🔍 Filtros dinámicos con Specification API<br><br>📈 Dashboard con estadísticas</p>

###

<img src="https://raw.githubusercontent.com/StevenUrieles/StevenUrieles/output/snake.svg" alt="Snake animation" />

###
