# Mi barrio al día

**Una plataforma comunitaria para reportar, consultar y hacer seguimiento a problemas cotidianos en los barrios de Barranquilla, Colombia.**

**Idiomas:** [English](README.md) | Español

## Acerca del proyecto

**Mi barrio al día** es una iniciativa comunitaria de código abierto en desarrollo, cuyo propósito es facilitar que los ciudadanos documenten y consulten problemas que afectan sus barrios.

La plataforma permitirá registrar incidencias, aportar evidencias fotográficas y consultar reportes mediante un mapa interactivo organizado por barrios.

> **Estado actual:** Discovery (investigación) y planificación del Producto Mínimo Viable (MVP). La aplicación todavía no está disponible para uso público.

## El problema

En Barranquilla existen situaciones cotidianas que pueden afectar el espacio público:

- Alumbrado público averiado o sustraído.
- Basura acumulada.
- Animales muertos en espacios públicos.
- Andenes deteriorados.
- Vías bloqueadas o dañadas.

Durante nuestra investigación inicial, cinco personas que viven o transitan por Barranquilla compartieron experiencias e inquietudes relacionadas con incidencias comunitarias, visibilidad de problemas, seguridad e información por barrios.

Estos hallazgos son preliminares y continuaremos validándolos durante Discovery.

## Funcionalidades propuestas

### Producto Mínimo Viable (MVP)

- Mapa interactivo con límites de barrios.
- Creación y consulta de reportes comunitarios.
- Categorías y descripciones de incidencias.
- Selección manual de ubicación o geolocalización voluntaria.
- Visualización pública de ubicaciones aproximadas.
- Evidencias fotográficas.
- Panel de reportes por barrio.
- Fecha, detalle y estado básico de cada reporte.

El alcance definitivo del MVP todavía está sujeto a validación.

### Funcionalidades futuras

- Confirmaciones comunitarias e historial de cambios.
- Estadísticas e indicadores por barrio.
- Indicadores de percepción ciudadana de seguridad.
- Orientación hacia canales oficiales de emergencia y asistencia policial.
- Preparación de borradores para solicitudes PQRSD.
- Moderación y funcionalidades adicionales de accesibilidad.

## Tecnologías

| Componente | Tecnología |
|---|---|
| Frontend | React, TypeScript, Vite |
| Backend | Java, Spring Boot |
| Base de datos | PostgreSQL, PostGIS |
| Mapas | Leaflet |
| Ingeniería de datos | Python, SQL |
| Pruebas | JUnit, Playwright |
| Control de versiones | Git, GitHub |
| CI/CD | GitHub Actions |

La arquitectura evolucionará según las necesidades reales del producto.

## Principios del proyecto

- **Enfoque comunitario:** resolver necesidades identificadas mediante investigación.
- **Privacidad:** proteger información personal y ubicaciones sensibles.
- **Transparencia:** distinguir reportes comunitarios de respuestas oficiales verificadas.
- **Seguridad:** incorporar validaciones, controles de acceso y prevención de abusos.
- **Accesibilidad:** interfaz en español por defecto, con soporte previsto para inglés.
- **Aprendizaje:** documentar decisiones técnicas y fomentar la colaboración.
- **Presupuesto US$0:** utilizar inicialmente herramientas y servicios gratuitos.

## Aviso importante

Mi barrio al día es una iniciativa independiente.

**No es un sistema oficial de la Alcaldía de Barranquilla, no radica automáticamente PQRSD y no reemplaza a los servicios de emergencia.**

Los reportes comunitarios no deben interpretarse como información verificada por una autoridad.

## Metodología de desarrollo

Trabajaremos mediante hitos verificables y prácticas ágiles inspiradas en Kanban.

Las actividades se organizarán utilizando GitHub Issues, ramas de trabajo, Pull Requests, revisiones de código y criterios de aceptación.

### Hitos iniciales

1. Investigación y definición de requisitos.
2. Arquitectura y preparación del entorno.
3. Desarrollo de reportes y mapa interactivo.
4. Seguridad, pruebas y funcionalidades complementarias.
5. Despliegue de una demo pública y documentación.

## Equipo

El proyecto cuenta inicialmente con tres colaboradores, con diferentes niveles de experiencia técnica.

Nuestro enfoque será compartir conocimientos, revisar implementaciones y aprender mientras construimos un producto útil.

## Contribuciones

Las instrucciones para contribuir y configurar el entorno de desarrollo se publicarán próximamente.

## Licencia

Todavía no se ha seleccionado una licencia de software. Que el repositorio sea público no implica autorización general para reutilizar, modificar o redistribuir su contenido.

---

**Construido para aprender, colaborar y desarrollar tecnología con propósito comunitario.**
