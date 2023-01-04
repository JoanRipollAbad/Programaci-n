package IndianaJones;

public class Juego {
    /**
     * Esta clase agrupa métodos dedicados a la gestión general de la partida en curso del juego.
     */

    /**
     * Imprime el escenario celda a celda. Tendrán prioridad de impresión los
     * personajes antes que el objeto de escenario que contenga (nada, muro o gema).
     * Tras imprimir el escenario, también se imprime el número de vidas y de gemas
     * recogidas hasta el momento.
     */
    public static void imprimirEscenario(String[][] escenario,int[] posicionIndianaJones, int[][] posicionSerpientes){

    }

    /**
     * Mueve a todos los personajes siguiendo los siguientes pasos:
     *  1º Se solicita el movimiento de Indiana Jones.
     *  2º Se mueve a Indiana Jones en la dirección seleccionada.
     *  3º Si tras el movimiento de Indiana Jones, éste no se encuentra ya sobre alguna
     * de ellas, se mueven a todas las serpientes.
     */
    public static void moverATodos(String[][] escenario, int[] posicionIndianaJones, int[][] posicionSerpientes){

    }

    /**
     * Actualiza los datos de vidas y gemas de la partida si procede.
     *
     * Las vidas se verán decrementadas si la posición de Indiana Jones coincide con
     * alguna de las serpientes. En este caso se reestablecerán las posiciones de todos
     * (Indiana Jones y serpientes).
     *
     * Si no se ha perdido una vida, las gemas recolectadas se verán incrementadas si
     * la posición de Indiana jones coincide con la posición de alguna de las gemas del
     * escenario, vaciándose esta celda posteriormente.
     *
     * ESTE MÉTODO MODIFICA LAS VARIABLES GLOBALES de vidas y gemas recolectadas que
     * hayas declarado en esta clase.
     */
    public static void actualizarDatos(String[][]escenario, int[] posicionIndianaJones, int[][]posicionSerpientes){

    }

    /**
     * Se encarga de imprimir el mensaje:
     * "Has perdido. Fin del juego" --> si no quedan vidas (registradas en la variable
     * global)
     * o bien el mensaje:
     *"Has ganado. ¡Enhorabuena!" --> si no quedan gemas en el escenario proporcionado
     */
    public static void imprimirMensajeFinDeJuego(String[][] escenario){

    }


    /**
     * Indica si el juego ha terminado. El juego termina si no quedan vidas o si no quedan gemas en el escenario.
     */
    public static boolean seHaTerminado(String[][]escenario){

        return false;
    }
}
