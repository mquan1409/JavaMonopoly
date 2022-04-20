import java.lang.System;
public class RailRoad extends Deed{
    public int GetRent(){
        int num_railroads_owned = Start.GetPlayers()[GetOwnerId()].GetNumRailroadsOwned();
        return (50 * num_railroads_owned);
    }
    public RailRoad(String name, int cost, int mort, int rent, int id)
    {
        super(name, cost, mort, rent, id);
    }
    public RailRoad(){
        super();
    }
}
