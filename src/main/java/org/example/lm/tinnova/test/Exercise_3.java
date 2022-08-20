package org.example.lm.tinnova.test;

public class Exercise_3 {

    public static void main(String[] args) {
        int f = 1;
        int c = 3;
        StringBuilder stringBuilder = new StringBuilder();
        while (c > 1) {
            f *= c;
            stringBuilder.append(c).append(" x ");
            c--;
        }
        stringBuilder.append(c);
        System.out.println(stringBuilder + " = " + f);
    }
}