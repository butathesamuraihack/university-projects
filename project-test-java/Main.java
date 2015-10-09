package PruebasEnJava;

import java.util.Scanner;

public class Main{

    public static void Circle(){

        Scanner input = new Scanner(System.in);
        Circle circle;
        System.out.print("Input Radius:");
        double r = input.nextDouble();
        circle = new Circle(r);
        System.out.println("Area of circle is:" + circle.area());
        System.out.println("Perimeter of circle is:" + circle.perimeter());

    }

    public static void Rectangle(){

        Scanner input = new Scanner(System.in);
        Rectangle rectangle;
        System.out.print("Input width:");
        double width = input.nextDouble();
        System.out.print("Input height:");
        double height = input.nextDouble();
        rectangle = new Rectangle(width,height);
        System.out.println("Area of rectangle is:" + rectangle.area());
        System.out.println("Perimeter of rectangle is:" + rectangle.perimeter());
    }

    public static void Triangle(){

        Scanner input = new Scanner(System.in);
        Triangle triangle;
        System.out.print("Input Side A:");
        double sideA = input.nextDouble();
        System.out.print("Input Side B:");
        double sideB = input.nextDouble();
        System.out.print("Input Base:");
        double sideC = input.nextDouble();
        triangle = new Triangle(sideA,sideB,sideC);
        System.out.println("Area of triangle is:" + triangle.area());
        System.out.println("Perimeter of triangle is:" + triangle.perimeter());
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String command;
        do{
            System.out.println("Enter command (circle | rectangle | triangle | exit)");
            command = input.nextLine().split(" ")[0];

            switch (command){
                case "circle":{
                    Circle();
                    break;
                }
                case "rectangle":{
                    Rectangle();
                    break;
                }
                case "triangle":{
                    Triangle();
                    break;
                }
                case "exit":{
                    System.exit(0);
                }
                default:{
                    System.out.println("Command error. Try again");
                }
            }
        }while(!command.equals("exit"));
    }
}