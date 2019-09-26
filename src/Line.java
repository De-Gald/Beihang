import javax.swing.*;
import java.awt.*;


class Line extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Line());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    public synchronized void paintComponent(Graphics g) {
        int x1 = 0;
        int y1 = 0;
        int x2 = (int) 50;
        int y2 = (int) 200;

        g.drawLine(x1, y1, x2, y2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.drawLine(x2, y2, 60,60);

        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

            g.drawLine(x1, y1, x2, y2);

            long currentTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTime < 100)
                ;
            g.drawLine(x2, y2, 60,60);
        };
        Thread thread = new Thread(runnable);

        thread.start();
    }
}