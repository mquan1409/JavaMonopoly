import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class HotelGUI extends HouseGUI {
    private Color color = Color.RED;
    public void SetColor(Color color){
        this.color = color;
    }
    public Color GetColor(){
        return color;
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(color);
        g.drawRect(0,0,12,12);
        g.fillRect(0,0,12,12);
    }
}