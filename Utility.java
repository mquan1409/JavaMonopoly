import java.util.Random;

import javax.swing.JOptionPane;

public class Utility extends Deed {
//*****************************************************************************
    Utility (String name, int cost, int mort, int rent, int id)
    {
        super(name, cost, mort, rent, id);
    }
    @Override
    public int GetRent(){
        Player owner = Start.GetPlayers()[GetOwnerId()];
        JOptionPane.showMessageDialog(null, "You need to roll the dices to pay the rent!");
        Random rand = new Random();
        int di1 = rand.nextInt(6) + 1;
        int di2 = rand.nextInt(6) + 1;
        String message = "You rolled ".concat(String.valueOf(di1)).concat(" and ").concat(String.valueOf(di2));
        JOptionPane.showMessageDialog(null, message);
        if(owner.GetDeedsOwned().contains(12) && owner.GetDeedsOwned().contains(28)){
            JOptionPane.showMessageDialog(null, "The total value of 2 dices will be multiplied by 10.");
            return ((di1 + di2) * 10);
        }
        else{
            JOptionPane.showMessageDialog(null, "The total value of 2 dices will be multiplied by 4.");
            return ((di1 + di2) * 4);
        }
    }
}
