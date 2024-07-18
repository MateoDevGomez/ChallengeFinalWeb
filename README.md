# Challenge Final Automatización Web con Screenplay

## Realizado por Mateo Gómez

### 1. Prerrequisitos
- Máquina local con el sistema operativo Windows 10/11
- IntelliJ IDEA Community Edition 2024.1.4 / IntelliJ IDEA 2024.1.3
- Apache Maven 3.9.8 (debe estar en la variable de entorno)
- JDK versión 11 (debe estar configurado en la variable de entorno y verificarse en la estructura del proyecto)

### 2. Comandos de instalación
En caso de que el proyecto no funcione correctamente o presente algún error, se deben ejecutar los siguientes comandos en el orden indicado:
- `mvn clean` (limpia el proyecto en caso de existir algún error)
- `mvn clean install -U` (limpia el proyecto, instala dependencias y actualiza las dependencias a sus últimas versiones)
- `mvn install -DskipTests` (descarga todas las dependencias del POM)
- `mvn dependency:resolve` (descarga todas las dependencias)
- `mvn install` (para compilar y empaquetar el proyecto además de resolver las dependencias)

### 3. Objetivo de las pruebas
Las pruebas se realizaron a través del patrón Screenplay, en el ambiente de pruebas ubicado en la URL [https://www.demoblaze.com/](https://www.demoblaze.com/), donde se consideró el siguiente flujo:

- Agregar dos productos al carrito
- Visualizar el carrito
- Completar el formulario de compra
- Finalizar la compra

Para ello, se comenzó con la redacción de los pasos en lenguaje Gherkin en un Escenario Outline, ubicado en el directorio `src/resources/features` bajo el nombre `ProductStore.feature`.

### 4. El patrón Screenplay
El patrón Screenplay es un enfoque de diseño para la automatización de pruebas que se centra en la interacción de los actores con el sistema. En lugar de basarse en acciones secuenciales, Screenplay modela las tareas que los actores realizan y las preguntas que pueden hacer sobre el estado del sistema. Esto permite una mayor reutilización de código y una mejor legibilidad de las pruebas.

#### Step Definitions
Los Step Definitions (`StepDefs`) permitieron la unión entre el lenguaje Gherkin y las Tasks y Questions. Estos se encuentran en el archivo `StoreStepdefs`, ubicado en `src/java/com.example/stepdefinitions`. Los `StepDefs` actúan como puente entre el lenguaje natural de los escenarios en Gherkin y las acciones de automatización.

#### Tasks
Las Tasks se encargaron de interactuar directamente con la página web, manipulando elementos HTML para realizar acciones como ingresar datos o hacer clic en botones. Estos archivos se encuentran en `src/java/com.example/Tasks` y tienen nombres como:
- `AddToCart`: añade un producto al carrito
- `FillOutForm`: llena el formulario de entrega
- `NavigateTo`: permite navegar a la página principal o entre páginas

#### Questions
Las Questions permitieron validar ciertos elementos ya que no realizan cambios de estado, solo extraen información. Estos archivos se encuentran en `src/java/com.example/Questions` y tienen nombres como:
- `CartQuestion`: permite ver si los productos escogidos están en el carrito
- `CompletePurchase`: extrae información de la alerta de compra para validar que se realizó con éxito
- `FormQuestion`: valida que el formulario se desplegó

#### User Interfaces
Las User Interfaces permitieron localizar los elementos a través de targets con los cuales se interactuaría. Estos archivos se encuentran en `src/java/com.example/userinterfaces` y dependen de la página en la que se esté. Los casos de uso son dos:
- `StorePage`: contiene los targets de todos los elementos HTML de la página principal con los que se interactuará
- `CartPage`: contiene los targets de los elementos HTML del carrito con los que se interactuará

### 5. Instrucciones para ejecutar las pruebas

1. **Acceder a la carpeta de recursos de pruebas**:
    - Diríjase a la ruta `src/test/java/com.example/runners` dentro del directorio del proyecto.

2. **Ejecutar las pruebas**:
    - Haga clic en `CucumberTestSuite` para iniciar la ejecución de la automatización y luego haga clic en "Run". Este Runner desplegará el navegador junto con la automatización y los datos ingresados en el Feature.

3. **Generar y obtener los reportes**:
    - Al finalizar las pruebas, ejecute el comando `mvn serenity:aggregate` en la consola para generar un reporte. Aparecerá un link que redirigirá directamente a un navegador. Si se desea ejecutar automáticamente las pruebas y generar los reportes, utilice el comando completo `mvn verify`.
    
    ## Reportes Serenity
    - Los reportes de Serenity se generarán en formato HTML y se podrán encontrar en la ruta `target/site/serenity/`. En este directorio se encontrará una gran cantidad de documentos HTML. Localice el documento `index.html`, haga clic derecho, busque la opción "Abrir en" u "Open in" y escoja un navegador.

4. **Visualizar los reportes**:
Una vez que los reportes hayan sido abiertos en un navegador, se podrán visualizar y navegar por los diferentes archivos HTML que conforman el reporte completo.

### 6. Información adicional
El driver no se excluyó del proyecto para optimizar la velocidad de ejecución. Si se desea cambiar, diríjase a la ruta `src/resources/webdriver/windows`.

