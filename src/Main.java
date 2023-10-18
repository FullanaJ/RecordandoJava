import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    public static void main(String[] args) {
        int[] num = new int[10];
        boolean[] primo = new boolean[10];

        Utilidades.llenaAleatorios(num);
        for (int i = 0,size = num.length; i<size; i++) {
            primo[i] = Utilidades.naive(num[i]);
        }
        Utilidades.esPrimo(num,primo);
    }
*/
/*
* Tema 1. Práctica 1: Recordando Java.
Esta primera práctica servirá como repaso de Java. Además lo que trabajemos lo
utilizaremos en prácticas posteriores.
*
Se pide crear un programa en Java que inicializa un array con 10 números enteros, crea un
array de 10 elementos booleanos y el además debe calcular para cada uno de los 10
números si es un número primo o no (y rellenando esa información en el segundo array).
*
1. Creamos la clase principal de la aplicación que podemos llamar Main.

* 2. Creamos una nueva clase Utilidades donde pondremos diferentes métodos
estáticos.

* 3. Creamos en utilidades un método que reciba un array de números enteros (el tipo
entero mayor que permita Java) y lo rellene con números aleatorios (el 10% más
elevado que permita Java).

* 4. Creamos en utilidades un método “naive” que devuelva true si el número es primo,
false si el número no es primo. Para calcularlo lo haremos de manera poco eficiente
(a propósito): recorremos todos los números enteros menores hasta llegar a 2 para
comprobarlo y dividimos por el número .

* 5. En el programa principal creamos un array de 10 elementos enteros y lo
inicializamos con el método de valores aleatorios.

* 6. Utilizamos el método de cálculo de números primos y vemos cuánto tarda en
ejecutarse, mostraremos este tiempo en segundos, milisegundos y nanosegundos.
Si es un tiempo prudencial (más o menos 1 segundo) modificamos el programa para
que haga el cálculo para 100 elementos (sólo debería cambiar un carácter en todo el
programa).

* 7. En el programa principal mostramos por pantalla cada uno de los números aleatorios
y si es un número primo o no.
* */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {

        //System.out.println(System.getenv());
        new Terminal().ejecuta();

    }


}