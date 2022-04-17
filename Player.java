import java.lang.String;

public class Player {
    private int money_owned;
    private int Id;
    private int[] deeds_owned;
    private String name;
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
    public int[] GetDeedsOwned(){
        return deeds_owned;
    }
    public int GetMoneyOwned(){
        return money_owned;
    }
    public void SetMoneyOwned(int money){
        money_owned = money;
    }
    public Player(){
        deeds_owned = new int[28];
        money_owned = 1500;
    }
}
