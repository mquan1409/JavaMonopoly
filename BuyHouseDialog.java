import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.*;

public class BuyHouseDialog extends JPanel implements ActionListener {
    public BuyHouseDialog(){
        //setVisible(false);
        var layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(150, 45));
        var message = new JLabel("Where do you want to buy?");
        var txt_input_position = new JTextArea();
        var btn_buy = new JButton("Buy");
        var btn_nope = new JButton("Nope");
        message.setVerticalAlignment(SwingConstants.TOP);
        message.setHorizontalAlignment(SwingConstants.LEFT);
        message.setOpaque(true);
        message.setBorder(null);
        message.setBackground(Color.PINK);
        message.setBounds(0, 0, 150, 20);
        btn_buy.setVerticalAlignment(SwingConstants.TOP);
        btn_buy.setHorizontalAlignment(SwingConstants.LEFT);
        btn_buy.setOpaque(true);
        btn_buy.setBorder(null);
        btn_buy.setBackground(Color.YELLOW);
        btn_buy.setBounds(0, 20, 75, 25);
        btn_buy.addActionListener(this);
        btn_buy.setActionCommand("buy");

        btn_nope.setVerticalAlignment(SwingConstants.TOP);
        btn_nope.setHorizontalAlignment(SwingConstants.LEFT);
        btn_nope.setOpaque(true);
        btn_nope.setBorder(null);
        btn_nope.setBackground(Color.GREEN);
        btn_nope.setBounds(75, 20, 75, 25);
        btn_nope.addActionListener(this);
        btn_nope.setActionCommand("nope");

        layeredPane.add(message,0);
        layeredPane.add(btn_buy,0);
        layeredPane.add(btn_nope,0);
        add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand() == "nope"){
            setVisible(false);
            Start.NextTurn();
            LayeredPane.UpdateDataPanels();
        }
        if(e.getActionCommand() == "buy"){
            Start.Buy();
            setVisible(false);
        }
    }
}
