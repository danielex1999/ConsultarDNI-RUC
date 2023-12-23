![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)<img src="https://cdn.iconscout.com/icon/free/png-512/java-43-569305.png" width="35px" alt="java" align="right">

## Consultar RUC

Para este proyecto se busca mediante un Excel ver los DNI registrados, Nombre Completo y RUC en caso de que este
registrado para validar si se encuentra de manera correcta.

El proyecto debe de tener el excel estructurado de la siguiente manera:

|   | A | B | C   | D   | E      | F  | G               |
|---|---|---|-----|-----|--------|----|-----------------|
| 1 |   |   | RUC | DNI | STATUS | ID | Nombre Completo |
| 2 |   |   |     |     |        |    |                 |

El excel generará dentro de la hoja de Excel las siguientes columnas las cuales se generara consultado el DNI dentro de
la página [Buscar por DNI](https://eldni.com/pe/buscar-por-dni).

- **Nombre Consultado (BúsquedaDNI)**
- **Apellido - Nombre Consultado (BúsquedaDNI)**
- **Similitud (%)**

Si el DNI, cuenta con un nombre completo se registra y
luego se hace una comparación del nombre y apellido o viceversa y comparar para determinar el % de similitud.

Por otra parte, si el DNI al ser ingresado tiene como mensaje que no se encontraron datos para el DNI que se ingresó,
asignara el mismo nombre de origen a la celda de **Nombre Consultado (BúsquedaDNI)** y a **Apellido - Nombre
Consultado (BúsquedaDNI)**.

|   | H                               | I             |
|---|---------------------------------|---------------|
| 1 | Nombre Consultado (BúsquedaDNI) | Similitud (%) |
| 2 |                                 |               |


El porcentaje de similitud en este proyecto es del 65%, esto permite para más adelante validar que el RUC sea del DNI y
persona correcta; asi como registrar el status que debería de tener la persona a validar

> [!IMPORTANT]
> Actualmente el proyecto se encuentra avanzado hasta la sección de Similitud (%)
> Desarrollando actualmente el segmento de Consulta RUC

---
<p align="center">
<img src="src/img/resting.jpg" width="454" alt="resting"/>
</p>

> [!NOTE]
> Se está utilizando para este proyecto las siguientes tecnologías.

<code><a href="" target="_blank"><img src="src/img/selenium.png"	width="26px" alt="selenium"></a></code>
<code><a href="" target="_blank"><img src="src/img/java.png"	width="30px" alt="java"></a></code>
<code><a href="" target="_blank"><img src="src/img/Intellj.svg.png"	width="26px" alt="Intellj"></a></code>

