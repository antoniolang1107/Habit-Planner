import java.awt.*;
import javax.swing.JFrame;

public class MyCanvas extends Canvas
{
    public void paint(Graphics g)
    {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("SmallTree.jpg");
        g.drawImage(i, 0, 0, this);
    }
    
    public static void main(String[] args)
    {
        MyCanvas m = new MyCanvas();
        JFrame frame = new JFrame("Hello Image?");
        frame.add(m);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}