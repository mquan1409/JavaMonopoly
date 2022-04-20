import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

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
    private static JFrame frame;
    private static PlayerGUI[] player_guis;
    private static JButton roll_button;
    private static JButton buy_house_button;
    private static Player[] players;
    private BuyDialog buy_dialog;
    private static JLabel[] money_labels;
    private static PropertyContainerGUI[] property_containers;
    public static void AddHouse(Deed deed){
        if(deed.GetNumHouses() > 0){
            for(int i = 0; i < deed.GetNumHouses(); i ++){
                HouseGUI house_gui = new HouseGUI();
                house_gui.setOpaque(false);
                house_gui.setBackground(Color.PINK);
                house_gui.setBorder(null);
                if(deed.GetId()/10 == 0 || deed.GetId()/10 == 2)
                    house_gui.setBounds(deed.GetCoordHouse().x + (10*i), deed.GetCoordHouse().y, 8, 8);
                else if(deed.GetId()/10 == 1 || deed.GetId()/10 == 3)
                    house_gui.setBounds(deed.GetCoordHouse().x, deed.GetCoordHouse().y + (10*i), 8, 8);
                layeredPane.add(house_gui, 0);
            }
        }
    }
    public static void UpdateDataPanels(){
        Coord[] money_label_positions = {new Coord(0,0), new Coord(750,0), new Coord(750,600), new Coord(0,600)};
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
        for(int i = 0; i < 4; i ++){
            layeredPane.remove(property_containers[i]);
            property_containers[i] = new PropertyContainerGUI(player_guis[i].GetColor());
            ArrayList<Integer> id_deeds_owned = players[i].GetDeedsOwned();
            for(int j = 0; j < id_deeds_owned.size(); j ++){
                property_containers[i].AddProperty(Start.lands[id_deeds_owned.get(j)].GetDeed());           
            }
            property_containers[i].setOpaque(false);
            property_containers[i].setBorder(null);
            property_containers[i].setBounds(
                money_label_positions[i].x, 
                money_label_positions[i].y + 25, 
                200, 200);
            layeredPane.add(property_containers[i], 0);
        }
        roll_button.setEnabled(true);
        frame.repaint();
        frame.revalidate();
    }
    public LayeredPane (Player[] players){
        player_guis = new PlayerGUI[4];
        money_labels = new JLabel[4];
        property_containers = new PropertyContainerGUI[4];
        this.players = players;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 1000));
        board = new Board();
        board.setOpaque(true);
        board.setBackground(Color.BLUE);
        board.setForeground(Color.BLACK);
        board.setBorder(null);
        board.setBounds(200, 100, 1000, 1000);
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
        player_guis[0].SetColor(Color.GREEN);
        player_guis[1].SetColor(Color.RED);
        player_guis[2].SetColor(Color.BLUE);
        player_guis[3].SetColor(Color.GRAY);
        Coord[] money_label_positions = {new Coord(0,0), new Coord(750,0), new Coord(750,600), new Coord(0,600)};
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
        for(int i = 0; i < 4; i ++){
            property_containers[i] = new PropertyContainerGUI(player_guis[i].GetColor());
            property_containers[i].setOpaque(false);
            property_containers[i].setBorder(null);
            property_containers[i].setBounds(
                money_label_positions[i].x, 
                money_label_positions[i].y + 25, 
                200, 200);
            layeredPane.add(property_containers[i], 0);
        }

        roll_button = new JButton("Roll");
        roll_button.setActionCommand("Roll");
        roll_button.addActionListener(this);
        roll_button.setBounds(300, 50, 80, 25);
        layeredPane.add(roll_button, 0);

        buy_house_button = new JButton("Buy Houses");
        buy_house_button.setActionCommand("House");
        buy_house_button.addActionListener(this);
        buy_house_button.setBounds(400, 50, 80, 25);
        layeredPane.add(buy_house_button, 0);

        buy_dialog = new BuyDialog();
        buy_dialog.setOpaque(true);
        buy_dialog.setBackground(Color.PINK);
        buy_dialog.setBorder(null);
        buy_dialog.setBounds(250, 250, 150, 45);
        buy_dialog.setVisible(false);
        layeredPane.add(buy_dialog, 0);
        add(layeredPane);
    }
    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Roll"){
            int turn = Start.turn;
            Start.Play();
            // System.out.print(layeredPane.getComponentCountInLayer(0));
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
                roll_button.setEnabled(false);
            }
            if(Start.Rentable()){
                Start.Rent();
            }
            frame.repaint();
            frame.revalidate();
            if(!buyable)
                Start.NextTurn();
            //button.setEnabled(false);
        }
        else if(e.getActionCommand() == "House"){
            if(Start.CheckBuyHouseable()){
                System.out.println("Can Buy");
                System.out.println(Start.sets_buyhouseable.get(0));
                Start.BuyHouses();
            }
            // Deed deed = Start.lands[players[Start.turn].GetPosition()].GetDeed();
            // if(deed.GetNumHouses() > 0){
            //     var house_gui = new HouseGUI();
            //     house_gui.setOpaque(false);
            //     house_gui.setBackground(Color.PINK);
            //     house_gui.setBorder(null);
            //     house_gui.setBounds(deed.GetCoordHouse().x, deed.GetCoordHouse().y, 140, 140);
            //     layeredPane.add(house_gui);
            // }
        }
    }
}
