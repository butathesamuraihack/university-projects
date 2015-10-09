package PruebasEnJava;

public class Circle implements Shape{

    private final double PI = 3.1415;
    private double r;

    public Circle(){
        this.r=0.0;
    }

    public Circle(double r){
        this.r = r;
    }

    @Override
    public double area(){
        return PI * this.r * this.r;
    }

    @Override
    public double perimeter() {
        return PI * 2 * this.r;
    }
}
