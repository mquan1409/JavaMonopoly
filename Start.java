import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.text.LabelView;

public class Start {
    public static void main(String args[]){
        //Player positions
        Coord[] player1_coords = new Coord[41];
        Coord[] player2_coords = new Coord[41];
        Coord[] player3_coords = new Coord[41];
        Coord[] player4_coords = new Coord[41];

        int x=24;
        int y=30;

        //Row 1
        for(int i=1; i<11; i++)
            player1_coords[i] = new Coord(520 - (x+45*i+5), y+10+450);
        for(int i=1; i<11; i++)
            player2_coords[i] = new Coord(520 - (x+45*i+5), y+450+15+10);
        for(int i=1; i<11; i++)
            player3_coords[i] = new Coord(520 - (x+45*i+15+5), y+450+10);
        for(int i=1; i<11; i++)
            player4_coords[i] = new Coord(520 - (x+45*i+15+5), y+450+15+10);

        //Row 2
        for(int i=1; i<11; i++)
            player1_coords[10 + i] = new Coord(x-5, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            player2_coords[10 + i] = new Coord(x+10, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            player3_coords[10 + i] = new Coord(x-5, 525 - (y+45*i+15));
        for(int i=1; i<11; i++)
            player4_coords[10 + i] = new Coord(x+10, 525 - (y+45*i+15));

        //Row 3
        for(int i=1; i<11; i++)
            player1_coords[20 + i] = new Coord(x+45*i, y);
        for(int i=1; i<11; i++)
            player2_coords[20 + i] = new Coord(x+45*i+15, y);
        for(int i=1; i<11; i++)
            player3_coords[20 + i] = new Coord(x+45*i, y+15);
        for(int i=1; i<11; i++)
            player4_coords[20 + i] = new Coord(x+45*i+15, y+15);

        //Row 4
        for(int i=1; i<11; i++)
            player1_coords[30 + i] = new Coord(x+455, y+45*i);
        for(int i=1; i<11; i++)
            player2_coords[30 + i] = new Coord(x+455+15, y+45*i);
        for(int i=1; i<11; i++)
            player3_coords[30 + i] = new Coord(x+455, y+45*i+15);
        for(int i=1; i<11; i++)
            player4_coords[30 + i] = new Coord(x+455+15, y+45*i+15);

        JFrame frame = new JFrame("Start");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        //Container content_pane = frame.getContentPane();
        //frame.add(board);
        var label = new JLabel("Main Panel", SwingConstants.CENTER);
        label.setBackground(new Color(255,0,0));
        //frame.add(label);
        //frame.add(triangles);
        LayeredPane layeredPane = new LayeredPane(
            player1_coords, 
            player2_coords, 
            player3_coords, 
            player4_coords);
        layeredPane.setOpaque(true);
        layeredPane.SetOriginFrame(frame);
        frame.setContentPane(layeredPane);
        //frame.pack();
        frame.setVisible(true);
        BufferedReader input;
        try{
            input = new BufferedReader(new FileReader("Info.txt"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        Land[] lands;
        lands = new Land[40];
        Integer[] property_nums = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
        for(int i = 0; i < 40; i ++){
            String name = "N/A";
            int cost = 0, 
                price_per_house = 0, 
                rent = 0, 
                rent_1_house = 0, 
                rent_2_house = 0, 
                rent_3_house = 0, 
                rent_4_house = 0, 
                rent_hotel = 0, 
                mortgage = 0;
            
            lands[i] = new Land();
            if(i%10 == 5){
                lands[i].SetDeed(new RailRoad());
            }
            else if(i == 10){
                lands[i].SetDeed(new Deed("Just Visiting", true, false));
            }
            else if(i == 30){
                lands[i].SetDeed(new Deed("Go To Jail", false, true));
            }
            else if(i == 12){
                lands[i].SetDeed(new Utility("Electric Company", 150, 75, 0));
            }
            else if(i == 28){
                lands[i].SetDeed(new Utility("Water Works", 150, 75, 0));
            }
            else if(Arrays.asList(property_nums).contains(i)){
                try{
                    name = input.readLine();
                    cost = Integer.parseInt(input.readLine());
                    price_per_house = Integer.parseInt(input.readLine());
                    rent = Integer.parseInt(input.readLine());
                    rent_1_house = Integer.parseInt(input.readLine());
                    rent_2_house = Integer.parseInt(input.readLine());
                    rent_3_house = Integer.parseInt(input.readLine());
                    rent_4_house = Integer.parseInt(input.readLine());
                    rent_hotel = Integer.parseInt(input.readLine());
                    mortgage = Integer.parseInt(input.readLine());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                lands[i].SetDeed(new Deed(name, cost, mortgage, rent));
            }
            
        }
        for(int i = 0; i < 40; i ++){
            System.out.println(lands[i].GetDeed().GetName());
        }
    }
}