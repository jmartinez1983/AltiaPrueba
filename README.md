# AltiaPrueba

He creado un proyecto maven con Java 11, la libreria de lombok para las anotaciones y mapstruts para los mapeos.

Con respecto a los campos de la base de datos he añadido un ID para usarlo de clave principal y he cambiado algunos nombres como
CURR a CURRENCY , PRECIO_LISTA a RATE, PRIORIDAD a PRIORITY y PRECIO a PRICE

He creado un contrato en el swagger.yaml con la especificación del api desde el que se crean los objetos a partir del plugin 
"openapi-generator-maven-plugin". He creado a su vez un objeto Product y otro ProductEntity que se van mapeando según van
pasando por las distintas capas para separar el dominio de la lógica de negocio de la parte de datos y del propio Api

He creado una clase para el manejo de excepciones con el @ControllerAdvice para mejorar la limpieza del código y tener esta parte 
centralizada en un único sitio

Para los test he usado MockMvc para la llamada al endpoint de productos con los distintos casos a testear
