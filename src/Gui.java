import interfaces.iGui;
import javax.swing.*;
import java.awt.*;

public class Gui implements iGui {
    private JFrame f;
    private JPanel abilities;
    private JLabel ability;

    private void displayAbilities() {
        abilities = new JPanel();
        for(String name : Abilities.names) {
            ability = new JLabel(name);
            abilities.add(ability);
        }
        abilities.setLayout(new BoxLayout(abilities, BoxLayout.Y_AXIS));
    }

    private void frameSetUp() {
        f = new JFrame("Pathfinder Character Sheet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(BorderLayout.WEST, abilities);
        f.setSize(900, 700);
        f.setVisible(true);
    }

    public void Run() {
        displayAbilities();
        frameSetUp();
    }
}