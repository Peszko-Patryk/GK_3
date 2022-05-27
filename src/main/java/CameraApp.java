import javax.swing.*;
import java.util.ArrayList;

public class CameraApp {

    public static void main(String[] args) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        FileReader fr = new FileReader(args[0]);
        Observer observer = new Observer(0, 0, 0, fr.getFaces(), fr.getPoints());

        JFrame frame = new JFrame();
        Graphic graphic = new Graphic();
        graphic.setObserver(observer);
        frame.addKeyListener(new KeyOperations(observer));
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Camera App");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(graphic);
    }
}
