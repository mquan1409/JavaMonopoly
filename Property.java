
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
    Property(String name, int cost, int mort, int rent, int houseCost,
               int r1, int r2, int r3, int r4, int rh, int hotelCost, int setNum, int maxPropsOnSet, int id)
    {
        super(name, cost, mort, rent, id);
        RentProp = new int[6];
        RentProp[0] = rent; RentProp[1] = r1; RentProp[2] = r2; RentProp[3] = r3; RentProp[4] = r4; RentProp[5] = rh;
        NumHouses = 0;
        CostOfHouse = houseCost;
        hotelCost = CostOfHotel;
        SetNumber = setNum;
        MaxPropsOnSet = maxPropsOnSet;
        Hotel = false;
    }
}
