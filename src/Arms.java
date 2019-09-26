import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Arms extends JPanel implements ActionListener {

    private static float[][] xy = new float[300][300];
    private static final int u = 3;
    private static Point point1, point2;
    private  int k1 = 1, k2 = 1;
    private static final int additionalPoint = 1;
    Timer timer = new Timer(100, this);
    int factor = 131069;
    boolean indicator = true;

    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Guess");
        frame.setBackground(Color.white);
        frame.setResizable(true);
        frame.setSize(650, 900);
        BufferedImage image = null;
        try {
            URL path = Arms.class.getResource("Logo.png");
            File f = new File(path.getFile());
            image = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 218; i++)
            for (int j = 0; j < 220; j++)
                xy[j][i] = (float) 1;
        for (int i = 0; i < 218; i++)
            for (int j = 0; j < 220; j++)
                xy[j][i] = (float) image.getRGB(i, j);
        frame.setVisible(true);
        Arms panel = new Arms();
        frame.add(panel);

        point1 = new Point();
        point2 = new Point();
    }

    public void fragment(Graphics g){
        if (xy[k1][k2] == -1)
            g.setColor(Color.RED);
        else
            g.setColor(Color.YELLOW);
        point1.x = point2.x;
        point1.y = point2.y;
    }


    public void a(int i, Graphics g) {
        if (i > 0) {
            d(i - 1, g);
            k2 += additionalPoint;
            fragment(g);
            point2.x += u;
            savePoint(point1, point2, g.getColor());
            a(i - 1, g);
            k1 += additionalPoint;
            fragment(g);
            point2.y += u;
            savePoint(point1, point2, g.getColor());
            a(i - 1, g);
             k2 -= additionalPoint;
            fragment(g);
            point2.x -= u;
            savePoint(point1, point2, g.getColor());
            c(i - 1, g);
        }
    }

    public void b(int i, Graphics g) {
        if (i > 0) {
            c(i - 1, g);
            k2 -= additionalPoint;
            fragment(g);
            point2.x -= u;
            savePoint(point1, point2, g.getColor());
            b(i - 1, g);
            k1 -= additionalPoint;
            fragment(g);
            point2.y -= u;
            savePoint(point1, point2, g.getColor());
            b(i - 1, g);
            k2 += additionalPoint;
            fragment(g);
            point2.x += u;
            savePoint(point1, point2, g.getColor());
            d(i - 1, g);
        }
    }

    public void c(int i, Graphics g) {
        if (i > 0) {
            b(i - 1, g);
            k1 -= additionalPoint;
            fragment(g);
            point2.y -= u;
            savePoint(point1, point2, g.getColor());
            c(i - 1, g);
            k2 -= additionalPoint;
            fragment(g);
            point2.x -= u;
            savePoint(point1, point2, g.getColor());
            c(i - 1, g);
            k1 += additionalPoint;
            fragment(g);
            point2.y += u;
            savePoint(point1, point2, g.getColor());
            a(i - 1, g);
        }
    }

    public void d(int i, Graphics g) {
        if (i > 0) {
            a(i - 1, g);
            k1 += additionalPoint;
            try {
                if (xy[k1][k2] == -1)
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.YELLOW);
            } catch (Exception e) {
                System.exit(1);
            }
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y += u;
            savePoint(point1, point2, g.getColor());
            d(i - 1, g);
            k2 += additionalPoint;
            fragment(g);
            point2.x += u;
            savePoint(point1, point2, g.getColor());
            d(i - 1, g);
            k1 -= additionalPoint;
            fragment(g);
            point2.y -= u;
            savePoint(point1, point2, g.getColor());
            b(i - 1, g);
        }
    }

    public void paintComponent(Graphics g) {
        if (indicator)
            a(8, g);
        for (int i = 0; i < points.size() - factor; i += 2) {
            g.setColor(colors.get(i / 2));
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
        timer.start();
    }

    void savePoint(Point point1, Point point2, Color color) {
        colors.add(color);
        points.add(new Point(point1.x, point1.y));
        points.add(new Point(point2.x, point2.y));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        indicator = false;
        if ((factor <= 131000) && (factor > 4)){
            timer.setDelay(1);
            factor -= 5;
            repaint();
            return;
        } else if (factor > 131000){
            factor -= 1;
            repaint();
            return;
        } else
            timer.stop();
    }
}
