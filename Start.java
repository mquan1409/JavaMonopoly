import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.text.LabelView;

public class Start {
    private static int[] player_positions;
    private static Player[] players;
    public static int turn = 0;
    private static int double_counter = 0;
    public static Land[] lands;
    public static ArrayList<Integer> sets_buyhouseable = new ArrayList<Integer>();
    public static int num_houses_buying = 0;
    public static Coord coord_houses [] = new Coord [22];
    public static void Buy(){
        Deed deed = lands[players[turn].GetPosition()].GetDeed();
        if(deed != null){
            players[turn].Buy(
                deed.GetId(), 
                deed.GetCostOfDeed(),
                deed.GetInstance());
        }
    }
    public static boolean CheckBuyable(){
        if((lands[players[turn].GetPosition()].GetDeed() != null)
            && (!lands[players[turn].GetPosition()].GetDeed().IsOwned())){
            return true;
        }
        return false;
    }
    public static void Rent(){
        Deed deed = lands[players[turn].GetPosition()].GetDeed();
        int rent_cost = deed.GetRent();
        players[turn].SetMoneyOwned(players[turn].GetMoneyOwned() - rent_cost);
        players[deed.GetOwnerId()].SetMoneyOwned(players[deed.GetOwnerId()].GetMoneyOwned() + rent_cost);
        LayeredPane.UpdateDataPanels();
        System.out.println(String.valueOf(turn).concat(" rent ").concat(String.valueOf(deed.GetOwnerId())).concat(" with ").concat(String.valueOf(rent_cost)));
    }
    public static boolean Rentable(){
        Deed deed = lands[players[turn].GetPosition()].GetDeed();
        if(deed != null)
            return deed.IsOwned();
        else
            return false;
    }
    public static void BuyHouses(){
        var property = JOptionPane.showInputDialog("Input where you want buy houses: ");
        var num_houses = JOptionPane.showInputDialog("Input number of houses: ");
        var property_id = Integer.parseInt(property);
        var num_houses_int = Integer.parseInt(num_houses);
        Deed deed = lands[property_id].GetDeed();
        if(deed != null && sets_buyhouseable.contains(deed.GetSetNumber())){
            deed.SetNumHouses(deed.GetNumHouses() + num_houses_int);
            players[turn].SetMoneyOwned(players[turn].GetMoneyOwned() - (deed.GetHouseCost() * num_houses_int));
            LayeredPane.AddHouse(deed);
            LayeredPane.UpdateDataPanels();
            System.out.println(lands[property_id].GetDeed().GetNumHouses());
        }
        else{
            JOptionPane.showMessageDialog(null, "Cannot buy house on that property");
        }
    }
    public static boolean CheckBuyHouseable(){
        sets_buyhouseable.clear();
        ArrayList<Integer> id_deeds_owned = players[turn].GetDeedsOwned();
        for(int i = 0; i < id_deeds_owned.size(); i ++){
            Deed deed = lands[id_deeds_owned.get(i)].GetDeed();
            if(deed instanceof Property){
                int counter = 1;
                int set_num = deed.GetSetNumber();
                int set_num_max = deed.GetMaxPropsOnSet();
                for(int j = i + 1; j < id_deeds_owned.size(); j ++){
                    if(lands[id_deeds_owned.get(j)].GetDeed().GetSetNumber() == set_num)
                        counter ++;
                }
                if(counter == set_num_max)
                    sets_buyhouseable.add(set_num);
            }
        }
        if(sets_buyhouseable.size() != 0){
            return true;
        }
        return false;
    }
    public static void NextTurn(){
        if(double_counter == 0)
            turn ++;
        if(turn >= 4 || turn < 0)
            turn = 0;
    }
    public static void Play(){
        int check;          //check if the player passed Go
        int di1 = 0, di2 = 0;
        Random random = new Random();
        di1=random.nextInt(6)+1;
        di2=random.nextInt(6)+1;
        System.out.println(String.valueOf(di1 + di2));
        int current_position = players[turn].GetPosition();
        players[turn].SetPosition(current_position += di1 + di2);
        check=players[turn].GetPosition()%40;
        if(players[turn].GetPosition()!=check)
        {
            int money;
            money=players[turn].GetMoneyOwned()+200;
            players[turn].SetMoneyOwned(money);
            players[turn].SetPosition(check);
            LayeredPane.UpdateDataPanels();
        }
        if((di1 == di2) && (di1 != 0)){
            System.out.println("Roll double!");
            double_counter ++;
        }
        if(di1 != di2)
            double_counter = 0;
    }
    public static void main(String args[]){
        //Setting up coordinates for the houses
            //first row

            coord_houses[0]=new Coord(425, 480);


            coord_houses[1]=new Coord(425-90, 480);
    
            
            coord_houses[2]=new Coord(425-90-90-45, 480);
            
    
            coord_houses[3]=new Coord(425-90-90-45-90, 480);
            
    
            coord_houses[4]=new Coord(425-90-90-45-90-45, 480);
            
    
            //second row
            coord_houses[5]=new Coord(50, 435);
            
    
            coord_houses[6]=new Coord(50, 435-90);
            
    
            coord_houses[7]=new Coord(50, 435-90-45);
            
    
            coord_houses[8]=new Coord(50, 435-90-45-90);
            
    
            coord_houses[9]=new Coord(50, 435-90-45-90-90);
            
    
            coord_houses[10]=new Coord(50, 435-90-45-90-90-45);
            
    
    
    
            //third row
    
            coord_houses[11]=new Coord(65, 57);
            
    
            coord_houses[12]=new Coord( 65+90, 57);
            
    
            coord_houses[13]=new Coord( 65+45+90, 57);
            
    
    
            coord_houses[14]=new Coord( 65+45+90+90, 57);
            
    
            coord_houses[15]=new Coord( 65+45+90+90+45, 57);
            
    
            coord_houses[16]=new Coord( 65+45+90+90+45+90, 57);
    
    
    
            //fourth row
    
            coord_houses[17]=new Coord( 470, 57 + 17);
        
    
    
            coord_houses[18]=new Coord( 470, 75+45);
        
    
    
            coord_houses[19]=new Coord( 470, 75+45+90);
    
    
    
            coord_houses[20]=new Coord( 470, 75+45+90+90+45);
    
    
    
            coord_houses[21]=new Coord( 470, 75+45+90+90+45+90);

        player_positions = new int[4];        //store the positions of player 0-3
        players = new Player[4];              //there are 4 players (player 0-3)

        for(int i = 0; i < 4; i ++){
            players[i] = new Player(i);
            player_positions[i] = players[i].GetPosition();
        }
        int x=24;
        int y=30;

        //Row 1
        for(int i=1; i<11; i++)
            players[3].GetCoords()[i] = new Coord(520 - (x+45*i+5), y+10+450);
        for(int i=1; i<11; i++)
            players[1].GetCoords()[i] = new Coord(520 - (x+45*i+5), y+450+15+10);
        for(int i=1; i<11; i++)
            players[2].GetCoords()[i] = new Coord(520 - (x+45*i+15+5), y+450+10);
        for(int i=1; i<11; i++)
            players[0].GetCoords()[i] = new Coord(520 - (x+45*i+15+5), y+450+15+10);

        //Row 2
        for(int i=1; i<11; i++)
            players[0].GetCoords()[10 + i] = new Coord(x-5, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            players[1].GetCoords()[10 + i] = new Coord(x+10, 525 - (y+45*i));
        for(int i=1; i<11; i++)
            players[2].GetCoords()[10 + i] = new Coord(x-5, 525 - (y+45*i+15));
        for(int i=1; i<11; i++)
            players[3].GetCoords()[10 + i] = new Coord(x+10, 525 - (y+45*i+15));

        //Row 3
        for(int i=1; i<11; i++)
            players[2].GetCoords()[20 + i] = new Coord(x+45*i, y);
        for(int i=1; i<11; i++)
            players[3].GetCoords()[20 + i] = new Coord(x+45*i+15, y);
        for(int i=1; i<11; i++)
            players[0].GetCoords()[20 + i] = new Coord(x+45*i, y+15);
        for(int i=1; i<11; i++)
            players[1].GetCoords()[20 + i] = new Coord(x+45*i+15, y+15);

        //Row 4
        for(int i=1; i<11; i++)
            players[2].GetCoords()[30 + i] = new Coord(x+455, y+45*i);
        for(int i=1; i<11; i++)
            players[3].GetCoords()[30 + i] = new Coord(x+455+15, y+45*i);
        for(int i=1; i<11; i++)
            players[0].GetCoords()[30 + i] = new Coord(x+455, y+45*i+15);
        for(int i=1; i<11; i++)
            players[1].GetCoords()[30 + i] = new Coord(x+455+15, y+45*i+15);

        int offset_x = 201;
        int offset_y = 101;

        for(int i = 1; i < 41; i ++){
            for(int j = 0; j < 4; j ++){
                players[j].GetCoords()[i].x += offset_x;
                players[j].GetCoords()[i].y += offset_y;
            }
        }
        players[0].GetCoords()[0] = players[0].GetCoords()[40];
        players[1].GetCoords()[0] = players[1].GetCoords()[40];
        players[2].GetCoords()[0] = players[2].GetCoords()[40];
        players[3].GetCoords()[0] = players[3].GetCoords()[40];
        JFrame frame = new JFrame("Start");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        var label = new JLabel("Main Panel", SwingConstants.CENTER);
        label.setBackground(new Color(255,0,0));
        LayeredPane layeredPane = new LayeredPane(players);
        layeredPane.setOpaque(true);
        layeredPane.SetOriginFrame(frame);
        frame.setContentPane(layeredPane);
        frame.setVisible(true);
        BufferedReader input;
        try{
            input = new BufferedReader(new FileReader("Info.txt"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        lands = new Land[40];
        Integer[] property_nums = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
        int counter = 0;
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
                mortgage = 0,
                set_number = 0,
                max_props_on_set = 0;;
            
            lands[i] = new Land();
            if(i%10 == 5){
                lands[i].SetDeed(new RailRoad("Railroad", 200, 0, 0, i));
            }
            // else if(i == 10){
            //     lands[i].SetDeed(new Deed("Just Visiting", true, false));
            // }
            // else if(i == 30){
            //     lands[i].SetDeed(new Deed("Go To Jail", false, true));
            // }
            else if(i == 12){
                lands[i].SetDeed(new Utility("Electric Company", 150, 75, 0, i));
            }
            else if(i == 28){
                lands[i].SetDeed(new Utility("Water Works", 150, 75, 0, i));
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
                    set_number = Integer.parseInt(input.readLine());
                    max_props_on_set = Integer.parseInt(input.readLine());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                lands[i].SetDeed(new Property(
                    name, cost, mortgage, rent, 100,
                    rent_1_house, rent_2_house, rent_3_house, rent_4_house,
                    set_number, max_props_on_set, i));
                //System.out.println(Board.coord_houses[counter].x += 200);
                // Board.coord_houses[counter].y += 60;
                coord_houses[counter].x += 199;
                coord_houses[counter].y += 97;
                lands[i].GetDeed().SetCoordHouse(coord_houses[counter]);
                counter ++;
            }
        }
        players[0].Buy(lands[21].GetDeed().GetId(), 100, lands[21].GetDeed().GetInstance());
        players[0].Buy(lands[23].GetDeed().GetId(), 100, lands[23].GetDeed().GetInstance());
        players[0].Buy(lands[24].GetDeed().GetId(), 100, lands[24].GetDeed().GetInstance());
        turn -= 3;
    }

    public static void chestcard()
    {
        Random random = new Random();
        int money;
        int card = random.nextInt(14);
        switch(card)
        {
            case 0:
            System.out.println("Advance to go and collect $200");
            players[turn].SetPosition(0);
            money=players[turn].GetMoneyOwned()+200;
            players[turn].SetMoneyOwned(money);
            break;

            case 1:
            System.out.println("Bank Error in your favor. Collect $200");
            money=players[turn].GetMoneyOwned()+200;
            players[turn].SetMoneyOwned(money);
            break;

            case 2:
            System.out.println("Doctor's fee. Pay $50");
            money=players[turn].GetMoneyOwned()-50;
            players[turn].SetMoneyOwned(money);
            break;

            case 3:
            System.out.println("From sale of stock you get $50");
            money=players[turn].GetMoneyOwned()+50;
            players[turn].SetMoneyOwned(money);
            break;


            case 4:
            System.out.println("Go to Jail. Go directly to jail, do not pass Go, do not collect $200");
            players[turn].SetPosition(10);
            break;

            case 5:
            System.out.println("Holiday fund matures. Receive $100");
            money=players[turn].GetMoneyOwned()+100;
            players[turn].SetMoneyOwned(money);
            break;


            case 6:
            System.out.println("Income tax refund. Collect $20");
            money=players[turn].GetMoneyOwned()+20;
            players[turn].SetMoneyOwned(money);
            break;


            case 7:
            System.out.println("It is your birthday. Collect $10 from every player");
            for(int x=0; x<4; x++)
            {
                money=players[turn].GetMoneyOwned()+10;
                players[turn].SetMoneyOwned(money);
            }
            int i=turn+1;
            for(int x=0; x<4; x++, i++)
            {
                i=i%4;
                money=players[i].GetMoneyOwned()-10;
                players[i].SetMoneyOwned(money);
            }
            break;


            case 8:
            System.out.println("Life insurance matures. Collect $100");
            money=players[turn].GetMoneyOwned()+100;
            players[turn].SetMoneyOwned(money);
            break;


            case 9:
            System.out.println("Pay hospital fees of $100");
            money=players[turn].GetMoneyOwned()-100;
            players[turn].SetMoneyOwned(money);
            break;



            case 10:
            System.out.println("Pay school fees of $50");
            money=players[turn].GetMoneyOwned()-50;
            players[turn].SetMoneyOwned(money);
            break;


            case 11:
            System.out.println("Receive $25 consultancy fee");
            money=players[turn].GetMoneyOwned()+25;
            players[turn].SetMoneyOwned(money);
            break;


            case 12:
            System.out.println("You have won second prize in a beauty contest. Collect $10");
            money=players[turn].GetMoneyOwned()+10;
            players[turn].SetMoneyOwned(money);
            break;


            case 13:
            System.out.println("You inherit $100");
            money=players[turn].GetMoneyOwned()+100;
            players[turn].SetMoneyOwned(money);
            break;
        }
    }

    public static void chancecard()
    {
        Random random = new Random();
        int money;
        int card = random.nextInt(10);
        switch(card)
        {
            case 0:
            System.out.println("Advance to go and collect $200");
            players[turn].SetPosition(0);
            money=players[turn].GetMoneyOwned()+200;
            players[turn].SetMoneyOwned(money);
            break;

            
            case 1:
            System.out.println("Advance to Illinois Avenue. If you pass Go, collect $200");
            if(players[turn].GetPosition()>24)
            {
                money=players[turn].GetMoneyOwned()+200;
                players[turn].SetMoneyOwned(money);
            }
            players[turn].SetPosition(24);
            break;

            case 2:
            System.out.println("Advance to St. Charles Place. If you pass Go, collect $200");
            if(players[turn].GetPosition()>11)
            {
                money=players[turn].GetMoneyOwned()+200;
                players[turn].SetMoneyOwned(money);
            }
            players[turn].SetPosition(11);
            break;


            case 3:
            System.out.println("Take a trip to Reading Railroad. If you pass Go, collect $200");
            if(players[turn].GetPosition()>5)
            {
                money=players[turn].GetMoneyOwned()+200;
                players[turn].SetMoneyOwned(money);
            }
            players[turn].SetPosition(5);
            break;


            case 4:
            System.out.println("Bank pays you dividend of $50");
            money=players[turn].GetMoneyOwned()+50;
            players[turn].SetMoneyOwned(money);
            break;

            case 5:
            System.out.println("Go Back 3 Spaces");
            money=players[turn].GetPosition();
            money=money-3;
            if(money<0)
                money+=40;
            players[turn].SetPosition(money);
            break;


            case 6:
            System.out.println("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200");
            players[turn].SetPosition(10);
            break;

            case 7:
            System.out.println("Speeding fine $15");
            money=players[turn].GetMoneyOwned()-15;
            players[turn].SetMoneyOwned(money);
            break;


            case 8:
            System.out.println("You have been elected Chairman of the Board. Pay each player $50");
            for(int i=0; i<4; i++)
            {
                money=players[turn].GetMoneyOwned()-50;
                players[turn].SetMoneyOwned(money);
            }
            int x=turn+1;
            for(int i=0; i<4; i++, x++)
            {
                x=x%4;
                money=players[x].GetMoneyOwned()+50;
                players[x].SetMoneyOwned(money);
            }
            break;



            case 9:
            System.out.println("Your building loan matures. Collect $150");
            money=players[turn].GetMoneyOwned()+150;
            players[turn].SetMoneyOwned(money);
            break;
        }
    }
}

