public class Utilidades {
    public static int[] llenaAleatorios(int[] ar){
        for(int i = 0,size = ar.length;i<size;i++){
            ar[i]=(int) (Math.random() *  214748364);
        }
        return ar;
    }
    public static boolean naive(int num){
        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void esPrimo(int[] num,boolean[] pri){
        for (int i = 0,size = num.length; i<size; i++) {
            System.out.print("El numero "+num[i]);
            if (!pri[i])
                System.out.print(" no");
            System.out.println(" es primo");
        }
    }
}
