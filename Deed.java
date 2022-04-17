import java.lang.String;
import java.util.jar.Attributes.Name;

import javax.management.ValueExp;

//*****************************************************************************

/*
 * Name = name of property
 * Owner = player that owns property
 * CostOfDeed = Price to buy
 * Mortgage = money player gets of mortgaging the property
 * Rent = base rent
 * Own = is the property owned by a player
 */
public class Deed {
    private String Name;
    private String Owner;
    private int OwnerId;
    private int Id;
    private int CostOfDeed, Mortgage, Rent;
    private boolean Own;
    private boolean IsVisitingJail = false;
    private boolean IsJail = false;
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
    public Deed (String name, int cost, int mort, int rent)
    {
        Name = name;
        CostOfDeed = cost;
        Mortgage = mort;
        Rent = rent;
        Own = false;
        Owner = "N/A";
    }
    public Deed (String name, boolean is_visiting_jail, boolean is_jail){
        Name = name;
        IsVisitingJail = is_visiting_jail;
        IsJail = is_jail;
    }
    public Deed(){
        Name = "a";
        CostOfDeed = 0;
        Mortgage = 0;
        Rent = 0;
        Own = false;
        Owner = "N/A";
    }
}
