package view.components;

import javax.swing.*;
import java.awt.*;

public class ToastMessage extends JFrame implements Runnable {

    // JWindow
    JWindow w;

    public static Thread operator;

    public ToastMessage(String s, boolean isPointed, int x, int y) {
        w = new JWindow();

        // make the background transparent
        w.setBackground(new Color(0, 0, 0, 0));

        // create a panel
        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                int wid = g.getFontMetrics().stringWidth(s);
                int hei = g.getFontMetrics().getHeight();

                // draw the boundary of the toast and fill it
                if (isPointed) {
                    g.setColor(new Color(0, 102, 102));
                    g.fillPolygon(new int[]{10, wid + wid / 2, wid + wid / 2, 10, 10, 0}
                            , new int[]{10, 10, hei + 20, hei + 20, 30, 20}, 6);
                    g.setColor(Color.black);
                    g.drawPolygon(new int[]{10, wid + wid / 2, wid + wid / 2, 10, 10, 0}
                            , new int[]{10, 10, hei + 20, hei + 20, 30, 20}, 6);

                } else {
                    g.setColor(new Color(0, 102, 102));
                    g.fillRect(10, 10, wid + wid / 2, hei + 10);
                    g.setColor(Color.black);
                    g.drawRect(10, 10, wid + wid / 2, hei + 10);
                }
                // set the color of text
                g.setColor(new Color(255, 255, 255, 240));
                g.drawString(s, wid / 8, 27);
                int t = 250;

                // draw the shadow of the toast
                if (isPointed) {
                    for (int i = 0; i < 4; i++) {
                        t -= 60;
                        g.setColor(new Color(0, 0, 0, t));
                        g.drawPolygon(new int[]{0, 10 - i, wid + wid / 2 + i, wid + wid / 2 + i, 10 - i, 10 - i}
                                , new int[]{20 - i, 10 - i, 10 - i, hei + 20 + i, hei + 20 + i, 30 + i}, 6);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        t -= 60;
                        g.setColor(new Color(0, 0, 0, t));
                        g.drawRect(10 - i, 10 - i, wid + wid / 2 + 2 * i, hei + 10 + 2 * i);
                    }
                }
            }
        };

        w.add(p);
        w.setLocation(x, y);
        w.setSize((int) (s.length() * 7), 100);
    }

    public ToastMessage(String s, int x, int y, int width, int height) {
        w = new JWindow();

        // make the background transparent
        w.setBackground(new Color(0, 0, 0, 0));

        // create a panel
        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                int wid = g.getFontMetrics().stringWidth(s);
                int hei = g.getFontMetrics().getHeight();

                // draw the boundary of the toast and fill it
                g.setColor(new Color(0, 102, 102));
                g.fillPolygon(new int[]{0, 10, 10}, new int[]{20, 10, 30}, 3);
                g.fillRect(10, 10, wid + 30, hei + 10);
                g.setColor(Color.black);
                g.drawPolygon(new int[]{0, 10, wid + 30, wid + 30, 10, 10}, new int[]{20, 10, 10, 10, hei + 20, hei + 20, 30}, 6);

                // set the color of text
                g.setColor(new Color(255, 255, 255, 240));
                g.drawString(s, 25, 27);
                int t = 250;

                // draw the shadow of the toast
                for (int i = 0; i < 4; i++) {
                    t -= 60;
                    g.setColor(new Color(0, 0, 0, t));
                    g.drawPolygon(new int[]{0, 10 - i, wid + 30 + i, wid + 30 + i, 10 - i, 10 - i}
                            , new int[]{20 - i, 10 - i, 10 - i, hei + 20 + i, hei + 20 + i, 30 + i}, 6);
                }
            }
        };

        w.add(p);
        w.setLocation(x, y);
        w.setSize(width, height);
    }

    // function to pop up the toast
    public void showToast() {
        if (operator != null) operator.interrupt();
        operator = new Thread(this);
        operator.start();
    }

    @Override
    public synchronized void run() {
        try {
            w.setOpacity(1);
            w.setVisible(true);

            // wait for some time
            Thread.sleep(1000);

            // make the message disappear slowly
            for (double d = 1.0; d > 0.2; d -= 0.05) {
                Thread.sleep(80);
                w.setOpacity((float) d);
            }

            // set the visibility to false
            w.setVisible(false);
        } catch (InterruptedException e) {
            w.setVisible(false);
        }
    }
}
