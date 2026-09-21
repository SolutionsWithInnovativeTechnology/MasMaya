package Util;

import java.util.Random;

public class Revolver {
    public int[] NumerosAl() {
        int[] numeros = new int[16];
        int cont = 0;
        while (cont < 16) {
            Random v = new Random();
            int numAl = v.nextInt(16) + 1;
            boolean repetido = false;
            for (int i = 0; i < 16; i++) {
                if (numeros[i] == numAl) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                numeros[cont] = numAl;
            } else {
                cont--;
            }
            cont++;
        }
        /*for(int i = 0; i<16; i++) {
            System.out.println(numeros[i]);
        }*/
        return numeros;
    }
}
