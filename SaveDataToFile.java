package ClassFolder;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDataToFile {
    public static void saveDataToFile(String fileName, JPanel mainPanel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Component[] components = mainPanel.getComponents();
            for (Component component : components) {
                if (component instanceof Main.YesNoQuestionPanel) {
                    Main.YesNoQuestionPanel questionPanel = (Main.YesNoQuestionPanel) component;
                    String questionText = questionPanel.getQuestionText();
                    String selectedOption = questionPanel.getSelectedOption();
                    writer.write(questionText + " " + selectedOption);
                    writer.newLine();
                } else if (component instanceof JPanel) {
                    JPanel panel = (JPanel) component;
                    for (Component subComponent : panel.getComponents()) {
                        if (subComponent instanceof JComponent) {
                            if (subComponent instanceof JLabel) {
                                JLabel label = (JLabel) subComponent;
                                String labelText = label.getText();
                                writer.write(labelText);
                            } else if (subComponent instanceof JTextField) {
                                JTextField textField = (JTextField) subComponent;
                                String fieldData = textField.getText();
                                writer.write(fieldData);
                            } else if (subComponent instanceof JComboBox<?>) {
                                JComboBox<?> comboBox = (JComboBox<?>) subComponent;
                                String selectedCourse = (String) comboBox.getSelectedItem();
                                writer.write(selectedCourse);
                            }
                            writer.newLine();
                        } else if (subComponent instanceof Main.YesNoQuestionPanel) {
                            Main.YesNoQuestionPanel questionPanel = (Main.YesNoQuestionPanel) subComponent;
                            String questionText = questionPanel.getQuestionText();
                            String selectedOption = questionPanel.getSelectedOption();
                            writer.write(questionText + " " + selectedOption);
                            writer.newLine();
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Entry submitted");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while saving data.");
        }
    }
}
