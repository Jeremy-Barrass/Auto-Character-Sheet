import interfaces.iAbilities;
import interfaces.iGui;
import javax.swing.*;
import java.awt.*;

public class Gui implements iGui {
    private JFrame f;
    private JPanel abilitiesDisplay;
    private JPanel abilityTitles;
    private JPanel abilityScores;
    private JLabel title;
    private JLabel score;

    private void displayAbilities(iAbilities abilities) {
        abilitiesDisplay = new JPanel();
        abilityTitles = new JPanel();
        abilityScores = new JPanel();
        for (String statName : Abilities.ListAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(abilities.GetAbilityScore(statName)));
            abilityScores.add(score);
        }
        abilityTitles.setLayout(new BoxLayout(abilityTitles, BoxLayout.Y_AXIS));
        abilityScores.setLayout(new BoxLayout(abilityScores, BoxLayout.Y_AXIS));
        abilitiesDisplay.add(abilityTitles);
        abilitiesDisplay.add(abilityScores);
    }

    private void frameSetUp() {
        f = new JFrame("Pathfinder Character Sheet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(BorderLayout.WEST, abilitiesDisplay);
        f.setSize(900, 700);
        f.setVisible(true);
    }

    public void Run(iAbilities abilities) {
        displayAbilities(abilities);
        frameSetUp();
    }
}