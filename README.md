# PracticaWeb


Queremos Queremos crear una aplicación que gestione un número grande (miles, cientos de miles o millones) 
e páginas web tomadas de Web Data Commons - Hyperlink Graph 2012. Para esta prática utilizaremos una 
versión reducida.

Es decir el objetivo es buscar en nuestra barra de búsqueda una palabra clave* y que la aplicación analice 
todas las páginas webs que contengan en su nombre de la URL si tiene dicha palabra clave, de la manera más rápida posible.

En nuestro Internet particular una web está conectada con otras webs por medio de enlaces
salientes. Una práctica habitual consiste en buscar una web a partir de palabras clave. Por este
motivo, dispondremos también de un diccionario de palabras, donde cada palabra estará
relacionada con las webs a las que hace referencia.

Tenemos tres ficheros: Index, pld-arc y words.txt.

  -Index: asocia un código (valor entero), empezando desde el 0, a cada página web. 
  
  -pld-arc: contiene líneas de forma "x  y", indicando que en la web con código x hay un enlace saliente a la
  web con código y.
  
  -words.txt: contiene una lista de palabras.

*Consideraremos que una palabra P es palabra clave de una web W si se cumplen las dos
condiciones siguientes:
  ● P tiene entre 4 y 10 caracteres (ambos inclusive)
  ● P aparece en la URL de la web W
Por ejemplo, si en el diccionario estuviera formado por las palabras que aparecen en el cuadro
anterior, las palabras clave de la web con URL "www.crediblenessforcredit.com" serían:
- credible
- credit
Sin embargo credibleness no sería palabra clave puesto que, aunque aparece en la URL, tiene
más de 10 caracteres.


Este proyecto lo dividiremos en 3 fases.


FASE 1:

En esta primera fase trabajaremos con ARRAYs y ARRAYs.

Es de mencionar que el fichero words.txt esta ordenado alfabéticamente, por lo que la búsqueda de 
las palabras clave será más sencilla. Realizaremos una búsqueda dicotómica.

El fichero index es el más largo de todos, por lo que el objetivo de esta primera fase será recorrerlo
una sola vez.
