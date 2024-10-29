package ar.edu.unju.escmi.tp6.punto3;

//Resolución de Preguntas

//1 ¿Por qué no se dibuja la relación de agregación entre la clase CollectionProducto y Producto?
//No se dibuja la relación de agregación entre CollectionProducto y Producto porque CollectionProducto utiliza la clase Producto únicamente para almacenar objetos dentro de una lista sin necesidad de establecer una relación formal. Esta práctica permite que CollectionProducto gestione varios productos sin que tenga una conexión estructural o una dependencia que deba representarse en el diagrama.
//2 ¿Cuántos atributos tiene la clase Factura? ¿Cuáles son los nombres de esos atributos?
//La clase Factura tiene cuatro atributos:
//1.	fecha (tipo LocalDate): Es la fecha en que se genera la factura.
//2.	nroFactura (tipo long): Es el número de la factura.
//3.	cliente (tipo Cliente): Es el cliente que está asociado a la factura.
//4.	detalles (tipo List<Detalle>): Es una lista de objetos Detalle, que contiene los detalles de los productos o servicios que están incluidos en la factura.


//3 ¿Cómo se llama la relación que se establece entre Factura y Detalle?
//La relación entre Factura y Detalle se llama composición. Esto es porque una factura está compuesta por varios detalles, y esos detalles no pueden existir por sí solos sin la factura.

//4 ¿Cómo se llama la relación entre las clases Factura y Cliente?
//La relación entre Factura y Cliente es una asociación, porque cada factura está relacionada con un cliente que la genera o recibe. No es algo tan fuerte como la composición, ya que un cliente puede existir sin una factura.
//5 ¿Por qué los atributos de las clases Collections son públicos?
//Los atributos de las clases de colecciones a veces se hacen públicos para que sea más fácil acceder a los elementos. En vez de usar métodos como get y set para acceder a todo, se pueden manipular directamente. 

//6 Describa las características de todos los métodos de la clase CollectionClientes.
//•  precargarClientes():
//•	Este método es estático, lo que significa que se puede usar sin tener que crear una instancia de la clase. Su función es cargar algunos clientes y sus tarjetas de crédito en la lista clientes si está vacía. Primero, crea los clientes y las tarjetas, luego los asocia y finalmente los agrega a la lista de clientes.
//•  agregarCliente(Cliente cliente):
//•	Este método también es estático y sirve para agregar un cliente a la lista de clientes. Si hay algún error (por ejemplo, si la lista está bloqueada o llena), imprime un mensaje diciendo que no se pudo guardar el cliente.
//•  buscarCliente(long dni):
//•	Este método busca un cliente en la lista usando su DNI (documento de identidad). Recorre la lista de clientes y si encuentra uno con el DNI que se le pasa, lo devuelve. Si no lo encuentra o si hay un error durante la búsqueda, devuelve null.
