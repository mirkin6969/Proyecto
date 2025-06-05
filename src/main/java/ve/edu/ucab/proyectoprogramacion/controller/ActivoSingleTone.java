package ve.edu.ucab.proyectoprogramacion.controller;

import ve.edu.ucab.proyectoprogramacion.model.activos.Accion;
import ve.edu.ucab.proyectoprogramacion.model.activos.Activo;
import ve.edu.ucab.proyectoprogramacion.model.activos.Criptomoneda;

import java.util.ArrayList;
import java.util.List;

public class ActivoSingleTone {

    private List<Activo> listaActivos;

    private static ActivoSingleTone instance;

    //Creamos SingleTone
    private ActivoSingleTone(){
        listaActivos = new ArrayList<>();
        cargarActivosPredefinidos();
    }

    public static ActivoSingleTone getInstance() {
        if (instance == null) {
            instance = new ActivoSingleTone();
        }
        return instance;
    }

    //Funcion para cargar activos predefinidos que pide
    private void cargarActivosPredefinidos() {
        // 5 acciones predefinidas
        listaActivos.add(new Accion("Apple Inc.", "AAPL", 165.30));
        listaActivos.add(new Accion("Microsoft Corporation", "MSFT", 315.20));
        listaActivos.add(new Accion("Amazon.com Inc.", "AMZN", 133.50));
        listaActivos.add(new Accion("Tesla Inc.", "TSLA", 198.60));
        listaActivos.add(new Accion("Alphabet Inc.", "GOOGL", 126.45));
        // 5 criptomonedas predefinidas
        listaActivos.add(new Criptomoneda("Bitcoin", "BTC", 30450.75));
        listaActivos.add(new Criptomoneda("Ethereum", "ETH", 1950.40));
        listaActivos.add(new Criptomoneda("Binance Coin", "BNB", 302.10));
        listaActivos.add(new Criptomoneda("Cardano", "ADA", 0.39));
        listaActivos.add(new Criptomoneda("Solana", "SOL", 22.15));
    }

    //Imprime la lista de activos
    public void imprimirActivos() {
        System.out.println("Catálogo de Activos:");
        for (Activo activo : listaActivos) {
            System.out.println("- " + activo);
        }
    }

    public List<Activo> obtenerActivos(){
        return listaActivos;
    }
}
