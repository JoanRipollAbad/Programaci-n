import java.util.Arrays;

public class EjerciciosRepaso {
    public static void main(String[] args) {

        int[] list = {1, 2, 3, 5, 4};
        for (int i = 0, j = list.length - 1; i < list.length; i++, j--) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            System.out.println(Arrays.toString(list));
        }
        double d[] = new double[10];
        for (int i = 0; i < d.length; i++) {
            double aux = d[i];
            d[i] = Math.random() * 10 + 1;
            if (i == d.length - 1) {
                break;
            }
            d[d.length - 1] = 5.5;
            System.out.println(Arrays.toString(d));
        }
        System.out.println("los 2 primeros " + d[0] + d[1]);
        double suma = 0;
        for (int i = 0; i < d.length; i++) {
            suma += d[i];
        }
        System.out.println("suma todos " + suma);

        double max = 0;
        for (int i = 0; i < d.length - 1; i++) {
            if (d[i] > max) {
                max = d[i];
            }

        }
        double[] aux = new double[0];
        for (int i = 0; i < d.length; i++) {
            if (d[i] == max) {
                aux = Arrays.copyOf(aux, aux.length + 1);
                aux[aux.length - 1] = max;
            }
        }
        System.out.println("el maximo " + Arrays.toString(aux));

        double min = d[0];
        for (int i = 0; i < d.length; i++) {
            if (d[i] < min) {
                min = d[i];
            }
        }
        double[] aux2 = new double[0];
        for (int i = 0; i < d.length; i++) {
            if (d[i] == min) {
                aux2 = Arrays.copyOf(aux2, aux2.length + 1);
                aux2[aux2.length - 1] = min;
            }
        }
        System.out.println("el minimo " + Arrays.toString(aux2));

        int random = (int) (Math.random() * d.length);
        System.out.println("numero random " + d[random]);


        int number = 0; //pregunta 11
        int[] numbers = new int[1];
        m(number, numbers);
        System.out.println("number is " + number + " and numbers[0] is " + numbers[0]);

        int[] lista = {1, 2, 3, 4, 5}; reverse(list);   //pregunta 11-2
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        //pregunta 12

    }
    public static void reverse(int[] lista) {
        int[] newList = new int[lista.length];
        for (int i = 0; i < lista.length; i++)
           newList[i] = lista[lista.length - 1 - i];
        lista = newList;
    }

    public static void m(int x, int[] y) {
        x = 3;
        y[0] = 3;
    }
}