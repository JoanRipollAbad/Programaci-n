package IndianaJones;

public class Serpientes {
    /**
     * Esta clase agrupa métodos dedicados a la gestión de posición y desplazamiento de los
     * personajes Serpientes.
     */

    /**
     * Obtiene la posición de inicio de las serpientes del juego.
     * Elige a mano tantas posiciones de serpientes como desees.
     */
    public static int[][] obtenerPosicionesInicio(){

        return new int[][] {{8,3} , {4,8} , {5,2}};
    }

    /**
     * Modifica la posición proporcionada por las posiciones de inicio de cada serpiente.
     */
    public static void reestablecerAPosicionesIniciales(int[][] posicionesSerpientes){

        posicionesSerpientes = obtenerPosicionesInicio();
    }

    /**
     * Modifica las posiciones de las serpientes siguiendo el
     * algoritmo de movimiento de las serpientes
     */
    public static void mover(String[][] escenario, int[][] posicionSerpientes){

        int posSerpiente;
        int[] ayuda;

        for (int i = 0; i < posicionSerpientes.length; i++) {

            int intentos = 0;

            do {
                posSerpiente = Movimiento.obtieneDireccionAleatoria();
                ayuda = Movimiento.obtenerCoordenadaAdyacente(posSerpiente, posicionSerpientes[i]);

                if (Escenario.estaPermitidoElPaso(escenario, posicionSerpientes[i][0], posicionSerpientes[i][1]) || !escenario[ayuda[0]][ayuda[1]].equals(Escenario.SERPIENTE)){

                    Movimiento.obtenerCoordenadaAdyacente(posSerpiente, posicionSerpientes[i]);
                }

                intentos++;

            }while (intentos < 3);

            for (int j = 1; j <= 4 ; j++) {

                ayuda = Movimiento.obtenerCoordenadaAdyacente(j, posicionSerpientes[i]);

                if (Escenario.estaPermitidoElPaso(escenario, ayuda[0], ayuda[1]) || !escenario[ayuda[0]][ayuda[1]].equals(Escenario.SERPIENTE)){

                    Movimiento.obtenerCoordenadaAdyacente(j, posicionSerpientes[i]);
                break;
                }
            }
        }
    }
}
