import java.util.Comparator;

public class FaceSorter implements Comparator<Face> {

    @Override
    public int compare(Face f1, Face f2) {
        return findWhichIsFirst(f1, f2);
    }

    private int findWhichIsFirst(Face f1, Face f2) {
        double x1 = (f1.p1.getX() + f1.p2.getX() + f1.p3.getX()) / 3;
        double y1 = (f1.p1.getY() + f1.p2.getY() + f1.p3.getY()) / 3;
        double z1 = (f1.p1.getZ() + f1.p2.getZ() + f1.p3.getZ()) / 3;
        double x2 = (f2.p1.getX() + f2.p2.getX() + f2.p3.getX()) / 3;
        double y2 = (f2.p1.getY() + f2.p2.getY() + f2.p3.getY()) / 3;
        double z2 = (f2.p1.getZ() + f2.p2.getZ() + f2.p3.getZ()) / 3;
        double d1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2));
        double d2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2));
        return (int) (d2 - d1);
    }
}
