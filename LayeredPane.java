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
    private static JButton sell_house_button;
    private static Player[] players;
    public static BuyDialog buy_dialog;
    private PayJail pay_dialog;
    private static JLabel[] money_labels;
    private static PropertyContainerGUI[] property_containers;
    private static Coord[] label_positions = {new Coord(0,0), new Coord(870,0), new Coord(870,600), new Coord(0,600)};
    private static TurnLabel turn_label;
    public static void UpdateHouses(Deed deed){
        if(deed.GetNumHouses() >= 0){
            //clean old houses
            ArrayList<HouseGUI> old_house_guis = deed.GetHouseGUIs();
            for(int i = 0; i < old_house_guis.size(); i ++){
                layeredPane.remove(old_house_guis.get(i));
            }
            UpdateDataPanels();
            ArrayList<HouseGUI> new_house_guis = deed.UpdateHouseGUIs();
            for(int i = 0; i < new_house_guis.size(); i ++){
                layeredPane.add(new_house_guis.get(i), 0);
            }
        }
    }
    public static void UpdateDataPanels(){
        for(int i = 0; i < 4; i ++){
            layeredPane.remove(money_labels[i]);
            money_labels[i] = new JLabel(
                "Player ".concat(String.valueOf(i + 1)).concat(": ").concat(String.valueOf(players[i].GetMoneyOwned())));
            money_labels[i].setOpaque(false);
            money_labels[i].setBackground(Color.PINK);
            money_labels[i].setBorder(null);
            money_labels[i].setBounds(
                label_positions[i].x, 
                label_positions[i].y, 
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
                label_positions[i].x, 
                label_positions[i].y + 25, 
                200, 200);
            layeredPane.add(property_containers[i], 0);
        }
        int turn = Start.turn;
        layeredPane.remove(turn_label);
            
        turn_label = new TurnLabel();
        turn_label.setOpaque(false);

        turn_label.setBorder(null);
        turn_label.setBounds(label_positions[turn].x + 185, label_positions[turn].y + 5, 12, 12);
        
        layeredPane.add(turn_label, 0);
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
        layeredPane.setPreferredSize(new Dimension(1200, 1050));
        board = new Board();
        board.setOpaque(true);
        board.setBackground(Color.BLUE);
        board.setForeground(Color.BLACK);
        board.setBorder(null);
        board.setBounds(200, 20, 1200, 1050);
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
        Coord[] label_positions = {new Coord(0,0), new Coord(870,0), new Coord(870,600), new Coord(0,600)};
        for(int i = 0; i < 4; i ++){
            money_labels[i] = new JLabel(
                "Player ".concat(String.valueOf(i + 1)).concat(": ").concat(String.valueOf(players[i].GetMoneyOwned())));
            money_labels[i].setOpaque(false);
            money_labels[i].setBackground(Color.PINK);
            money_labels[i].setBorder(null);
            money_labels[i].setBounds(
                label_positions[i].x, 
                label_positions[i].y, 
                100, 20);
            layeredPane.add(money_labels[i], 0);
        }
        for(int i = 0; i < 4; i ++){
            property_containers[i] = new PropertyContainerGUI(player_guis[i].GetColor());
            property_containers[i].setOpaque(false);
            property_containers[i].setBorder(null);
            property_containers[i].setBounds(
                label_positions[i].x, 
                label_positions[i].y + 25, 
                200, 200);
            layeredPane.add(property_containers[i], 0);
        }

        int turn = 0;

        turn_label = new TurnLabel();
        turn_label.setOpaque(true);
        turn_label.setBackground(Color.PINK);
        turn_label.setBorder(null);
        turn_label.setBounds((label_positions[turn].x + 185), label_positions[turn].y + 5, 12, 12);
        layeredPane.add(turn_label, 0);

        roll_button = new JButton("Roll");
        roll_button.setActionCommand("Roll");
        roll_button.addActionListener(this);
        roll_button.setBounds(300, 5, 80, 25);
        layeredPane.add(roll_button, 0);

        buy_house_button = new JButton("Buy Houses");
        buy_house_button.setActionCommand("Buy House");
        buy_house_button.addActionListener(this);
        buy_house_button.setBounds(400, 5, 150, 25);
        layeredPane.add(buy_house_button, 0);

        sell_house_button = new JButton("Sell Houses");
        sell_house_button.setActionCommand("Sell House");
        sell_house_button.addActionListener(this);
        sell_house_button.setBounds(600, 5, 150, 25);
        layeredPane.add(sell_house_button, 0);

        buy_dialog = new BuyDialog();
        buy_dialog.setOpaque(true);
        buy_dialog.setBackground(Color.PINK);
        buy_dialog.setBorder(null);
        buy_dialog.setBounds(480, 300, 150, 45);
        buy_dialog.setVisible(false);
        layeredPane.add(buy_dialog, 0);

        pay_dialog = new PayJail();
        pay_dialog.setOpaque(true);
        pay_dialog.setBackground(Color.PINK);
        pay_dialog.setBorder(null);
        pay_dialog.setBounds(250, 250, 150, 45);
        pay_dialog.setVisible(false);
        layeredPane.add(pay_dialog, 0);
        add(layeredPane);
    }
    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public static void PlayerGUIsMove(){
        int turn = Start.turn;
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
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Roll"){
            int turn = Start.turn;
            Start.Play();
            PlayerGUIsMove();
            Start.CheckSpecialLands();
            boolean buyable = Start.CheckBuyable();
            if(players[turn].getjail())
            {
                pay_dialog.setVisible(true);
                roll_button.setEnabled(false);
            }    
            if(buyable){
                buy_dialog.setVisible(true);
                roll_button.setEnabled(false);
            }
            if(Start.Rentable()){
                Start.Rent();
            }
            for(int i=0; i<4; i++)
            {
                
                if(players[i].GetMoneyOwned()>=2500)
                {
                    int temp=i+1;
                System.out.println("The winner is player: "+temp);
                roll_button.setEnabled(false);
                }
            }
            frame.repaint();
            frame.revalidate();
            if(!buyable&&!players[turn].getjail())
                Start.NextTurn();
            UpdateDataPanels();
        }
        else if(e.getActionCommand() == "Buy House"){
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
        else if(e.getActionCommand() == "Sell House"){
            if(Start.CheckSellHouseable()){
                System.out.println("Can Sell");
                Start.SellHouses();
            }
        }
    }
}
