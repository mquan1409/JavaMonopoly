import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PlayerGUI extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(255,0,0));
        g.drawRect(0,0,10,10);
        g.fillRect(0,0,10,10);
    }
}
