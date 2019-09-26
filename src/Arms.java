import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Arms extends JPanel {

    static float[][] xy = new float[300][300];
    int u = 3;
    Point point1, point2;
    int k1 = 1, k2 = 1;
    int additionalPoint = 1;

    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Color> colors = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Shall the show begin!!!");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Guess");
        frame.setBackground(Color.white);
        frame.setSize(1000, 1200);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("/Users/vladislav.de-gald/Documents/DrawLine/Logo.png"));
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


    }


    public void a(int i, Graphics g) {
        if (i > 0) {
            d(i - 1, g);
            k2 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x += u;
            draw(point1, point2, g.getColor());
            a(i - 1, g);
            k1 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y += u;
            draw(point1, point2, g.getColor());
            a(i - 1, g);
            k2 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x -= u;
            draw(point1, point2, g.getColor());
            c(i - 1, g);
        }
    }

    public void b(int i, Graphics g) {
        if (i > 0) {
            c(i - 1, g);
            k2 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x -= u;
            draw(point1, point2, g.getColor());
            b(i - 1, g);
            k1 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y -= u;
            draw(point1, point2, g.getColor());
            b(i - 1, g);
            k2 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x += u;
            draw(point1, point2, g.getColor());
            d(i - 1, g);
        }
    }

    public void c(int i, Graphics g) {
        if (i > 0) {
            b(i - 1, g);
            k1 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y -= u;
            draw(point1, point2, g.getColor());
            c(i - 1, g);
            k2 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x -= u;
            draw(point1, point2, g.getColor());
            c(i - 1, g);
            k1 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y += u;
            draw(point1, point2, g.getColor());
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
            draw(point1, point2, g.getColor());
            d(i - 1, g);
            k2 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x += u;
            draw(point1, point2, g.getColor());
            d(i - 1, g);
            k1 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y -= u;
            draw(point1, point2, g.getColor());
            b(i - 1, g);
        }
    }

    public void paintComponent(Graphics g) {
        point1 = new Point();
        point2 = new Point();
        point1.x = 20;
        point1.y = 20;
        point2.x = 20;
        point2.y = 20;
        a(8, g);
        System.out.println(points.size());
        for (int i = 0; i < points.size(); i += 2) {
            g.setColor(colors.get(i / 2));
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
    }

    void draw(Point point1, Point point2, Color color){
        colors.add(color);
        points.add(new Point(point1.x, point1.y));
        points.add(new Point(point2.x, point2.y));
    }
}
