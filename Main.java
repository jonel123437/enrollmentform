package ClassFolder;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ClassFolder.CreateAndShowGUI;


public class Main {

    private static JPanel mainPanel;
    private static int submissionCount = 1; // Initialize the submission count

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> CreateAndShowGUI.createAndShowGUI());
    }

    

	static class YesNoQuestionPanel extends JPanel {
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JLabel questionLabel;

    public YesNoQuestionPanel(String questionText) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        yesRadioButton = new JRadioButton("Yes");
        noRadioButton = new JRadioButton("No");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(yesRadioButton);
        buttonGroup.add(noRadioButton);

        questionLabel = new JLabel(questionText);
        add(questionLabel);
        add(yesRadioButton);
        add(noRadioButton);
    }

    public String getQuestionText() {
        return questionLabel.getText();
    }

    public String getSelectedOption() {
        if (yesRadioButton.isSelected()) {
            return "Yes";
        } else if (noRadioButton.isSelected()) {
            return "No";
        } else {
            return "";
        }
    }
}
}
