import java.util.Arrays;
import java.util.Scanner;

public class Activitat17 {

    static Scanner teclat;

    public static void main(String[] args) {
        System.out.print("Introduce el tamaño de la matriz: ");
        teclat = new Scanner(System.in);
        int numero = teclat.nextInt();
        int[][] matriz = generaMatrizBinaria(numero);

        visualizarResultados(matriz);
    }

    /**
     * Retorna una matriz binaria aleatoria del tamaño indicado
     **/
    public static int[][] generaMatrizBinaria(int tamanyo) {
        int[][] matriz = new int[tamanyo][tamanyo];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 2);
            }
        }
        return matriz;
    }

    /**
     * Retorna la lista de los índices de las filas con mayor número de unos de la
     * matriz dada.
     * Si la matriz no está compuesta únicamente por 0’s y 1’s retornará null
     **/
    public static int[] indicesFilasConMasUnos(int[][] matrizBinaria) {
        int[] indice = new int[0];
        int contadorUnos = 0;
        int max = 0;
        int otra = 0;

        for (int i = 0; i < matrizBinaria.length; i++) {
            for (int j = 0; j < matrizBinaria[i].length; j++) {
                if (esValida(matrizBinaria)) {
                    if (matrizBinaria[i][j] == 1) {
                        contadorUnos++;
                    }
                } else {
                    return null;
                }
            }
            indice = Arrays.copyOf(indice, indice.length + 1);
            indice[indice.length - 1] = contadorUnos;
            contadorUnos = 0;
        }
        for (int i = 0; i < indice.length; i++) {
            if (indice[i] > max) {
                max = indice[i];
                otra = i;
            }
        }
        int[] ayuda = new int[0];
        for (int i = 0; i < indice.length; i++) {
            if (indice[i] == max) {
                ayuda = Arrays.copyOf(ayuda, ayuda.length + 1);
                ayuda[ayuda.length - 1] = i;
            }
        }
        return ayuda;
    }

    /**
     * Retorna la lista de los índices de las columnas con mayor número de unos de la
     * matriz dada
     * Si la matriz no está compuesta únicamente por 0’s y/o 1’s o tiene tamaño 0
     * retornará null
     **/
    public static int[] indicesColumnasConMasUnos(int[][] matrizBinaria) {
        int[] indice = new int[0];
        int contadorUnos = 0;
        int max = 0;
        int otra = 0;

        for (int i = 0; i < matrizBinaria.length; i++) {
            for (int j = 0; j < matrizBinaria[i].length; j++) {
                if (esValida(matrizBinaria)) {
                    if (matrizBinaria[j][i] == 1) {
                        contadorUnos++;
                    }
                } else {
                    return null;
                }
            }
            indice = Arrays.copyOf(indice, indice.length + 1);
            indice[indice.length - 1] = contadorUnos;
            contadorUnos = 0;
        }
        for (int i = 0; i < indice.length; i++) {
            if (indice[i] > max) {
                max = indice[i];
                otra = i;
            }
        }
        int[] ayuda = new int[0];
        for (int i = 0; i < indice.length; i++) {
            if (indice[i] == max) {
                ayuda = Arrays.copyOf(ayuda, ayuda.length + 1);
                ayuda[ayuda.length - 1] = i;
            }
        }
        return ayuda;
    }

    /**
     * Retorna la lista de los índices de las filas que tengan todas sus celdas a un
     * mismo valor.
     *
     * @valorBinario es el valor 0 o 1
     * Si @matrizBinaria no está compuesta únicamente por 0’s y/o 1’s o tiene tamaño 0
     * retornará null
     * Si se proporciona como @valorBinario un valor que no es ni 0 ni 1 se
     * retornará null
     **/
    public static int[] indicesFilasConMismoValor(int[][] matrizBinaria, int valorBinario) {
        int[] indice = new int[0];
        boolean cosas;

        for (int i = 0; i < matrizBinaria.length; i++) {
            cosas = true;
            for (int j = 0; j < matrizBinaria[i].length; j++) {
                if (esValida(matrizBinaria)) {
                    if (matrizBinaria[i][j] == valorBinario) {
                    } else {
                        cosas = false;
                    }
                } else {
                    return null;
                }
            }
            if (cosas == true) {
                indice = Arrays.copyOf(indice, indice.length + 1);
                indice[indice.length - 1] = i;
            }
        }
        return indice;
    }

    /**
     * Retorna la lista de los índices de las columnas que tengan todas sus celdas a
     * un mismo valor.
     *
     * @valorBinario es el valor 0 o 1
     * Si @matrizBinaria no está compuesta únicamente por 0’s y/o 1’s o tiene tamaño 0
     * retornará null
     * Si se proporciona como @valorBinario un valor que no es ni 0 ni 1 se
     * retornará null
     **/
    public static int[] indicesColumnasConMismoValor(int[][] matrizBinaria, int valorBinario) {
        int[] indice = new int[0];
        boolean cosas;

        for (int i = 0; i < matrizBinaria.length; i++) {
            cosas = true;
            for (int j = 0; j < matrizBinaria[i].length; j++) {
                if (esValida(matrizBinaria)) {
                    if (matrizBinaria[j][i] == valorBinario) {
                    } else {
                        cosas = false;
                    }
                } else {
                    return null;
                }
            }
            if (cosas == true) {
                indice = Arrays.copyOf(indice, indice.length + 1);
                indice[indice.length - 1] = i;
            }
        }
        return indice;
    }

    /**
     * Retorna true si la diagonal mayor de la matriz tiene el mismo valor binario en
     * todas sus celdas.
     *
     * @valorBinario es el valor 0 o 1
     * Si @matrizBinaria no está compuesta únicamente por 0’s y/o 1’s o tiene tamaño 0
     * retornará null
     * Si se proporciona como @valorBinario un valor que no es ni 0 ni 1 se
     * retornará null
     **/
    public static boolean tieneDiagonalMayorMismoValor(int[][] matrizBinaria, int valorBinario) {
        int[] indice = new int[0];

        if (esValida(matrizBinaria)) {

            for (int i = 0; i < matrizBinaria.length; i++) {
                indice = Arrays.copyOf(indice, indice.length + 1);
                indice[indice.length - 1] = matrizBinaria[i][i];
            }
            for (int i = 0; i < indice.length; i++) {
                if (indice[i] != valorBinario){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna true si la subdiagonal de la matriz tiene el mismo valor binario en
     * todas sus celdas.
     *
     * @valorBinario es el valor 0 o 1
     * Si @matrizBinaria no está compuesta únicamente por 0’s y/o 1’s o tiene tamaño 0
     * retornará null
     * Si se proporciona como @valorBinario un valor que no es ni 0 ni 1 se
     * retornará null
     **/
     public static boolean tieneSubdiagonalMismoValor(int[][] matrizBinaria, int valorBinario) {
         int[] indice = new int[0];

         if (esValida(matrizBinaria)) {

             for (int i = 0; i < matrizBinaria.length; i++) {
                 indice = Arrays.copyOf(indice, indice.length + 1);
                 indice[indice.length - 1] = matrizBinaria[i][matrizBinaria.length - i - 1];
             }
             for (int i = 0; i < indice.length; i++) {
                 if (indice[i] != valorBinario){
                     return false;
                 }
             }
             return true;
         }
         return false;
      }

    /**
     * Imprime los resultados de los 6 puntos exigidos por el ejercicio en función de
     * la matriz binaria recibida como parámetro
     * Si la matriz no está compuesta únicamente por 0’s y 1’s imprimirá el mensaje de
     * error: ‘La matriz proporcionada no es binaria’
     **/
    public static void visualizarResultados(int[][] matrizBinaria){

        if (esValida(matrizBinaria) == false){
            System.out.println("La matriz proporcionada no es binaria");
        }

        verMatriz(matrizBinaria);
        System.out.printf("1. Fila índice %s con mayor número de 1’s\n" , Arrays.toString(indicesFilasConMasUnos(matrizBinaria)));
        System.out.printf("2. Columna índice %s con mayor número de 1’s\n" , Arrays.toString(indicesColumnasConMasUnos(matrizBinaria)));

        int[] arrayVacio = new int[0];

        if (indicesFilasConMismoValor(matrizBinaria, 1) == arrayVacio){
            System.out.println("3. No hay filas con el mismo número.");
        }
        else if ( indicesFilasConMismoValor(matrizBinaria , 0) == arrayVacio) {
            System.out.println("3. No hay filas con el mismo número.");
        }
        else {
            System.out.printf("3. Fila índice %s con todo 0’s\n" , Arrays.toString(indicesFilasConMismoValor(matrizBinaria, 0)));
            System.out.printf("3. Fila índice %s con todo 1’s\n" , Arrays.toString(indicesFilasConMismoValor(matrizBinaria, 1)));
        }
        if (Arrays.toString(indicesColumnasConMismoValor(matrizBinaria, 1)) == Arrays.toString(arrayVacio) || Arrays.toString(indicesColumnasConMismoValor(matrizBinaria , 0) ) == Arrays.toString(arrayVacio)){
            System.out.println("4. No hay Columnas con el mismo número.");
        }
        else {
            System.out.printf("4. Columna índice %s con todo 0’s\n" , Arrays.toString(indicesColumnasConMismoValor(matrizBinaria, 0)));
            System.out.printf("4. Columna índice %s con todo 1’s\n" , Arrays.toString(indicesColumnasConMismoValor(matrizBinaria, 1)));
        }
        if (tieneDiagonalMayorMismoValor(matrizBinaria, 1) == true){
            System.out.printf("5. Diagonal mayor con todo 1’s \n");
        }
        else if (tieneDiagonalMayorMismoValor(matrizBinaria, 0) == true){
            System.out.printf("5. Diagonal mayor con todo 0’s \n");
        }
        else {
            System.out.println("5. Diagonal mayor con mezcla de 0’s y 1’s");
        }
        if (tieneSubdiagonalMismoValor(matrizBinaria, 1) == true){
            System.out.printf("6. Subdiagonal con todo 1’s \n");
        }
        else if (tieneSubdiagonalMismoValor(matrizBinaria, 0) == true){
            System.out.printf("6. Subdiagonal con todo 0’s \n");
        }
        else {
            System.out.println("6. Subdiagonal con mezcla de 0’s y 1’s");
        }
    }

    public static void verMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean esValida(int[][] matriz) {
        if (matriz.length == 0) {
            return false;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1 || matriz[i][j] == 0) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
