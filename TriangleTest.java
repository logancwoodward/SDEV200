import java.util.Scanner;
/*Program name: TriangleTest.Java
Author: Logan Woodward 
The program defines the Triangle class as and extension of the GeometricObject class.
The user is prompted for the lengths of each triangle side, the triangle color and whether or not the color is filled.
The program then returns the value of the perimeter and area of the triange, as well as restating the color and fill.*/

//  __________________________________________________________
// |  + Triangle                                              |
// | ---------------------------------------------------------|
// | - side1: double                                          |
// | - side2: double                                          |
// | - side3: double                                          |
// | ---------------------------------------------------------|
// | + Triangle()                                             |
// | + Triangle(side1: double, side2: double, side3: double)  |
// | + getSide1()                                             |
// | + getSide2()                                             |
// | + getSide3()                                             |
// | + getArea()                                              |
// | + getPerimeter()                                         |
// | + toString()                                             |

//  ____________________________________________________
// |  + GeometricObject                                 |
// | ---------------------------------------------------|
// | - color: String                                    |
// | - fillled: Boolean                                 |
// | ---------------------------------------------------|
// | + GeometricObject()                                |
// | + GeometricObject(color: String, filled: Boolean)  |
// | + getColor()                                       |
// | + setColor()                                       |
// | + isFilled()                                       |
// | + setFilled()                                      |
// | + getArea()                                        |
// | + getPerimeter                                     |

  // GeometricObject.java: The abstract GeometricObject class
abstract class GeometricObject {
  private String color = "white";
  private boolean filled;

  /**Default construct*/
  protected GeometricObject() {
  }

  /**Construct a geometric object*/
  protected GeometricObject(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  /**Getter method for color*/
  public String getColor() {
    return color;
  }

  /**Setter method for color*/
  public void setColor(String color) {
    this.color = color;
  }

  /**Getter method for filled. Since filled is boolean,
     so, the get method name is isFilled*/
  public boolean isFilled() {
    return filled;
  }

  /**Setter method for filled*/
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**Abstract method findArea*/
  public abstract double getArea();

  /**Abstract method getPerimeter*/
  public abstract double getPerimeter();
}




class Triangle extends GeometricObject {
  //Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of a triangle.
  private double side1 = 1.0;
  private double side2 = 1.0;
  private double side3 = 1.0;

  //A no-arg constructor that creates a default triangle.
  public Triangle() {
  }

  //A constructor that creates a triangle with the specified side1, side2, and side3.
  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  //The accessor methods for all three data fields.
  public double getSide1() {
    return side1;
  }
  public double getSide2() {
    return side2;
  }
  public double getSide3() {
    return side3;
  }
  public double setSide1(double side1) {
    return side1;
  }
  public double setSide2(double side2) {
    return side2;
  }
  public double setSide3(double side3) {
    return side3;
  }

  //A method named getArea() that returns the area of this triangle.
  @Override
  public double getArea() {
    double s = (side1 + side2 + side3) / 2;
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }

  //A method named getPerimeter() that returns the perimeter of this triangle.
  @Override
  public double getPerimeter() {
    return side1 + side2 + side3;
  }
  
  //A method named toString() that returns a string description for the triangle.
  @Override
  public String toString() {
    return "Triangle side1 =" + side1 + " side2 = " + side2 + " side 3 = " + side3 + " | " +super.toString();
  }
} 

/*Write a test program that prompts the user to enter three sides of the triangle, a color, and a Boolean value to indicate whether the triangle is filled. 
The program should create a Triangle object with these sides and set the color and filled properties using the input. 
The program should display the area, perimeter, color, and true or false to indicate whether it is filled or not.*/

public class TriangleTest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //User prompt for triangle sides
    System.out.print("Enter side1: ");
    double side1 = scanner.nextDouble();
    System.out.print("Enter side2: ");
    double side2 = scanner.nextDouble();
    System.out.print("Enter side3: ");
    double side3 = scanner.nextDouble();

    //User prompt for color and fill
    System.out.print("Enter color: ");
    String color = scanner.next();
    System.out.print("Is the triangle filled (true/false)? ");
    boolean filled = scanner.nextBoolean();

    //Create new triangle
    Triangle triangle = new Triangle(side1, side2, side3);
    triangle.setColor(color);
    triangle.setFilled(filled);


    System.out.println("Area: " + triangle.getArea());
    System.out.println("Perimeter: " + triangle.getPerimeter());
    System.out.println("Color: " + triangle.getColor());
    System.out.println("Fill: " + triangle.isFilled());
    System.out.println(triangle);
  }
}
