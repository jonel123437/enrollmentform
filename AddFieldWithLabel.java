package ClassFolder;

import javax.swing.*;
import java.awt.*;

public class AddFieldWithLabel {
    public static void addFieldWithLabel(Container container, String labelText, JComponent field) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(field);
        container.add(panel);
    }
}
