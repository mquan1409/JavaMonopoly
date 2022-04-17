
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
    int CostOfHouse, CostOfHotel, Rent0, Rent1, Rent2, Rent3, Rent4, RentH,
            NumHouses;
    boolean Hotel;

    Property(String name, int cost, int mort, int rent, int houseCost,
               int r1, int r2, int r3, int r4, int rh, int hotelCost)
    {
        super(name, cost, mort, rent);
        Rent0 = GetRent(); Rent1 = r1; Rent2 = r2; Rent3 = r3;Rent4 = r4;RentH = rh;
        NumHouses = 0;
        CostOfHouse = houseCost;
        hotelCost = CostOfHotel;
        Hotel = false;
    }
}
