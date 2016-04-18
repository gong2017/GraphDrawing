/**
 * B. Postnikoff
 * Vector 
 * 2016-04-17
 */

public class Vector
{
    private double x;
    private double y;
    
    // Vector constructor
    public Vector()
    {
        x = 0;
        y = 0;
    }

    // Vector constructor
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Adds a vector to this vector
    public Vector add(Vector secondVector) {
        Vector addVector = new Vector();

        addVector.setX(x + secondVector.getX());
        addVector.setY(y + secondVector.getY());

        return addVector;
    }
    
    // Multiplies this vector by a scalar
    public Vector multiply(double scalar) {
        Vector multiplyVector = new Vector();

        multiplyVector.setX(x * scalar);
        multiplyVector.setY(y * scalar);

        return multiplyVector;
    }    

    // Substract a vector from this vector
    public Vector subtract(Vector secondVector) {
        Vector subtractVector = new Vector();

        subtractVector.setX(x - secondVector.getX());
        subtractVector.setY(y - secondVector.getY());

        return subtractVector;
    }   

    // Gets the length of the vector
    public double getLength() {
        double length;

        length = Math.sqrt((x * x) + (y * y));

        return length;
    }

    // Gets the unit vector of the vector
    public Vector getUnitVector() {
        Vector unitVector = new Vector();

        unitVector.setX(x / getLength());
        unitVector.setY(y / getLength());

        return unitVector;
    }

    // Gets the x of the vector
    public double getX() {
        return x;
    }

    // Sets the x of the vector
    public void setX(double newX) {
        x = newX;
    }

    // Gets the y of the vector
    public double getY() {
        return y;
    }

    // Sets the y of the vector
    public void setY(double newY) {
        y = newY;
    }
}
