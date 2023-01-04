package IndianaJones;

public class Punto {

    /** PUNTO
     * Esta clase agrupa métodos dedicados a la comparación entre puntos (x,y). Los puntos se
     * representan en forma de arrays de enteros de tamaño 2, donde la posición 0 del array
     * representa a la coordenada X y la posición 1 del array a la coordenada Y del punto.
      */

    /**
     * Determina si los dos arrays de tamaño 2 @punto1 y @punto2 proporcionados
     * contienen la misma información, es decir, la misma posición.
     * Retorna: true/false indicando si la información de ambos puntos es la misma o * bien si alguno de los arrays no es de tamaño 2
     */
    public static boolean sonIguales(int[] punto1, int[] punto2){
        if (punto1.length != 2){
            return false;
        }
        else if (punto1 == punto2){
            return true;
        }
        else return false;
    }

    /**
     * Determina si en la lista de puntos @listaPuntos se encuentra la posición @punto.
     * Retorna true si la información del punto a comparar coincide con alguno de los * contenidos en la lista de puntos / false en caso contrario
     */
    public static boolean hayAlgunPuntoIgual(int[] punto, int[][] listaPuntos){

        for (int i = 0; i < listaPuntos.length; i++) {
            if (listaPuntos[i] == punto){

                return true;

            }
            
        }

        return false;
    }

}
