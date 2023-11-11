package ClassFolder;

import javax.swing.*;

public class GetFieldValue {
    public static String getFieldValue(JComponent field) {
        if (field instanceof JTextField) {
            return ((JTextField) field).getText();
        } else if (field instanceof JComboBox<?>) {
            return (String) ((JComboBox<?>) field).getSelectedItem();
        }
        return "";
    }
}
