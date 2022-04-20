import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class HouseGUI extends JPanel {
    private Color color = Color.GREEN;
    public void SetColor(Color color){
        this.color = color;
    }
    public Color GetColor(){
        return color;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(0,0,8,8);
        g.fillRect(0,0,8,8);
    }
}
