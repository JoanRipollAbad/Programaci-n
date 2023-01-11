package IndianaJones;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {

    static int VIDAS = 3;
    static int GEMAS = 0;

    /**
     * Esta clase agrupa métodos dedicados a la gestión general de la partida en curso del juego.
     */

    /**
     * Imprime el escenario celda a celda. Tendrán prioridad de impresión los
     * personajes antes que el objeto de escenario que contenga (nada, muro o gema).
     * Tras imprimir el escenario, también se imprime el número de vidas y de gemas
     * recogidas hasta el momento.
     */
    public static void imprimirEscenario(String[][] escenario,int[] posicionIndianaJones, int[][] posicionSerpientes) {

        boolean serp = true;
        int contador = 0;

        do {

            for (int i = 0; i < Escenario.creaEscenario().length; i++) {
                for (int j = 0; j < Escenario.creaEscenario()[i].length; j++) {
                    serp = true;
                    if (j == posicionIndianaJones[1] && i == posicionIndianaJones[0]) {
                        System.out.print(Escenario.PERSONAJE);
                        continue;
                    }
                        if (j == posicionSerpientes[contador][1] && i == posicionSerpientes[contador][0]) {
                            System.out.print(Escenario.SERPIENTE);
                            serp = false;
                            if (contador < posicionSerpientes.length - 1){
                                contador++;
                            }
                        }
                    if (serp == false) {
                        continue;
                    }
                    System.out.print(escenario[i][j]);
                }
                System.out.println();
            }
        }while (serp == false);
    }

    /**
     * Mueve a todos los personajes siguiendo los siguientes pasos:
     *  1º Se solicita el movimiento de Indiana Jones.
     *  2º Se mueve a Indiana Jones en la dirección seleccionada.
     *  3º Si tras el movimiento de Indiana Jones, éste no se encuentra ya sobre alguna
     * de ellas, se mueven a todas las serpientes.
     */
    public static void moverATodos(String[][] escenario, int[] posicionIndianaJones, int[][] posicionSerpientes){

        int direccion = Movimiento.pedirDireccion();
        IndianaJones.moverEnDireccion(escenario, direccion, posicionIndianaJones);
        for (int i = 0; i < posicionSerpientes.length; i++) {
                if (posicionSerpientes[i] != posicionIndianaJones){
                    Serpientes.mover(escenario, posicionSerpientes);
                }
                else {
                    VIDAS--;
                }
            }
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
    public static void actualizarDatos(String[][]escenario, int[] posicionIndianaJones, int[][]posicionSerpientes) {

        do {
            for (int i = 0; i < escenario.length; i++) {
                for (int j = 0; j < escenario[i].length; j++) {
                    if (escenario[i][j].equals(Escenario.GEMA)) {
                        GEMAS++;
                    }
                    for (int k = 0; k < posicionSerpientes.length; k++) {
                        if (posicionSerpientes[k] == posicionIndianaJones) {
                            VIDAS--;
                            IndianaJones.reestablecerAPosicionInicial(IndianaJones.obtenerPosicionInicio());
                            Serpientes.reestablecerAPosicionesIniciales(Serpientes.obtenerPosicionesInicio());
                        }
                    }
                    if (Escenario.hayGema(escenario, posicionIndianaJones[0], posicionIndianaJones[1])) {
                        GEMAS--;
                        Escenario.vaciarCelda(escenario, posicionIndianaJones[0], posicionIndianaJones[1]);
                    }
                }
            }
        } while (VIDAS > 0);
    }

    /**
     * Se encarga de imprimir el mensaje:
     * "Has perdido. Fin del juego" --> si no quedan vidas (registradas en la variable
     * global)
     * o bien el mensaje:
     *"Has ganado. ¡Enhorabuena!" --> si no quedan gemas en el escenario proporcionado
     */
    public static void imprimirMensajeFinDeJuego(String[][] escenario){

        if (VIDAS == 0){
            System.out.println("Has perdido. Fin del juego");
        }

        if (GEMAS <= 0) {
            System.out.println("Has ganado. ¡Enhorabuena!");
        }
    }


    /**
     * Indica si el juego ha terminado. El juego termina si no quedan vidas o si no quedan gemas en el escenario.
     */
    public static boolean seHaTerminado(String[][]escenario){

        if (VIDAS == 0){
            return true;
        }
        if (Escenario.quedanGemas(escenario)){
            return true;
        }
        return false;
    }
}
