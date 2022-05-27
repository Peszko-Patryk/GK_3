public class Vector {

    public final Point A;
    public final Point B;
    public double x;
    public double y;
    public double z;

    public Vector(Point point, Point point1) {
        A = point;
        B = point1;
        x = point1.getX() - point.getX();
        y = point1.getY() - point.getY();
        z = point1.getZ() - point.getZ();
    }

    public Vector(double x, double y, double z) {
        A = new Point(0, 0, 0);
        B = new Point(x, y, z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // iloczyn skalarny
    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    // iloczyn wektorowy
    public static Vector cross(Vector v1, Vector v2) {
        return new Vector((v1.y * v2.z - v1.z * v2.y), (v1.z * v2.x - v1.x * v2.z), (v1.x * v2.y - v1.y * v2.x));
    }

    public static Vector normalize(Vector v) {
        double magnitude = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);
        return new Vector((v.x / magnitude), (v.y / magnitude), (v.z / magnitude));
    }

    // cos miedzy wektorami
    public static double cos(Vector v1, Vector v2) {
        double v1Len = Math.sqrt(v1.x * v1.x + v1.y * v1.y + v1.z * v1.z);
        double v2Len = Math.sqrt(v2.x * v2.x + v2.y * v2.y + v2.z * v2.z);
        return dot(v1, v2) / (v1Len * v2Len);
    }

    public void update() {
        x = B.getX() - A.getX();
        y = B.getY() - A.getY();
        z = B.getZ() - A.getZ();
    }

    public static Vector getReboundVector(Vector n, Point light) {
        double t = -(n.x * light.getX() + n.y * light.getY() + n.z * light.getZ()) / (n.x * n.x + n.y * n.y + n.z * n.z);
        double newX = -(2 * (light.getX() + t * n.x) - light.getX());
        double newY = -(2 * (light.getY() + t * n.y) - light.getY());
        double newZ = -(2 * (light.getZ() + t * n.z) - light.getZ());
        return new Vector(newX, newY, newZ);
    }
}
