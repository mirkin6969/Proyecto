package ve.edu.ucab.proyectoprogramacion.model.activos;

public class Accion extends Activo{

    //Constructor llamando a constructor padre ya que comparten atributos
    public Accion(String nombre, String simbolo, double precioActual) {
        super(nombre, simbolo, precioActual);
    }

}
