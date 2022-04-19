import java.lang.String;
import java.util.ArrayList;
import java.util.Vector;

public class Player {
    private int money_owned;
    private int Id;
    private ArrayList<Integer> deeds_owned;
    private String name;
    private int position;
    private Coord[] coords;
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
        return deeds_owned;
    }
    public int GetMoneyOwned(){
        return money_owned;
    }
    public void SetMoneyOwned(int money){
        money_owned = money;
    }
    public void Buy(int deed_id, int cost, Deed deed_bought){
        deeds_owned.add(deed_id);
        money_owned -= cost;
        deed_bought.SetOwnerId(Id);
        LayeredPane.UpdateMoneyPanels();
        Start.NextTurn();
    }
    public Player(int id){
        Id = id;
        coords = new Coord[41];
        deeds_owned = new ArrayList<Integer>();
        money_owned = 1500;
        position = 0;
    }
}
