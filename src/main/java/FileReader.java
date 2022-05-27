import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private final ArrayList<Point> points;
    private final ArrayList<Face> faces;

    public FileReader(String path) {
        points = new ArrayList<>();
        faces = new ArrayList<>();
        readFile(path);
    }

    public void readFile(String path) {
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                extractDataFromLine(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file: " + path);
        }
    }

    private void extractDataFromLine(String nextLine) {
        String[] parts = nextLine.replace("//","").split(" ");
        switch (parts[0]){
            case "v":
                points.add(new Point(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]),Double.parseDouble(parts[3])));
                break;
            case "f":
                faces.add(new Face(points.get(Integer.parseInt(parts[1])-1), points.get(Integer.parseInt(parts[2])-1), points.get(Integer.parseInt(parts[3])-1)));
                break;
        }
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
