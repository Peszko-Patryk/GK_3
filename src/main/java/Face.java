import java.awt.*;

import static java.lang.Math.tan;

public class Face {

    public final Point p1;
    public final Point p2;
    public final Point p3;
    private final Color BASE_COLOR = new Color(18, 240, 168);
    private Color lighteningColor;

    public Face(Point point, Point point1, Point point2) {
        p1 = point;
        p2 = point1;
        p3 = point2;
    }

    public void paint(Graphics g, int angle, Vector lightVector) {
        Polygon polygon = createPolygon(angle);
        updateColor(lightVector);
        g.setColor(lighteningColor);
        g.fillPolygon(polygon);
    }

    private void updateColor(Vector light) {
        Vector v1 = new Vector(p2, p1);
        Vector v2 = new Vector(p2, p3);
        Vector normal = Vector.normalize(Vector.cross(v1, v2));
        double dot = Vector.dot(normal, light);
        double cos = 0;
        if (dot > 0.15) {
            cos = Math.pow(Vector.cos(new Vector(p1, new Point(0, 0, 0)), Vector.getReboundVector(normal, light.B)), Light.N.value);
        }
        double lightRatio = Light.IP.value * (Light.KD.value * dot + Light.KS.value * cos) + Light.AMBIENT.value;
        lightRatio = Math.max(Light.MIN.value, Math.min(Light.MAX.value, lightRatio));
        lighteningColor = new Color((int) (BASE_COLOR.getRed() * lightRatio), (int) (BASE_COLOR.getGreen() * lightRatio)
                , (int) (BASE_COLOR.getBlue() * lightRatio));
    }

    private Polygon createPolygon(int angle) {
        Polygon polygon = new Polygon();
        if (Math.min(p1.getZ(), (Math.min(p2.getZ(), p3.getZ()))) > 0) {
            addPoint(polygon, p1, angle);
            addPoint(polygon, p2, angle);
            addPoint(polygon, p3, angle);
        }
        return polygon;
    }

    private void addPoint(Polygon polygon, Point point, int angle) {
        double tan = tan(Math.toRadians(angle / 2.0));
        int x = (int) ((500 * point.getX()) / (point.getZ() * tan)) + 500;
        int y = (int) -((500 * point.getY()) / (point.getZ() * tan)) + 350;
        polygon.addPoint(x, y);
    }
}
