# AngelicaBeitechDelivery
Practical evaluation for java developer.

Instrucciones de despliegue:

BACKEND:
1. Contar con un servidor Wildfly 10.0.0 final.
2. Modificar las propiedades de conexión a base de datos (URL, usuario y contraseña) en el archivo "application.properties" que se encuentra en la ruta src/main/resources del proyecto "AngelicaRestService"
3. Compilar el proyecto utilizando los goals "clean install" de Maven.
4. Dentro de la carpeta "target" se genera un archivo .war llamado "webapp.war", colocarlo dentro de la carpeta "deployments" del standalone en wildfly.
5. Iniciar el servidor wildfly.

Los servicios disponibles para invocar son:

- {host}/webapp/API/GetCustomers
- {host}/webapp/API/GetAllowedProductsByCustomer/{id}
- {host}/webapp/API/AddOrder/{id}
