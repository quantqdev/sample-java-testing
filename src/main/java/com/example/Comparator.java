package com.example;

public class Comparator {
    private final Basics basics;

    public Comparator(Basics basics) {
        this.basics = basics;
    }

    public String compare(int n1, int n2) {
        final int value = basics.compare(n1, n2);
        final String message = switch (value) {
            case 1 -> String.format("%o is greater than %o", n1, n2);
            case -1 -> String.format("%o is less than %o", n1, n2);
            default -> String.format("%o is equal to %o", n1, n2);
        };
        return message;
    }
}
