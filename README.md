# test-developer-sysone
 venta-automoviles



1) Adjunto colleccion de postam con los servicios realizados

4) No se pudo hostear la aplicacion. 

6)Intrucciones de como ejecutar el programa:

Requisitos: Para su ejecucion se necesita JRE version 1.8

-Se debe cambiar la configuracion de la ubicacion de la base de datos en el archivo application.properties adjuntado junto con al war
key del properties a modificar: spring.datasource.url

-Correr el siguiente comando para iniciar la app:
java -Dsysone.properties="file:/< colocar el path del archivo application.properties externo>" -jar ventasAutomoviles-0.0.1.war
ejemplo:
>java -Dsysone.properties="file:/D:/desarrollo/bd/desa/application.properties" -jar ventasAutomoviles-0.0.1.war
/******************Armado de ambiente local***********

Version JDK 1.8
Version MVN 3.6.3
Se utilizo base de datos H2 https://www.h2database.com/html/quickstart.html

Para compilar el proyecto localmente no es necesario indicar perfil

En caso de querer generar ar para eliminar el application.properties local y poder realizar una configuracion externa del applicacion.properties
se genero un profile en el pom.xml (dev)
mvn clean install -P dev

si se quiere importar en eclipse correr mvn eclipse:eclipse