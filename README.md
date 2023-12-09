## Consultar RUC por DNI

Para este proyecto se busca mediante un Excel ver los DNI registrados, Nombre Completo y RUC en caso de que este
registrado para validar si se encuentra de manera corecta, el documento no pertenece o el documento no existe.

El proyecto debe de tener el excel estructurado de la siguiente manera:

|   | A | B | C   | D   | E      | F  | G               |
|---|---|---|-----|-----|--------|----|-----------------|
| 1 |   |   | RUC | DNI | STATUS | ID | Nombre Completo |
| 2 |   |   |     |     |        |    |                 |

El excel generará dentro de la hoja de Excel las siguientes columnas las cuales se generara consultado el DNI dentro de
la página [Buscar por DNI](https://eldni.com/pe/buscar-por-dni).

Si el DNI, cuenta con un nombre completo se registra y
luego se hace una comparación del nombre que se tiene como origen y comparar para determinar el % de similitud.

Por otra parte, si el DNI al ser ingresado tiene como mensaje que no se encontraron datos para el DNI que se ingreso,
asignara el mismo nombre de origen a la celda de Nombre Consultado (BusquedaDNI).

|   | H                               | I             |
|---|---------------------------------|---------------|
| 1 | Nombre Consultado (BusquedaDNI) | Similitud (%) |
| 2 |                                 |               |

> [!CaUTION]
> Para determinar el porcentaje de similud se necesita que los valores de la celda G (Nombre Completo) tenga como orden
> Nombre y Apellido, más no Apellido y Nombre.




> [!NOTE]
> Se está utilizando para este proyecto las siguientes tecnologías.

<code><a href="" target="_blank"><img src="src/img/selenium.png"	width="26px" alt="pyton"></a></code>
<code><a href="" target="_blank"><img src="src/img/java.png"	width="30px" alt="azure"></a></code>
<code><a href="" target="_blank"><img src="src/img/Intellj.svg.png"	width="26px" alt="selenium"></a></code>

