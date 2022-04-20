
public class Property extends Deed{
//*****************************************************************************

    /*
     * CostOfHouse = how much player needs to pay in order to buy a house
     * CostOfHotel = how much a hotel costs
     * Rent0 = rent with no houses (base rent)
     * Rent(n) = rent with n number of houses - from 1 to 4
     * RentH = rent with a hotel
     * NumHouses = number of houses on property
     * Hotel = is there a hotel on property
     */
    private int CostOfHouse; 
    private int CostOfHotel;
    private int[] RentProp;
    private int NumHouses;
    private int SetNumber;
    private int MaxPropsOnSet;
    private Coord CoordHouse;
    private boolean Hotel;

    @Override
    public void SetNumHouses(int value){
        NumHouses = value;
    }
    @Override
    public int GetNumHouses(){
        return NumHouses;
    }
    @Override
    public int GetSetNumber(){
        return SetNumber;
    }
    @Override
    public int GetMaxPropsOnSet(){
        return MaxPropsOnSet;
    }
    @Override
    public int GetRent(){
        return RentProp[NumHouses];
    }
    @Override
    public int GetHouseCost(){
        return CostOfHouse;
    }
    @Override
    public void SetCoordHouse(Coord value){
        CoordHouse = value;
    }
    @Override
    public Coord GetCoordHouse(){
        return CoordHouse;
    }
    Property(String name, int cost, int mort, int rent,
               int r1, int r2, int r3, int r4, int rh, int setNum, int maxPropsOnSet, int id)
    {
        super(name, cost, mort, rent, id);
        RentProp = new int[6];
        RentProp[0] = rent; RentProp[1] = r1; RentProp[2] = r2; RentProp[3] = r3; RentProp[4] = r4; RentProp[5] = rh;
        NumHouses = 0;
        SetNumber = setNum;
        MaxPropsOnSet = maxPropsOnSet;
        Hotel = false;
        if(id/10 == 0)
            CostOfHouse = 50;
        if(id/10 == 1)
            CostOfHouse = 100;
        if(id/10 == 2)
            CostOfHouse = 150;
        if(id/10 == 3)
            CostOfHouse = 200;
        CostOfHotel = CostOfHouse;
    }
}
