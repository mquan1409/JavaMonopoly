import java.lang.String;
import java.util.ArrayList;
import java.util.Vector;

public class Player {
    private int money_owned;
    private int Id;
    private ArrayList<Integer> id_deeds_owned;
    private String name;
    private int position;
    private Coord[] coords;
    private boolean jail=true;
    private int num_railroads_owned = 0;
    private int num_utilities_owned = 0;
    public Coord[] GetCoords(){
        return coords;
    }
    public Coord GetCoordNow(){
        return coords[position];
    }
    public int GetPosition(){
        return position;
    }
    public void SetPosition(int value){
        position = value;
    }
    public String GetName(){
        return name;
    }
    public void SetName(String value){
        name = value;
    }
    public int GetId(){
        return Id;
    }
    public void SetId(int value){
        Id = value;
    }
    public ArrayList<Integer> GetDeedsOwned(){
        return id_deeds_owned;
    }
    public int GetMoneyOwned(){
        return money_owned;
    }
    public void SetMoneyOwned(int money){
        money_owned = money;
    }
    public int GetNumRailroadsOwned(){
        return num_railroads_owned;
    }
    public int GetNumUtilitiesOwned(){
        return num_utilities_owned;
    }
    public void Buy(int deed_id, int cost, Deed deed_bought){
        id_deeds_owned.add(deed_id);
        money_owned -= cost;
        deed_bought.SetOwnerId(Id);
        LayeredPane.UpdateDataPanels();
        if(deed_id%10 == 5)
            num_railroads_owned ++;
        else if(deed_id == 12 || deed_id == 28)
            num_utilities_owned ++;
        Start.NextTurn();
    }
    public Player(int id){
        Id = id;
        coords = new Coord[41];
        id_deeds_owned = new ArrayList<Integer>();
        money_owned = 1500;
        position = 0;
    }
    public void injail()
    {
        jail=!jail;
    }

    public boolean getjail()
    {
        return jail;
    }
}
