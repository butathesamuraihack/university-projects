package PruebasEnJava;


public class Triangle implements Shape{
    private double sideA,sideB,sideC;

    public Triangle(){

        this.sideA = 0.0;
        this.sideB = 0.0;
        this.sideC = 0.0;
    }

    public Triangle(double sideA, double sideB, double sideC){

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double baseHalf = this.sideC/2;
        double hypotenuse = this.sideA;
        double height = Math.sqrt((hypotenuse*hypotenuse)-(baseHalf*baseHalf));
        return (this.sideC*height)/2;
    }

    @Override
    public double perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
