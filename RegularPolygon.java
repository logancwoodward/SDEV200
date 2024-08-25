/*
Logan Woodward Programming Assignment9.9
The following UML defines the class "RegularPolygon" and its constructors, accessors and mutators. 
The subsequent test program creates 3 different polygons and displays the perimeter and area of each.
*/
/*UML
-----------------------------------------------------------------
|   RegularPolygon                                              |
-----------------------------------------------------------------
| - n: int = 3                                                  |
| - side: double = 1                                            |
| - x: double = 0                                               |
| - y: double = 0                                               |
| - on: boolean                                                 |
| - radius: double                                              |
| - color: String                                               |
-----------------------------------------------------------------
| + RegularPolygon()                                            |
| + RegularPolygon(n: int, side: double)                        |
| + RegularPolygon(n: int, side: double, x: double, y: double)  |
| + getN(int)                                                   |
| + setN(n: int): void                                          |
| + getSide(): double                                           |
| + setSide(side: double): void                                 |
| + getX(): double                                              |
| + setX(x: double): void                                       |
| + getY(): double                                              |
| + setY(y: double): void                                       |
| + getPerimeter(): double                                      |
| + getArea(): double                                           |
-----------------------------------------------------------------
*/

public class RegularPolygon {
    // Data fields
    private int n = 3;            // Number of sides
    private double side = 1;     // Length of each side
    private double x = 0;        // x-coordinate of the center
    private double y = 0;        // y-coordinate of the center

    // No-arg constructor
    public RegularPolygon() {
    }

    // Constructor with specified number of sides and side length, centered at (0, 0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor with specified number of sides, side length, and center coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessor methods
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to calculate the perimeter of the polygon
    public double getPerimeter() {
        return n * side;
    }

    // Method to calculate the area of the polygon
    public double getArea() {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }

    // toString method for displaying the polygon information
    @Override
    public String toString() {
        return "RegularPolygon with " + n + " sides, side length " + side +
               ", centered at (" + x + ", " + y + ").";
    }

    // Test program
    public static void main(String[] args) {
        // Create three RegularPolygon objects
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display perimeter and area for each polygon
        System.out.println(polygon1);
        System.out.printf("Perimeter: %.2f\n", polygon1.getPerimeter());
        System.out.printf("Area: %.2f\n", polygon1.getArea());

        System.out.println(polygon2);
        System.out.printf("Perimeter: %.2f\n", polygon2.getPerimeter());
        System.out.printf("Area: %.2f\n", polygon2.getArea());

        System.out.println(polygon3);
        System.out.printf("Perimeter: %.2f\n", polygon3.getPerimeter());
        System.out.printf("Area: %.2f\n", polygon3.getArea());
    }
}
