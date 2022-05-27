import java.awt.*;
import java.util.ArrayList;

public class Observer extends Point {

    private final ArrayList<Face> faces;
    private final ArrayList<Point> points;
    private final Vector lightVector;
    private int angle = 90;

    public Observer(float x, float y, float z, ArrayList<Face> faces, ArrayList<Point> points) {
        super(x, y, z);
        this.faces = faces;
        this.points = points;
        lightVector = Vector.normalize(new Vector(new Point(0, 0, 0), new Point(-1, -2, 1)));
    }

    public void paint(Graphics g) {
        faces.sort(new FaceSorter());
        for (Face face : faces) {
            face.paint(g, angle, lightVector);
        }
    }

    public void linesDown() {
        for (Point point : points) {
            point.moveDown();
        }
    }

    public void linesUp() {
        for (Point point : points) {
            point.moveUp();
        }
    }

    public void linesRight() {
        for (Point point : points) {
            point.moveRight();
        }
    }

    public void linesLeft() {
        for (Point point : points) {
            point.moveLeft();
        }
    }

    public void linesBackward() {
        for (Point point : points) {
            point.moveBackward();
        }
    }

    public void linesForward() {
        for (Point point : points) {
            point.moveForward();
        }
    }

    public void turnLeftZ() {
        for (Point point : points) {
            point.rotateZ(Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateZ(Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void turnRightZ() {
        for (Point point : points) {
            point.rotateZ(-Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateZ(-Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void turnLeftY() {
        for (Point point : points) {
            point.rotateY(Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateY(Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void turnRightY() {
        for (Point point : points) {
            point.rotateY(-Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateY(-Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void turnUpX() {
        for (Point point : points) {
            point.rotateX(-Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateX(-Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void turnDownX() {
        for (Point point : points) {
            point.rotateX(Camera.ROTATE_DEGREE.value);
        }
        lightVector.B.rotateX(Camera.ROTATE_DEGREE.value);
        lightVector.update();
    }

    public void zoomOut() {
        if (angle < 150) {
            angle += 2;
        }
    }

    public void zoomIn() {
        if (angle > 20) {
            angle -= 2;
        }
    }
}