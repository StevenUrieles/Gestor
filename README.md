<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&height=100&section=header&reversal=false&fontSize=70&fontColor=FFFFFF&fontAlign=50&fontAlignY=50&stroke=-&descSize=20&descAlign=50&descAlignY=50&theme=cobalt" width="100%" />
</div>

<h1 align="center">💰 Gestor de Datos Personales – Backend API</h1>

<p align="center">
  <i>API REST robusta desarrollada con Spring Boot para la gestión eficiente de gastos personales. Permite el control total (CRUD) y filtrado avanzado de transacciones financieras.</i>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
</p>

---

## 🚀 Tecnologías Utilizadas

El proyecto está construido sobre un stack moderno enfocado en la escalabilidad y el rendimiento:

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.x
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL / PostgreSQL
* **Gestor de Dependencias:** Maven
* **Arquitectura:** RESTful Web Services

## 🏗️ Arquitectura y Buenas Prácticas

El backend sigue un diseño de **Arquitectura en Capas** para garantizar una clara separación de responsabilidades, facilitando el mantenimiento y las pruebas:

> **Flujo de Datos:** `Controller` ➔ `Service` ➔ `Repository` ➔ `Database`

### Puntos clave de implementación:
* **Patrón DTO (Data Transfer Object):** Implementado para desacoplar las entidades de la base de datos de la capa de presentación.
* **Manejo Global de Excepciones:** Uso de `@RestControllerAdvice` para respuestas HTTP estandarizadas y control de errores.
* **CORS Configurado:** Preparado para integración con frontend (ej. Angular en el puerto `4200`).

### Estructura del Proyecto
```text
com.example.gestor_datos_personales
 ┣ 📂 controller    # Endpoints y gestión de peticiones HTTP
 ┣ 📂 service       # Lógica de negocio y servicios
 ┣ 📂 repository    # Interfaces de persistencia (JPA)
 ┣ 📂 model
 ┃ ┣ 📂 entity      # Mapeo de tablas de base de datos
 ┃ ┗ 📂 enumerador  # Categorías de gastos (Enums)
 ┣ 📂 dto           # Objetos para transferencia de datos
 ┗ 📂 exception     # Clases para el manejo de errores
