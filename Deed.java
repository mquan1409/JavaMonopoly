import java.lang.String;
import java.util.ArrayList;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.management.ValueExp;

//*****************************************************************************

/*
 * Name = name of property
 * Owner = player that owns property
 * CostOfDeed = Price to buy
 * Mortgage = money player gets of mortgaging the property
 * Rent = base rent
 * IsOwned = is the property owned by a player
 */
public class Deed {
    private String Name;
    private int OwnerId;
    private int Id;
    private int CostOfDeed, Mortgage, Rent;
    private boolean isOwned;
    public boolean IsOwned(){
        return isOwned;
    }
    public String GetName(){
        return Name;
    }
    public void SetName(String value){
        Name = value;
    }
    public int GetOwnerId(){
        return OwnerId;
    }
    public void SetOwnerId(int value){
        OwnerId = value;
        isOwned = true;
    }
    public int GetCostOfDeed(){
        return CostOfDeed;
    }
    public int GetMortgage(){
        return Mortgage;
    }
    public int GetRent(){
        return Rent;
    }
    public int GetId(){
        return Id;
    }
    public void SetId(int value){
        Id = value;
    }
    public Deed GetInstance(){
        return this;
    }
    public int GetSetNumber(){
        return -1;
    }
    public int GetMaxPropsOnSet(){
        return -1;
    }
    public void SetNumHouses(int value){
    }
    public int GetNumHouses(){
        return -1;
    }
    public int GetHouseCost(){
        return -1;
    }
    public void SetCoordHouse(Coord value){
    }
    public Coord GetCoordHouse(){
        return new Coord(0, 0);
    }
    public ArrayList<HouseGUI> GetHouseGUIs(){
        return null;
    }
    public ArrayList<HouseGUI> UpdateHouseGUIs(){
        return null;
    }
    public Deed (String name, int cost, int mort, int rent, int id)
    {
        Name = name;
        Id = id;
        CostOfDeed = cost;
        Mortgage = mort;
        Rent = rent;
        isOwned = false;
        OwnerId = -1;
    }
    public Deed (String name, boolean is_visiting_jail, boolean is_jail){
        Name = name;
    }
    public Deed(){
        Name = "a";
        CostOfDeed = 0;
        Mortgage = 0;
        Rent = 0;
        isOwned = false;
    }
    public void Reset(){
        OwnerId = -1;
        isOwned = false;
    }
}
