import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Arms extends JPanel {

    static float[][] xy = new float[300][300];
    int u = 3;
    Point point1, point2;
    int k1 = 1, k2 = 1;
    int additionalPoint = 1;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

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
            draw(point1.x, point1.y, point2.x, point2.y, g);
            a(i - 1, g);
            k1 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y += u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
            a(i - 1, g);
            k2 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x -= u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
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
            draw(point1.x, point1.y, point2.x, point2.y, g);
            b(i - 1, g);
            k1 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y -= u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
            b(i - 1, g);
            k2 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x += u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
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
            draw(point1.x, point1.y, point2.x, point2.y, g);
            c(i - 1, g);
            k2 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x -= u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
            c(i - 1, g);
            k1 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y += u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
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
            draw(point1.x, point1.y, point2.x, point2.y, g);
            d(i - 1, g);
            k2 += additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.x += u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
            d(i - 1, g);
            k1 -= additionalPoint;
            if (xy[k1][k2] == -1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            point1.x = point2.x;
            point1.y = point2.y;
            point2.y -= u;
            draw(point1.x, point1.y, point2.x, point2.y, g);
            b(i - 1, g);
        }
    }

    Graphics graphics;
    public void paintComponent(Graphics g) {
        point1 = new Point();
        point2 = new Point();
        point1.x = 20;
        point1.y = 20;
        point2.x = 20;
        point2.y = 20;
        graphics = g;
        a(8, g);
    }
    int count = 0;

//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    };


    void draw(int x1, int y1, int x2, int y2, Graphics g){
        g.drawLine(x1, y1, x2, y2);
        long currentTime = System.currentTimeMillis();
//        System.out.println(count++);
//        while (System.currentTimeMillis() - currentTime < 100);
    }
}
