import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu{

    private JFrame mainFrame;
    private JPanel mainPanel;

    public Menu(){
        prepareGUI();
    }

    public static void main(String[] args) {
        Menu menuScreen = new Menu();
        menuScreen.showMenu();
    }

    private void prepareGUI(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scrw = screenSize.width / 8;
        int scrh = screenSize.height / 8;
        mainFrame = new JFrame("Menu");
        mainFrame.setSize(scrw, scrh);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new FlowLayout());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
    private void showMenu(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scrw = screenSize.width / 3;
        int scrh = screenSize.height / 3;
        String[] playerChoices = {"1", "2", "3", "4"};

        final JFrame startFrame = new JFrame("Start");

        startFrame.setSize(scrw, scrh);
        startFrame.setLocationRelativeTo(null);
        startFrame.setLayout(new FlowLayout());


        final JFrame leaderboardFrame = new JFrame("Leaderboard");
        leaderboardFrame.setSize(scrw, scrh);
        leaderboardFrame.setLocationRelativeTo(null);
        leaderboardFrame.setLayout(new FlowLayout());

        startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                startFrame.dispose();
            }
        });
        leaderboardFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                leaderboardFrame.dispose();
            }
        });
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                startFrame.setVisible(true);
            }
        });
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                leaderboardFrame.setVisible(true);
            }
        });

        JComboBox playerList = new JComboBox(playerChoices);

        mainPanel.add(startButton);
        mainPanel.add(leaderboardButton);
        mainFrame.setVisible(true);
    }
}
