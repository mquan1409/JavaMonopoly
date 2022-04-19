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
    private int counter_test = 0;
    private int[] player_positions;
    private Coord[] coords_p1;
    private Coord[] coords_p2;
    private Coord[] coords_p3;
    private Coord[] coords_p4;
    private PlayerGUI GUI_p1;
    private Coord[] coords_test_player;
    private JButton button;
    public LayeredPane (int[] player_positions){
        this.player_positions = player_positions;
        coords_p1 = new Coord[41];
        coords_p2 = new Coord[41];
        coords_p3 = new Coord[41];
        coords_p4 = new Coord[41];

        int x=24;
        int y=30;

        //Row 1
        for(int i=1; i<11; i++)
            coords_p4[i] = new Coord(520 - (x+45*i+5), y+10+450);
        for(int i=1; i<11; i++)
            coords_p2[i] = new Coord(520 - (x+45*i+5), y+450+15+10);
        for(int i=1; i<11; i++)
            coords_p3[i] = new Coord(520 - (x+45*i+15+5), y+450+10);
        for(int i=1; i<11; i++)
            coords_p1[i] = new Coord(520 - (x+45*i+15+5), y+450+15+10);

        //Row 2
        for(int i=1; i<11; i++)
            coords_p1[10 + i] = new Coord(x-5, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            coords_p2[10 + i] = new Coord(x+10, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            coords_p3[10 + i] = new Coord(x-5, 525 - (y+45*i+15));
        for(int i=1; i<11; i++)
            coords_p4[10 + i] = new Coord(x+10, 525 - (y+45*i+15));

        //Row 3
        for(int i=1; i<11; i++)
            coords_p3[20 + i] = new Coord(x+45*i, y);
        for(int i=1; i<11; i++)
            coords_p4[20 + i] = new Coord(x+45*i+15, y);
        for(int i=1; i<11; i++)
            coords_p1[20 + i] = new Coord(x+45*i, y+15);
        for(int i=1; i<11; i++)
            coords_p2[20 + i] = new Coord(x+45*i+15, y+15);

        //Row 4
        for(int i=1; i<11; i++)
            coords_p3[30 + i] = new Coord(x+455, y+45*i);
        for(int i=1; i<11; i++)
            coords_p4[30 + i] = new Coord(x+455+15, y+45*i);
        for(int i=1; i<11; i++)
            coords_p1[30 + i] = new Coord(x+455, y+45*i+15);
        for(int i=1; i<11; i++)
            coords_p2[30 + i] = new Coord(x+455+15, y+45*i+15);

        coords_p1[0] = coords_p1[40];
        coords_p2[0] = coords_p2[40];
        coords_p3[0] = coords_p3[40];
        coords_p4[0] = coords_p4[40];

        coords_test_player = coords_p4;   //switch the testing player here

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
        GUI_p1.setBounds(
            coords_test_player[player_positions[0]].x, 
            coords_test_player[player_positions[0]].y, 
            140, 140);
        layeredPane.add(GUI_p1, 0);

        button = new JButton("Click");
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
        Start.Test();
        counter_test ++;
        System.out.print(layeredPane.getComponentCountInLayer(0));
        System.out.println("Clicked");
        layeredPane.remove(GUI_p1);
        
        GUI_p1 = new PlayerGUI();
        GUI_p1.setOpaque(false);
        GUI_p1.setBackground(Color.PINK);
        GUI_p1.setForeground(Color.BLACK);
        GUI_p1.setBorder(null);
        GUI_p1.setBounds(coords_test_player[player_positions[0]].x, coords_test_player[player_positions[0]].y, 140, 140);
        
        layeredPane.add(GUI_p1, 0);
        frame.repaint();
        frame.revalidate();
        //button.setEnabled(false);
    }
}
