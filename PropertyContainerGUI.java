import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

public class PropertyContainerGUI extends JPanel {
    private JLayeredPane layeredPane;
    private int offset_y_axis = 25;
    private Color color = Color.PINK;
    public void AddProperty(Deed deed){
        var message = new JLabel("Id: ".concat(String.valueOf(deed.GetId())).concat(" ").concat(deed.GetName()));
        message.setVerticalAlignment(SwingConstants.TOP);
        message.setHorizontalAlignment(SwingConstants.LEFT);
        message.setOpaque(true);
        message.setBorder(null);
        message.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 125));
        message.setBounds(0, 0 + offset_y_axis, 200, 20);
        offset_y_axis += 25;
        layeredPane.add(message,0);
    }
    public PropertyContainerGUI(Color color){
        this.color = color;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(200, 200));
        var message = new JLabel("Properties: ");
        message.setVerticalAlignment(SwingConstants.TOP);
        message.setHorizontalAlignment(SwingConstants.LEFT);
        message.setOpaque(true);
        message.setBorder(null);
        message.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 125));
        message.setBounds(0, 0, 200, 20);
        layeredPane.add(message,0);
        add(layeredPane);
    }
}
