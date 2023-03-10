package IndianaJones;

import java.util.Arrays;
import java.util.Scanner;

public class Movimiento {
    /**
     * Esta clase agrupa métodos dedicados a la gestión de desplazamiento de los personajes
     * del juego. Debes definir en ella las constantes relacionadas con las direcciones y
     * movimientos de los mismos.
     */

    /**
     * Determina si el valor de @direccion corresponde a un valor numérico de dirección válido (1: Arriba, 2:Abajo, 3: Derecha o 4: Izquierda)
     *
     * @return true si el valor de @direccion es válido
     */

    public static boolean esUnaDireccionValida(int direccion) {

        if (direccion >= 1 && direccion <= 4) {
            return true;
        }
        else return false;
    }

    /**
     * Obtiene una dirección de movimiento válida y aleatoria: un valor entre 1 y 4.
     *
     * @return El valor de la dirección generada
     */
    public static int obtieneDireccionAleatoria() {

        return (int) (Math.random() * 4) + 1;
    }

    /**
     * Obtiene la posición adyacente a la posición proporcionada en la dirección.
     * La posición retornada será la misma que la original si:
     * - Se proporciona una dirección no válida (siendo los valores válidos 1:Arriba, 2:Abajo, 3: Derecha o 4: Izquierda)
     * - @posicion es un array de dimensión diferente a 2.
     * El parámetro @posicion contiene las coordenadas desde las cuales se va a calcular la nueva posición
     * Retorna La nueva posición desde @posicion en función de la dirección @direccion
     * Ejemplos:
     * - para una posición [1,1] y una dirección 2 (abajo), la posición devuelta sería * la [2,1]
     * - para una posición [1,1] y una dirección 3 (derecha), la posición devuelta
     * sería la [1,2]
     */
    public static int[] obtenerCoordenadaAdyacente(int direccion, int[] posicion) {

        int[] posic = Arrays.copyOf(posicion, posicion.length);

        if (!esUnaDireccionValida(direccion) || posic.length != 2){

                return posic;

            }
            switch (direccion){
                case 1: posic[0] -= 1;
                break;
                case 2: posic[0] += 1;
                break;
                case 3: posic[1] += 1;
                break;
                case 4: posic[1] -= 1;
                break;
            }

        return posic;
    }

    /**
     * Pide al usuario, previa muestra del texto ‘Introduce el movimiento (W/A/S/D):’ que se introduzca por teclado un movimiento.
     * Los posibles movimientos son A: Izquierda S: Abajo D: Derecha W: Arriba
     * Se admiten valores tanto en minúsculas como en mayúsculas.
     * Si se introduce un valor diferente a los enumerados se vuelve a solicitar el dato sin mostrar mensaje de error alguno
     * Este método hace uso del objeto Scanner declarado globalmente en la clase principal.
     * Retorna el valor numérico de la dirección leída (1:Arriba, 2:Abajo, 3: Derecha, 4: Izquierda)
     */
    public static int pedirDireccion() {

        int direccion = 0;

        do {

            System.out.print("Introduce el movimiento (W/A/S/D):");

            switch (Principal.scanner.next()) {

                case "W", "w":
                    direccion = 1;
                    return direccion;
                case "A", "a":
                    direccion = 4;
                    return direccion;
                case "S", "s":
                    direccion = 2;
                    return direccion;
                case "D", "d":
                    direccion = 3;
                    return direccion;
            }

        } while (direccion < 1 || direccion > 4);

        return direccion;
    }
}
