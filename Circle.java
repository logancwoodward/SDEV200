/*13.9 (ENABLE CIRCLE COMPARABLE) 
Rewrite the Circle class in Listing 13.2 to extend GeometricObject and implement the Comparable interface. 
Override the equals method in the Object class. 
Two Circle objects are equal if their radii are the same. 
Draw the UML diagram that involves Circle, GeometricObject, and Comparable.

 ___________________________________________________
|           GeometricObject                         |
|---------------------------------------------------|
| - color: String                                   |
| - filled: boolean                                 |
|---------------------------------------------------|
| + GeometricObject()                               |
| + GeometricObject(color: String, filled: boolean) |
| + getColor(): String                              |
| + setColor(color: String): void                   |
| + isFilled(): boolean                             | 
| + setFilled(filled: boolean): void                |
| + getArea(): double                               |
| + getPerimeter(): double                          |
 ---------------------------------------------------
         ^
         |
 ___________________________________________________________
|           Circle                                          |
 -----------------------------------------------------------|
| - radius: double                                          |
|-----------------------------------------------------------|
| + Circle()                                                |
| + Circle(radius: double)                                  |
| + Circle(radius: double, color: String, filled: boolean)  |
| + getRadius(): double                                     |
| + setRadius(radius: double): void                         |
| + getArea(): double                                       |
| + getPerimeter(): double                                  |
| + equals(obj: Object): boolean                            |
| + hashCode(): int                                         |
| + compareTo(other: Circle): int                           |
 -----------------------------------------------------------
         ^
         |

 _________________________________
|           Comparable<Circle>    |
|---------------------------------|
| + compareTo(other: Circle): int |
 --------------------------------- 
*/

import java.util.Objects;

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    //default constructor
    public Circle() {
        super();  // Calls the default constructor of GeometricObject
        this.radius = 1.0;
    }

    //construct a Circle with specified radius
    public Circle(double radius) {
        super();  // Calls the default constructor of GeometricObject
        this.radius = radius;
    }

    //construct a Circle with specified radius, color, and filled status
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);  // Calls the parameterized constructor of GeometricObject
        this.radius = radius;
    }

    //getter method for radius
    public double getRadius() {
        return radius;
    }

    //setter method for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //implementation of abstract method getArea
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //implementation of abstract method getPerimeter
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //override equals method to compare Circle objects by radius
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }

    //override hashCode to be consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    //implementation of compareTo method from Comparable interface
    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }
}
