package org.example.lm.tinnova.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise_1 {

    private static final BigDecimal totalVoters = BigDecimal.valueOf(1000.0);
    private static final BigDecimal valid = BigDecimal.valueOf(800);
    private static final BigDecimal whites = BigDecimal.valueOf(150);
    private static final BigDecimal nullVotes = BigDecimal.valueOf(50);

    public static void main(String[] args) {
        System.out.println("Percentual de votos VALIDOS: " + percentageOfValidVotes());
        System.out.println("Percentual de votos BRANCOS: " + percentageOfWhiteVotes());
        System.out.println("Percentual de votos NULOS: " + percentageOfNullVotes());
    }

    private static String percentageOfValidVotes() {
        return divide(valid);
    }

    private static String percentageOfWhiteVotes() {
        return divide(whites);
    }

    private static String percentageOfNullVotes() {
        return divide(nullVotes);
    }

    private static String divide(final BigDecimal value) {
        return value.divide(totalVoters, 2, RoundingMode.HALF_UP) + "%";
    }
}