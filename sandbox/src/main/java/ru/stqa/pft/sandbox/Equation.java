package ru.stqa.pft.sandbox;

public class Equation {

    private double a;
    private double b;
    private double c;
    private int n;

    public int getN() {
        return n;
    }

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        double d = Math.pow(b, 2) - 4*a*c;

        if(d > 0) {
            n = 2;
        } else if (d < 0) {
            n = 0;
        } else {
            n = 1;
        }
    }
}
