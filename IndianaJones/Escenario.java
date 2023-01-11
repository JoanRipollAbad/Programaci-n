package IndianaJones;

public class Escenario {

    /** ESCENARIO
     * Esta clase agrupa métodos dedicados a la gestión del escenario del juego. El escenario se
     * representa como un array multidimensional de String, donde los posibles valores de los
     * String podrán ser tres: Muro, Nada o Gema a través de valores Unicode que representan
     * emojis. Utiliza los valores Unicode que creas más adecuados para cada representación.
     */

    /**
     * Define e inicializa estas constantes de estado de celda con estos nombres
     * Las celdas del escenario sólo podrán contener uno de estos tres valores
     */
    static final String NADA = "\uD83D\uDD34";
    static final String MURO = "\uD83E\uDDF1";
    static final String GEMA = "\uD83D\uDC8E";
    static final String SERPIENTE = "\uD83D\uDC0A";
    static final String PERSONAJE = "\uD83C\uDFC3"; //cambiar le dibujito osea la parte del ud...

    /**
     * Crea y devuelve el escenario inicial del juego. Dispones de un ejemplo de
     * definición aquí
     */
    public static String[][] creaEscenario(){

        return new String[][]{
            {MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO},
            {MURO, NADA, NADA, NADA, MURO, GEMA, MURO, NADA, NADA, MURO},
            {MURO, NADA, NADA, NADA, MURO, NADA, MURO, NADA, MURO, MURO},
            {MURO, NADA, NADA, NADA, NADA, NADA, NADA, NADA, NADA, MURO},
            {MURO, NADA, NADA, NADA, NADA, NADA, NADA, NADA, NADA, MURO},
            {MURO, MURO, MURO, NADA, NADA, NADA, NADA, NADA, NADA, MURO},
            {MURO, NADA, NADA, NADA, NADA, MURO, MURO, MURO, MURO, MURO},
            {MURO, NADA, NADA, NADA, NADA, NADA, MURO, NADA, MURO, MURO},
            {MURO, NADA, MURO, NADA, NADA, NADA, NADA, NADA, GEMA, MURO},
            {MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO, MURO},
        };
    }

    /**
     * Retorna true si la coordenada x,y pertenece a una posición del escenario dado.
     */
    public static boolean esUnPuntoDelEscenario(String[][] escenario, int x, int y){

        if (y <= escenario.length){

            for (int i = 0; i < escenario.length; i++) {
                if (x < escenario[i].length || x > escenario[i].length){
                    return false;
                }
            }
        }

    return true;
    }

    /**
     * Determina si la celda de la posición (x,y) del escenario es válida para ser pisada por un personaje.
     * La celda podrá ser pisada si:
     * - La coordenada x,y pertenece al escenario
     * - En la celda de la posición (x,y) no hay un MURO
     * Retorna true si está permitido el paso a un personaje / false en caso contrario
     */
    public static boolean estaPermitidoElPaso(String [][] escenario, int x, int y) {

        if (esUnPuntoDelEscenario(escenario, x, y)) {
            for (int i = 0; i < escenario.length; i++) {
                for (int j = 0; j < escenario[i].length; j++) {
                    if (escenario[i][j].equals(MURO)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Determina si en la celda de la posición (x,y) del escenario hay una gema.
     * Retorna: true si en la celda hay una gema / false si no la hay o bien si la coordenada (x,y) no pertenece a una posición del escenario
     */
    public static boolean hayGema(String[][] escenario, int x, int y){

        if (esUnPuntoDelEscenario(escenario, x, y)) {

            if (escenario[y][x].equals(GEMA)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vacía el contenido de la celda de la posición (x,y) del escenario. Una celda queda vacía si contiene un objeto NADA en su interior.
     * La celda no se verá modificada si:
     * - La coordenada (x,y) no pertenece a una posición al escenario
     */
    public static void vaciarCelda(String[][] escenario, int x, int y){

        if (esUnPuntoDelEscenario(escenario, x, y)) {

            if (escenario[y][x].equals(GEMA)) {

            }
        }
    }

    /**
     * Determina si en el escenario queda alguna gema sin recoger
     */
    public static boolean quedanGemas(String[][] escenario){

        int gemasQuedan = 0;

        for (int i = 0; i < escenario.length; i++) {
            for (int j = 0; j < escenario.length; j++) {
                if (escenario[i][j].equals(GEMA)){
                    gemasQuedan++;
                }
            }
        }
        if (gemasQuedan == 0){
            return false;
        }
        else {
            return true;
        }
    }

}
