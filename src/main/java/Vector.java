public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector(Point point, Point point1) {
        x = point1.getX() - point.getX();
        y = point1.getY() - point.getY();
        z = point1.getZ() - point.getZ();
    }

    // iloczyn skalarny
    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    // iloczyn wektorowy
    public static Vector cross(Vector v1, Vector v2) {
        return new Vector(new Point(0, 0, 0), new Point((float) (v1.y * v2.z - v1.z * v2.y),
                (float) (v1.z * v2.x - v1.x * v2.z), (float) (v1.x * v2.y - v1.y * v2.x)));
    }

    public static Vector normalize(Vector v) {
        double magnitude = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);
        return new Vector(new Point(0, 0, 0), new Point((float) (v.x / magnitude), (float) (v.y / magnitude), (float) (v.z / magnitude)));
    }

    // cos miedzy wektorami
    public static double cos(Vector v1, Vector v2) {
        double v1Len = Math.sqrt(v1.x * v1.x + v1.y * v1.y + v1.z * v1.z);
        double v2Len = Math.sqrt(v2.x * v2.x + v2.y * v2.y + v2.z * v2.z);
        return dot(v1, v2) / (v1Len * v2Len);
    }

    public static Vector getMirrorVector(Vector vector, Vector mirror) {
        double xVec = 2 * mirror.x + vector.x;
        double yVec = 2 * mirror.y + vector.y;
        double zVec = 2 * mirror.z + vector.z;
        return new Vector(new Point(0, 0, 0), new Point(xVec, yVec, zVec));
    }
}
