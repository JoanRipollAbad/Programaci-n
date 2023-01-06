package IndianaJones;

public class IndianaJones {
    /**
     * Esta clase agrupa métodos dedicados a la gestión de posición y desplazamiento del
     * personaje Indiana Jones.
     */

    /**
     * Obtiene la posición de inicio de Indiana Jones.
     * Genera una posición transitable por el personaje dentro del escenario.
     */
    public static int[] obtenerPosicionInicio(){

        return new int[] {1,1};

    }

    /**
     * Modifica la posición proporcionada a la posición de inicio de indiana jones.
     */
    public static void reestablecerAPosicionInicial(int[] posicion){

        posicion = obtenerPosicionInicio();

    }

    /**
     * Modifica, si es posible, la posición proporcionada por la posición adyacente en la dirección dada.
     * La modificación no se realizará si:
     * - La posición adyacente en la dirección dada no es una celda pisable por el
     * personaje.
     * - La dirección es un valor incorrecto. Los valores correctos son (1:Arriba,
     * 2:Abajo, 3: Derecha o 4: Izquierda)
     */
    public static void moverEnDireccion(String[][] escenario, int direccion, int[]posicion){

        int[] ayuda = posicion;
        ayuda = Movimiento.obtenerCoordenadaAdyacente(direccion, posicion);

        if (Escenario.estaPermitidoElPaso(escenario, ayuda[0], ayuda[1]) && Movimiento.esUnaDireccionValida(direccion)){

            Movimiento.obtenerCoordenadaAdyacente(direccion, posicion);

        }

    }

}
