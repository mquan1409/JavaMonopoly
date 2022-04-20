
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
    private int[] Rent;
    private int NumHouses;
    boolean Hotel;

    Property(String name, int cost, int mort, int rent, int houseCost,
               int r1, int r2, int r3, int r4, int rh, int hotelCost, int id)
    {
        super(name, cost, mort, rent, id);
        Rent = new int[6];
        Rent[0] = GetRent(); Rent[1] = r1; Rent[2] = r2; Rent[3] = r3; Rent[4] = r4; Rent[5] = rh;
        NumHouses = 0;
        CostOfHouse = houseCost;
        hotelCost = CostOfHotel;
        Hotel = false;
    }
}
