import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point copy(){
        return new Point(x, y, z);
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void moveDown() {
        y -= Camera.MOVE.value;
    }

    public void moveUp() {
        y += Camera.MOVE.value;
    }

    public void moveRight() {
        x += Camera.MOVE.value;
    }

    public void moveLeft() {
        x -= Camera.MOVE.value;
    }

    public void moveForward() {
        z += Camera.MOVE.value;
    }

    public void moveBackward() {
        z -= Camera.MOVE.value;
    }

    public void rotateZ(double rotateAngle) {
        x = x * cos(rotateAngle) - y * sin(rotateAngle);
        y = x * sin(rotateAngle) + y * cos(rotateAngle);
    }

    public void rotateY(double rotateAngle) {
        x = x * cos(rotateAngle) - z * sin(rotateAngle);
        z = x * sin(rotateAngle) + z * cos(rotateAngle);
    }

    public void rotateX(double rotateAngle) {
        y = y * cos(rotateAngle) - z * sin(rotateAngle);
        z = y * sin(rotateAngle) + z * cos(rotateAngle);
    }
}
