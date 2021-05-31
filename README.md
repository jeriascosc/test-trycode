# test-trycode
 Protecto-tes-trycore

El presente proyecto esta compuesto por dos productos de aplicaciones para la identificación de la información relacionada a los planetas 
habitados por personas y el numero de visitas que puede presentar el portal. 
Los dos productos de aplicaiones son : 

RestApi denominada appserver construida en java con el framework spring boot tools y el gestor de dependencias Maven. Esta aplicación está configurada para manejar datos volátiles como base de datos H2(Spring). 

El otro producto es una aplicación web spa desarrollada en angula para consumir los recursos de la aplicación RestApi appserver.
URL App-Cliente en producción: http://app-client-trycore-test.s3-website.us-east-2.amazonaws.com/


La rest api cuenta con las siguintes caracteristicas.
Java 8 - Gestor de Dependencias Maven
MVC: 
Models: Paquete model 
•	Persona, Planeta
Controllers: Paquete daoController.
•	PersonaDaoController, 
•	PlanetaDaoController.
Views: Paquete restapi:
•	PersonaRestApi  
•	PlanetaRestApi

Metodos de acceso PersonaRestApi  
URL Raíz: v1/persona

List<Object> showAllPersonas( ).
Función para obtener todos los registros de la union de tabla persona y planeta por medio del metodo HTTP get.
URL: /showall
createPersona( Persona persona ).
Función para crear un registro en la tabla persona por medio del metodo HTTP post. Esta función recibe un objeto Persona casteado a un objeto Json con el uso de la anotación @RequestBody
URL: /save
deletePersonaById( Integer id )
Función para eliminar un registro de la tabla persona por medio del metodo HTTP delete
URL: /delete/{id}
Función para actualizar un registro en la tabla persona por medio del metodo HTTP put. Esta función recibe un objeto Persona casteado a un objeto Json con el uso de la anotación @RequestBody
URL: /update
updatePersona( Persona persona ).

getViewDetailPersona( Integer id )
Función para acceder al detalle persona y al mismo tiempo incrementar el campo contador vista de la tabla persona y la tabla planeta.
URL: /viewdetails/{id}
Función para obtener los registros de la tabla persona filtrados por idplanta.
getListPersonasByIdPlaneta( Integer idplaneta )
URL: /viewlite/{id}


Metodos de acceso PlanetaRestApi
URL Raíz: v1/planeta

List<Object>showAllPlaneta( )
Función para obtener todos los registros de la tabla planeta por medio del metodo HTTP get
URL /showall
Función para crear un registro en tabla planeta por medio del metodo HTTP post. Esta función recibe un objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody
createPlaneta( Planeta planeta ).
URL: /save
DeletePlanetaById( Integer id )
Función para eliminar un registro de la tabla planeta por medio del metodo HTTP delete
URL: /delete/{id}
updatePersona( Planeta planeta )
Función para actualizar un registro en la tabla persona por medio del metodo HTTP put. Esta función recibe un objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody.
URL:/update
detailsPlaneta( Integer id )
Función para acceder al detalle planeta y al mismo tiempo incrementar el campo contador vista de la tabla planeta
URL: /details/{id}

getListTop3Planeta( )
Función para obtener el top 3 de los planetas mas visitados.
URL: /top3
Función para obtener una lista de el objeto tipo planeta por medio del metodo HTTP get.
List<Planeta> getPlanetas( )
URL: /showplanetas

URL PRODUCCIÓN: http://trycorerestapitest-env.eba-aksgmn7f.us-east-2.elasticbeanstalk.com/
Documentación Swagger URL: : http://trycorerestapitest-env.eba-aksgmn7f.us-east-2.elasticbeanstalk.com/swagger-ui.html

CONFIGURACIÓN DE ESCENARIOS DE PRODUCCIÓN.

<<<<<<< Updated upstream
=======
El proyecto se desplegará en dos servicios de Aws. La aplicación cliente web se alojará en S3 y la aplicación restfull en Elasticbeanstalk.
Antes de realizar la publicación de cada una de las aplicaciones antes mencionadas, se debe realizar la configuración y generación del archivo jar de la aplicación rest api como primera medida.
Se implementa primero la aplicación restfull porque ésta provee la URI raíz de producción que luego se implementará en la aplicación cliente SPA de angular. Seguido se debe realizar la creación y configuración de la aplicación Elasticbeanstalk de aws. Finalmente se carga el archivo jar y se obtiene la URI raíz. 
A continuación, se muestra en las imágenes el proceso de creación y configuración de la aplicación Elasticbeanstalk.

Configuración de Angular.

Para configura el proyecto cliente web en angular como primera medida, se procede a cambiar la ruta raiz de la aplicación rest api appserver de desarrollo a la ruta de producción, estos archivos están ublicados en la carpeta service.

Luego se debe generar los archivos de producción de angular con el comando ng build --prod. Estos archivos se alojarán dentro de la carpeta del proyecto de angular con el nombre de dist. En este directorio se encontrará una carpeta con el nombre del proyecto, el cual contiene los archivos que posteriormente se cargarán al bucket de amazon s3.
Una vez se culmine el proceso de generación del proyecto angular a producción, se procederá a crear una bucket para el alojamiento de aplicaciones web estáticas.
Cunado se de por terminada la creación y configuración del bucket de amazon s3, se cargan los archivos de producción de angular. Este backet provee una url de acceso, la cual se copia y se pega en el navegador para comprobar el funcionamiento de la aplicación.
Este proceso se evidencia en las siguientes imágenes. 



>>>>>>> Stashed changes
.