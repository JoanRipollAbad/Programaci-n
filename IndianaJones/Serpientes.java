package IndianaJones;

import java.util.Arrays;

public class Serpientes {
    /**
     * Esta clase agrupa métodos dedicados a la gestión de posición y desplazamiento de los
     * personajes Serpientes.
     */

    /**
     * Obtiene la posición de inicio de las serpientes del juego.
     * Elige a mano tantas posiciones de serpientes como desees.
     */
    public static int[][] obtenerPosicionesInicio() {

        return new int[][]{{8, 3}, {4, 8}, {5, 2}};
    }

    /**
     * Modifica la posición proporcionada por las posiciones de inicio de cada serpiente.
     */
    public static void reestablecerAPosicionesIniciales(int[][] posicionesSerpientes) {

        int[][] posicionInicio = obtenerPosicionesInicio();

        for (int i = 0; i < posicionInicio.length; i++) {
            for (int j = 0; j < posicionInicio[i].length; j++) {

                posicionesSerpientes[i][j] = posicionInicio[i][j];

            }

        }

    }

    /**
     * Modifica las posiciones de las serpientes siguiendo el
     * algoritmo de movimiento de las serpientes
     */
    public static void mover(String[][] escenario, int[][] posicionSerpientes) {

        int posSerpiente;

        for (int i = 0; i < posicionSerpientes.length; i++) {

            int intentos = 0;
            int[] ayuda;

            do {
                posSerpiente = Movimiento.obtieneDireccionAleatoria();
                ayuda = Arrays.copyOf(Movimiento.obtenerCoordenadaAdyacente(posSerpiente, posicionSerpientes[i]) , posicionSerpientes[i].length);

                if (Escenario.estaPermitidoElPaso(escenario, ayuda[1], ayuda[0]) && Movimiento.esUnaDireccionValida(posSerpiente)) {

                    for (int j = 0; j < posicionSerpientes[i].length; j++) {

                        posicionSerpientes[i][j] = Movimiento.obtenerCoordenadaAdyacente(posSerpiente, posicionSerpientes[i])[j];

                    }
                break;
                }
                intentos++;

            } while (intentos < 3);
        }
    }
}
