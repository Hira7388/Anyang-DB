package mainSearchgui;

import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    public Image img;
    public ImagePanel(Image img) {
        this.img = img;
        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public Dimension getDim() {
        return new Dimension(img.getWidth(null) + 16, img.getHeight(null) + 39);
    }
}
