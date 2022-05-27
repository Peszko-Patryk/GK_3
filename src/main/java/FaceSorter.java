import java.util.ArrayList;
import java.util.Comparator;

public class FaceSorter implements Comparator<Face> {

    @Override
    public int compare(Face f1, Face f2) {
        return findWhichIsFirst(f1, f2, 1);
    }

    private int findWhichIsFirst(Face f1, Face f2, int truNumber) {
        if (truNumber == 3) {
            System.out.println("DUPA");
            double x1 = (f1.p1.getX() + f1.p2.getX() + f1.p3.getX()) / 3;
            double y1 = (f1.p1.getY() + f1.p2.getY() + f1.p3.getY()) / 3;
            double z1 = (f1.p1.getZ() + f1.p2.getZ() + f1.p3.getZ()) / 3;
            double x2 = (f2.p1.getX() + f2.p2.getX() + f2.p3.getX()) / 3;
            double y2 = (f2.p1.getY() + f2.p2.getY() + f2.p3.getY()) / 3;
            double z2 = (f2.p1.getZ() + f2.p2.getZ() + f2.p3.getZ()) / 3;
            double d1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2));
            double d2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2));
            return (int) (-d2 + d1);
        }
        Point p1 = f1.p1;
        Point p2 = f1.p2;
        Point p3 = f1.p3;

        double x = (p2.getY() - p1.getY()) * (p3.getZ() - p1.getZ()) - (p2.getZ() - p1.getZ()) * (p3.getY() - p1.getY());
        double y = (p2.getZ() - p1.getZ()) * (p3.getX() - p1.getX()) - (p2.getX() - p1.getX()) * (p3.getZ() - p1.getZ());
        double z = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
        double d = -x * p1.getX() - y * p1.getY() - z * p1.getZ();

        ArrayList<Point> pointsToCheck = new ArrayList<>();
        pointsToCheck.add(f2.p1);
        pointsToCheck.add(f2.p2);
        pointsToCheck.add(f2.p3);
        double result = 0;
        for (int i = 0; i < pointsToCheck.size(); i++) {
            Point point = pointsToCheck.get(i);
            double nextResult = point.getX() * x + point.getY() * y + point.getZ() * z + d;
            nextResult = Math.abs(nextResult) < Math.pow(10, -5) ? 0 : nextResult;
            if (result == 0 && nextResult != 0) {
                result = nextResult;
            } else if (nextResult * result < 0) {
                if (truNumber == 2) {
                    System.out.println("n1 = " + result + " n2 = " + nextResult);
                }
                return findWhichIsFirst(f2, f1, ++truNumber);
            }
        }
//        if (result == 0){
//            System.out.println("WARNING");
//        } else {
//            System.out.println(result);
//        }
        return (int) (-d * result);
    }
}
