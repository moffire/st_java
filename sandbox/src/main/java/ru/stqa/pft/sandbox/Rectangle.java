package ru.stqa.pft.sandbox;

public class Rectangle {
    public double side1;
    public double side2;

    public Rectangle(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }

    public double area(){
        return this.side1 * this.side2;
    }

    public static void say_s(){
        System.out.println("Статическая функия Прямоугольника");
    }
}
