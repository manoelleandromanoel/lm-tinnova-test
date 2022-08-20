package org.example.lm.tinnova.test;

public class Exercise_2 {

    private static final int[] vector = {5, 3, 2, 4, 7, 1, 0, 6};

    public static void main(String[] args) {
        Exercise_2.order(vector);

        for (int i : vector) {
            System.out.print(i + " ");
        }
    }

    public static void order(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) { // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
            for (int j = 0; j < vector.length - 1 - i; j++) { // for utilizado para ordenar o vetor.
                int nextValue = vector[j + 1];
                if (vector[j] > nextValue) { //Se o valor da posição atual do vetor for maior que o proximo valor, então troca os valores de lugar no vetor.
                    int aux = vector[j];
                    vector[j] = nextValue;
                    vector[j + 1] = aux;
                }
            }
        }
    }
}