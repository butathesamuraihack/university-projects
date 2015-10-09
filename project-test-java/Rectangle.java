package PruebasEnJava;

public class Rectangle implements Shape{

    private double width,height;

    public Rectangle(){

        this.width = 0.0;
        this.height = 0.0;
    }

    public Rectangle(double width,double height){

        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {

        return this.width * this.height;
    }

    @Override
    public double perimeter() {
        return 2*(this.width+this.height);
    }
}
