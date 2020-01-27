import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame
{
    private Cube cube;
    protected static int width = 1200;
    protected static int height = 800;

    Viewer(Cube c) {
        super("KYБ");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        cube = c;
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle s = this.getBounds();
        g.translate(s.width/2, s.height/2);
        //cube.draw(g2d);
        cube.perspdraw(g2d, 500);
    }
}
