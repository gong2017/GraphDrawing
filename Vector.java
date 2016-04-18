/**
 * B. Postnikoff
 * Vector 
 * 2016-04-17
 */

public class Vector
{
    private double x;
    private double y;
    
    public Vector()
    {
        x = 0;
        y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector secondVector) {
        Vector addVector = new Vector();

        addVector.setX(x + secondVector.getX());
        addVector.setY(y + secondVector.getY());

        return addVector;
    }

    public Vector subtract(Vector secondVector) {
        Vector subtractVector = new Vector();

        subtractVector.setX(x - secondVector.getX());
        subtractVector.setY(y - secondVector.getY());

        return subtractVector;
    }   

    public Vector multiply(double scalar) {
        Vector multiplyVector = new Vector();

        multiplyVector.setX(x * scalar);
        multiplyVector.setY(y * scalar);

        return multiplyVector;
    }

    public double getLength() {
        double length;

        length = Math.sqrt((x * x) + (y * y));

        return length;
    }

    public Vector getUnitVector() {
        Vector unitVector = new Vector();

        unitVector.setX(x / getLength());
        unitVector.setY(y / getLength());

        return unitVector;
    }

    public double getX() {
        return x;
    }

    public void setX(double newX) {
        x = newX;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {
        y = newY;
    }
}
