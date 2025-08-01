package ve.edu.ucab.proyectoprogramacion.model.activos;

public class Criptomoneda extends Activo{

    //Atributo para asignar la cantidad a comprar
    private Double cantidad;

    //Constructor llamando a constructor padre ya que comparten atributos
    public Criptomoneda(String nombre, String simbolo, double precioActual) {
        super(nombre, simbolo, precioActual);
    }

    //Getter y Setter para poder asignar y obtener cantidad que se tenga
    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}



