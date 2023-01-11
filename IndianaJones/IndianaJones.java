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

        int[] posicionInicio = obtenerPosicionInicio();

        for (int i = 0; i < posicionInicio.length; i++) {

            posicion[i] = posicionInicio[i];

        }

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

        if (Escenario.estaPermitidoElPaso(escenario, Movimiento.obtenerCoordenadaAdyacente(direccion,posicion)[0], Movimiento.obtenerCoordenadaAdyacente(direccion,posicion)[1]) && Movimiento.esUnaDireccionValida(direccion)){

            for (int i = 0; i < posicion.length; i++) {

                posicion[i] = Movimiento.obtenerCoordenadaAdyacente(direccion, posicion)[i];

            }

        }

    }

}