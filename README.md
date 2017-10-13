# farmacia

User Interface

https://docs.google.com/document/d/1w0O3Q152NVI3sgsENd-g7LilzkSDNPtw9Vu5KCcPpxY/edit


###Comentarios de Carlos

UI
- [ ] OK que abren una nueva pestaña para cada acción, para la próxima prueben con botones "back"
- [ ] muy bueno el trabajo sobre la gráfica, se nota que hay trabajo y quedó bien.
- [ ] hey, se le animaron a Bootstrap 4, y también a usar un tema (si entendí bien). Después me enseñan :D.
- [ ] debería haber alguna forma de ver el detalle de un ciclo ya cargado.
- [ ] tiene que haber una forma de ordenar las farmacias en un ciclo.
- [ ] sería gentil que se pudiera borrar ciclos, al menos "de atrás para adelante".
- [ ] Alta de farmacias: aparece el cartel "es obligatorio completar todos los campos", pero solamente si cargué nombre y sector.
- [ ] el mensaje "esta fecha no está cubierta" mejor que aparezca en el mismo lugar de las farmacias, o con un estilo que se destaque mucho.
  Estuve un rato hasta que me di cuenta.
- [ ] Alta de excepciones
 	- [ ] no tiene "cancelar"
	- [ ] una vez me permitió que una farmacia se reemplace a sí misma. Veo que está la excepción. Cuando no me deja, no muestra nada en pantalla, o no veo dónde.
    UPDATE ahora entiendo, en el update no hace la validación.
- [ ] después de agregar un ciclo, sería mejor que volviera a mostrar el sector que estaba mostrando.


####Código y diseño
- [ ] el método getDate() en IndexController podría llamarse p.ej. getShiftDate()
- [ ] en lugar de Exception, va ShiftException o algo, recuerden que "Exception" tiene un significado claro en el mundo Java.
- [ ] cof cof es found, no finded (en Sector)
- [ ] en addOrReplaceException de Cycle, está muy bien usado que findException() devuelve un Optional. 
  Pero OJO, si en su aplicación algunos find devuelven un Optional y otros el objeto, se pone confuso.
  Opción: distinguir por el nombre del método, p.ej. findExceptionAsOptional, para los casos que se desvíen del standard que se defina.
- [ ] (en el accept del CycleController) c.getChecked().equals(true) se puede escribir más corto, c.getChecked()
- [ ] en Cycle tenemos esto

  public void setPharmacysInCycle(List<Pharmacy> pharmacysInCycle) {
    this.pharmacysInCycle = new ArrayList<>(pharmacysInCycle);
  }
  conviene que agregue, no que cambie. 
  
- [ ] CycleController: creo que conviene que el fillChecked lo lance el constructor del mismo CycleController, no desde afuera. Si no tiene los checked, el CycleController no funca.
- [ ] el constructor sin parámetros de NewCyclePage no anda.

Varios
[ ] el juego de prueba debería incluir excepciones.