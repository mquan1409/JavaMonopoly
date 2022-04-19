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
    private static JLayeredPane layeredPane;
    private JFrame frame;
    private PlayerGUI[] player_guis;
    private JButton button;
    private static Player[] players;
    private BuyDialog buy_dialog;
    private static JLabel[] money_labels;
    public static void UpdateMoneyPanels(){
        Coord[] money_label_positions = {new Coord(0,0), new Coord(600,0), new Coord(600,600), new Coord(0,600)};
        for(int i = 0; i < 4; i ++){
            layeredPane.remove(money_labels[i]);
            money_labels[i] = new JLabel(
                "Player ".concat(String.valueOf(i + 1)).concat(": ").concat(String.valueOf(players[i].GetMoneyOwned())));
            money_labels[i].setOpaque(false);
            money_labels[i].setBackground(Color.PINK);
            money_labels[i].setBorder(null);
            money_labels[i].setBounds(
                money_label_positions[i].x, 
                money_label_positions[i].y, 
                100, 20);
            layeredPane.add(money_labels[i], 0);
        }
    }
    public LayeredPane (Player[] players){
        player_guis = new PlayerGUI[4];
        money_labels = new JLabel[4];
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
        for(int i = 0; i < 4; i ++){
            player_guis[i] = new PlayerGUI();
            player_guis[i].setOpaque(false);
            player_guis[i].setBackground(Color.PINK);
            player_guis[i].setBorder(null);
            player_guis[i].setBounds(
                players[i].GetCoordNow().x, 
                players[i].GetCoordNow().y, 
                140, 140);
            layeredPane.add(player_guis[i], 0);
        }
        Coord[] money_label_positions = {new Coord(0,0), new Coord(600,0), new Coord(600,600), new Coord(0,600)};
        for(int i = 0; i < 4; i ++){
            money_labels[i] = new JLabel(
                "Player ".concat(String.valueOf(i + 1)).concat(": ").concat(String.valueOf(players[i].GetMoneyOwned())));
            money_labels[i].setOpaque(false);
            money_labels[i].setBackground(Color.PINK);
            money_labels[i].setBorder(null);
            money_labels[i].setBounds(
                money_label_positions[i].x, 
                money_label_positions[i].y, 
                100, 20);
            layeredPane.add(money_labels[i], 0);
        }

        button = new JButton("Click");
        button.addActionListener(this);
        button.setBounds(0, 80, 60, 60);
        layeredPane.add(button, 0);

        buy_dialog = new BuyDialog();
        buy_dialog.setOpaque(true);
        buy_dialog.setBackground(Color.PINK);
        buy_dialog.setBorder(null);
        buy_dialog.setBounds(250, 250, 150, 45);
        buy_dialog.setVisible(false);
        layeredPane.add(buy_dialog, 0);
        add(layeredPane);
        
        player_guis[0].SetColor(Color.GREEN);
        player_guis[1].SetColor(Color.RED);
        player_guis[2].SetColor(Color.BLUE);
        player_guis[3].SetColor(Color.GRAY);
        
    }
    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        int turn = Start.turn;
        Start.Test();
        System.out.print(layeredPane.getComponentCountInLayer(0));
        layeredPane.remove(player_guis[turn]);
        
        player_guis[turn] = new PlayerGUI();
        player_guis[turn].setOpaque(false);
        player_guis[turn].setBackground(Color.PINK);

        player_guis[0].SetColor(Color.GREEN);
        player_guis[1].SetColor(Color.RED);
        player_guis[2].SetColor(Color.BLUE);
        player_guis[3].SetColor(Color.GRAY);

        player_guis[turn].setBorder(null);
        player_guis[turn].setBounds(players[turn].GetCoordNow().x, players[turn].GetCoordNow().y, 140, 140);
        
        layeredPane.add(player_guis[turn], 0);
        boolean buyable = Start.CheckBuyable();
        if(buyable){
            buy_dialog.setVisible(true);
        }
        frame.repaint();
        frame.revalidate();
        if(!buyable)
            Start.NextTurn();
        //button.setEnabled(false);
    }
}
