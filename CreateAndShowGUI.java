package ClassFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateAndShowGUI {
    private static JPanel mainPanel;
    private static int submissionCount = 1; // Initialize the submission count

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Admission Survey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        JPanel admissionCategoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel admissionCategoryLabel = new JLabel("ADMISSION CATEGORY:");
        admissionCategoryPanel.add(admissionCategoryLabel);

        String[] admissionCategoryOptions = {
            "GRADE 12 GRADUATE",
            "ALS GRADUATE qualified for college admission",
            "COLLEGE LEVEL",
            "GRADE 12 GRADUATING STUDENT (Will graduate in August 2023)"
        };
        JComboBox<String> admissionCategoryComboBox = new JComboBox<>(admissionCategoryOptions);
        admissionCategoryComboBox.setPreferredSize(new Dimension(345, 23));
        admissionCategoryPanel.add(admissionCategoryComboBox);

        mainPanel.add(admissionCategoryPanel);

        String[] courseOptions = {
            "DIPLOMA IN ELECTRICAL ENGINEERING TECHNOLOGY",
            "DIPLOMA IN MECHANICAL ENGINEERING TECHNOLOGY",
            "DIPLOMA IN ELECTRONICS ENGINEERING TECHNOLOGY",
            "DIPLOMA IN COMPUTER ENGINEERING TECHNOLOGY"
        };
        JComboBox<String> courseComboBox1 = new JComboBox<>(courseOptions);
        JComboBox<String> courseComboBox2 = new JComboBox<>(courseOptions);
        JComboBox<String> courseComboBox3 = new JComboBox<>(courseOptions);

        addFieldWithLabel(mainPanel, "PREFERRED COURSES 1:", courseComboBox1);
        addFieldWithLabel(mainPanel, "PREFERRED COURSES 2:", courseComboBox2);
        addFieldWithLabel(mainPanel, "PREFERRED COURSES 3:", courseComboBox3);

        addFieldWithLabel(mainPanel, "FAMILY NAME, FIRST NAME, MIDDLE NAME (e.g. CRUZ, JUAN, SANTOS):", new JTextField(20));
        addFieldWithLabel(mainPanel, "AGE:", new JTextField(20));
        addFieldWithLabel(mainPanel, "RELIGION:", new JTextField(20));
        addFieldWithLabel(mainPanel, "ADDRESS:", new JTextField(20));
        addFieldWithLabel(mainPanel, "CONFIRM CELLPHONE NUMBER:", new JTextField(20));
        addFieldWithLabel(mainPanel, "2ND CONTACT NUMBER:", new JTextField(20));
        addFieldWithLabel(mainPanel, "NO. OF BROTHERS AND SISTERS (excluding you):", new JTextField(20));
        addFieldWithLabel(mainPanel, "COLLEGE/SCHOOL LAST ATTENDED (e.g., Talamban National High School):", new JTextField(20));
        addFieldWithLabel(mainPanel, "YEAR GRADUATED (e.g., June 2022):", new JTextField(20));
        addFieldWithLabel(mainPanel, "FACEBOOK ACCOUNT:", new JTextField(20));
        addFieldWithLabel(mainPanel, "HONORS/ AWARDS RECEIVED:", new JTextField(20));
        addFieldWithLabel(mainPanel, "RANK IN THE CLASS: (Write NA if not applicable):", new JTextField(20));
        addFieldWithLabel(mainPanel, "LATEST OVER-ALL GRADE AVERAGE:", new JTextField(20));
        addFieldWithLabel(mainPanel, "SPORTS/HOBBIES:", new JTextField(20));
        addFieldWithLabel(mainPanel, "ORGANIZATION/AFFILIATIONS IN THE SCHOOL OR OUTSIDE THE SCHOOL:", new JTextField(20));
        addFieldWithLabel(mainPanel, "ARE YOU AVAILING OF ANY SCHOLARSHIP GRANTS ASIDE FROM CITE? (e.g., Cebu City Scholarship):", new JTextField(20));
        addFieldWithLabel(mainPanel, "WORK EXPERIENCES (If any):", new JTextField(20));
        addFieldWithLabel(mainPanel, "MOTHER'S FULL NAME:", new JTextField(20));
        addFieldWithLabel(mainPanel, "MOTHER'S OCCUPATION/SOURCE OF INCOME:", new JTextField(20));
        addFieldWithLabel(mainPanel, "FATHER'S FULL NAME:", new JTextField(20));
        addFieldWithLabel(mainPanel, "FATHER'S OCCUPATION/SOURCE OF INCOME:", new JTextField(20));
        addFieldWithLabel(mainPanel, "GUARDIAN'S FULL NAME:", new JTextField(20));
        addFieldWithLabel(mainPanel, "GUARDIAN'S OCCUPATION/SOURCE OF INCOME:", new JTextField(20));

        JLabel profileSectionLabel = new JLabel("II. APPLICANT'S PROFILE");
        mainPanel.add(profileSectionLabel);

        addFieldWithLabel(mainPanel, "Why do you want to study at CITE?", new JTextField(20));
        addFieldWithLabel(mainPanel, "What are your positive traits/attitudes?", new JTextField(20));
        addFieldWithLabel(mainPanel, "What traits do you wish to improve?", new JTextField(20));
        addFieldWithLabel(mainPanel, "What attitudes do you like to change?", new JTextField(20));
        addFieldWithLabel(mainPanel, "How do you spend your weekends?", new JTextField(20));
        addFieldWithLabel(mainPanel, "Are you staying with your parents? If not, why?", new JTextField(20));
        addFieldWithLabel(mainPanel, "Describe your family atmosphere:", new JTextField(20));
        addFieldWithLabel(mainPanel, "What are your health problems/issues?", new JTextField(20));

        YesNoQuestionPanel tattooQuestionPanel = new YesNoQuestionPanel("Do you have any tattoo on your body?");
        mainPanel.add(tattooQuestionPanel);

        YesNoQuestionPanel piercingQuestionPanel = new YesNoQuestionPanel("Do you have any piercings in your ear or any part of your body?");
        mainPanel.add(piercingQuestionPanel);

        YesNoQuestionPanel facetoface = new YesNoQuestionPanel("Can your parents attend a face-to-face parenting seminar at least once a month?");
        mainPanel.add(facetoface);

        YesNoQuestionPanel single = new YesNoQuestionPanel("Can you say that you are single?");
        mainPanel.add(single);

        addFieldWithLabel(mainPanel, "Do you have a question for us?", new JTextField(20));

        frame.setVisible(true);

        // Add a submit button to your createAndShowGUI method
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "output" + submissionCount + ".txt";
                SaveDataToFile.saveDataToFile(fileName, mainPanel);
                submissionCount++; // Increment the submission count
            }
        });
        mainPanel.add(submitButton);

        frame.setVisible(true);
    }

    private static void addFieldWithLabel(Container container, String labelText, JComponent field) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(field);
        container.add(panel);
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
