package org.example.lm.tinnova.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digite um número: ");

        int number = Integer.parseInt(bufferedReader.readLine());

        int sum = 0;
        for (int i = number - 1; i > 0; i--) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println("A soma dos múltiplos de 3 e 5 abaixo de " + number + " é: " + sum);
    }
}