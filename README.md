# Challenge Final Automatización Web con Screen Play
## Relizado por Mateo Gómez

### 1. Prerequisitos:
	- Maquina local con el sistema operativo Windows 10/11
	- IntelliJ IDEA Community Edition 2024.1.4 / IntelliJ IDEA 2024.1.3
	- Apache Maven 3.9.8 (debe estar en la variable de entorno)
	- JDK versión 11 (Debe estar configurado en la variable de entorno y verificarse en la estructura del proyecto)

### 2. Comandos de instalación
   En caso de que el proyecto no funcione correctamente o presente algún error, ejecuta los siguientes comandos en el siguiente orden indicado:
   - mvn clean (Limpia el proyecto, en el caso de existir algún error)
   - mvn clean install -U (Limpia el proyecto, instala depdendencias y actualiza las dependencias a sus últimas versiones)
   - mvn install -DskipTests (descarga todas las dependencias del POM)
   - mvn dependency:resolve (Descarga todas las dependencias)
   - mvn install (Para compilar y empaquetar el proyecto además de resolver las dependencias)

### 3. Instrucciones para ejecutar los test

1. **Acceder a la Carpeta de Recursos de Pruebas**:
    - Dirígete a la ruta `src/test/java/com.example/runners` dentro del directorio del proyecto.

2. **Ejecutar las Pruebas**:
    - Haz clic en `CucumberTestSuite` para iniciar la ejecución de la automatización.

3. **Generar y Obtener los Reportes**:
    - Al finalizar las pruebas, ejecuta el comando `mvn serenity:aggregate` en la consola para generar un reporte en formato HTML. Si deseas ejecutar automáticamente las pruebas y generar los reportes, utiliza el comando completo `mvn verify`.


4. **Visualizar los Reportes**:
    - El enlace al archivo HTML del reporte estará disponible después de ejecutar el comando anterior. En caso de que el enlace no aparezca, ejecuta `mvn clean` seguido de la ejecución de las pruebas nuevamente y finaliza con `mvn verify` para generar el reporte.


### 4. Información adicional
El driver no se excluyó del proyecto para optimizar la velocidad de ejecución. Si se desea cambiar, dirigirse a la ruta `src/resources/webdriver/windows`.

