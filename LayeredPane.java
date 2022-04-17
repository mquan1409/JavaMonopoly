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

public class LayeredPane extends JPanel implements ActionListener {
    private Board board;
    private JLayeredPane layeredPane;
    private JFrame frame;
    private int counter_test = 10;
    private Coord[] coord_p1;
    private PlayerGUI GUI_p1;
    public LayeredPane (
            Coord[] coord_p1, 
            Coord[] coord_p2, 
            Coord[] coord_p3, 
            Coord[] coord_p4){
        this.coord_p1 = coord_p1;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));
        board = new Board();
        //var label1 = new JLabel("Main Panel", SwingConstants.CENTER);
        var origin1 = new Point(0,0);
        //label1.setVerticalAlignment(JLabel.TOP);
        //label1.setHorizontalAlignment(JLabel.CENTER);
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
        counter_test ++;
        GUI_p1.setBounds(coord_p1[counter_test].x, coord_p1[counter_test].y, 140, 140);
        layeredPane.add(GUI_p1, 0);

        var button = new JButton("Click");
        button.addActionListener(this);
        button.setBounds(0, 80, 60, 60);
        layeredPane.add(button, 0);
        add(layeredPane);
    }
    // public void paintComponent(Graphics g){
    //     board.paintComponent(g);
    // }

    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        System.out.print(layeredPane.getComponentCountInLayer(0));
        System.out.println("Clicked");
        layeredPane.remove(GUI_p1);
        
        GUI_p1 = new PlayerGUI();
        GUI_p1.setOpaque(false);
        GUI_p1.setBackground(Color.PINK);
        GUI_p1.setForeground(Color.BLACK);
        GUI_p1.setBorder(null);
        counter_test ++;
        GUI_p1.setBounds(coord_p1[counter_test].x, coord_p1[counter_test].y, 140, 140);
        layeredPane.add(GUI_p1, 0);
        frame.repaint();
        frame.revalidate();
    }
}
