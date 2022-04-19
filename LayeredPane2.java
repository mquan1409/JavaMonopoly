import java.awt.Color;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;

public class LayeredPane2 extends JPanel implements ActionListener {
    private Board board;
    private JLayeredPane layeredPane;
    private JFrame frame;
    private PlayerGUI GUI_p1;
    private PlayerGUI GUI_p2;
    private PlayerGUI GUI_p3;
    private PlayerGUI GUI_p4;
    private JButton button;
    private Player[] players;
    public LayeredPane2 (Player[] players){
        this.players = players;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));
        board = new Board();
        var origin1 = new Point(0,0);
        board.setOpaque(true);
        board.setBackground(Color.BLUE);
        board.setForeground(Color.BLACK);
        board.setBorder(null);
        board.setBounds(origin1.x, origin1.y, 1000, 1000);
        layeredPane.add(board, 1);

        GUI_p1 = new PlayerGUI();
        GUI_p1.setOpaque(false);
        GUI_p1.setBackground(Color.PINK);
        GUI_p1.setForeground(Color.BLACK);
        GUI_p1.setBorder(null);
        GUI_p1.setBounds(
            players[0].GetCoordNow().x, 
            players[0].GetCoordNow().y, 
            140, 140);


        GUI_p3 = new PlayerGUI();
        GUI_p3.setOpaque(false);
        GUI_p3.setBackground(Color.PINK);
        GUI_p3.setForeground(Color.BLACK);
        GUI_p3.setBorder(null);
        GUI_p3.setBounds(
            players[2].GetCoordNow().x, 
            players[2].GetCoordNow().y, 
            140, 140);




            GUI_p2 = new PlayerGUI();
            GUI_p2.setOpaque(false);
            GUI_p2.setBackground(Color.PINK);
            GUI_p2.setForeground(Color.BLACK);
            GUI_p2.setBorder(null);
            GUI_p2.setBounds(
                players[1].GetCoordNow().x, 
                players[1].GetCoordNow().y, 
                140, 140);

            GUI_p4 = new PlayerGUI();
            GUI_p4.setOpaque(false);
            GUI_p4.setBackground(Color.PINK);
            GUI_p4.setForeground(Color.BLACK);
            GUI_p4.setBorder(null);
            GUI_p4.setBounds(
                players[3].GetCoordNow().x, 
                players[3].GetCoordNow().y, 
                140, 140);




        layeredPane.add(GUI_p1, 0);
        layeredPane.add(GUI_p2, 0);
        layeredPane.add(GUI_p3, 0);
        layeredPane.add(GUI_p4, 0);




        button = new JButton("Click");
        button.addActionListener(this);
        button.setBounds(0, 80, 60, 60);
        layeredPane.add(button, 0);
        add(layeredPane);
    }
    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        Start2.Test();
        System.out.print(layeredPane.getComponentCountInLayer(0));

        
        GUI_p1.setOpaque(false);
        GUI_p1.setBackground(Color.PINK);
        GUI_p1.setForeground(Color.BLACK);
        GUI_p1.setBorder(null);
        GUI_p1.setBounds(players[0].GetCoordNow().x, players[0].GetCoordNow().y, 140, 140);
        


        GUI_p2.setOpaque(false);
        GUI_p2.setBackground(Color.PINK);
        GUI_p2.setForeground(Color.BLACK);
        GUI_p2.setBorder(null);
        GUI_p2.setBounds(players[1].GetCoordNow().x, players[1].GetCoordNow().y, 140, 140);
        
        GUI_p3.setOpaque(false);
        GUI_p3.setBackground(Color.PINK);
        GUI_p3.setForeground(Color.BLACK);
        GUI_p3.setBorder(null);
        GUI_p3.setBounds(players[2].GetCoordNow().x, players[2].GetCoordNow().y, 140, 140);
        

        GUI_p4.setOpaque(false);
        GUI_p4.setBackground(Color.PINK);
        GUI_p4.setForeground(Color.BLACK);
        GUI_p4.setBorder(null);
        GUI_p4.setBounds(players[3].GetCoordNow().x, players[3].GetCoordNow().y, 140, 140);
        

        

        frame.repaint();
        frame.revalidate();
        //button.setEnabled(false);
    }
}
