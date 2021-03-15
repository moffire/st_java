package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        Square s = new Square(10);
        Rectangle r = new Rectangle(20, 30);
        Point p = new Point(3, -4, -6, 5);

        System.out.println(s.area());
        System.out.println(r.area());
        Rectangle.say_s();
        System.out.println(p.distance());
    }
}
