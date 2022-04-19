import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PlayerGUI extends JPanel {
    private Color color = Color.RED;
    public void SetColor(Color color){
        this.color = color;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(0,0,10,10);
        g.fillRect(0,0,10,10);
    }
}
