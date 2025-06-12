package ve.edu.ucab.proyectoprogramacion.model.activos;

public class Accion extends Activo{

    //Atributo para asignar la cantidad a comprar
    private Double cantidad;

    //Constructor llamando a constructor padre ya que comparten atributos
    public Accion(String nombre, String simbolo, double precioActual) {
        super(nombre, simbolo, precioActual);
    }

}
