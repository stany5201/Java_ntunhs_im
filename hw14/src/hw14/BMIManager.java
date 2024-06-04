package hw14;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class BMIManager extends JFrame {
    private JButton calculateButton, saveButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;

    public BMIManager() {
        super("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new FlowLayout());

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Height (m):"));
        add(heightField);
        add(new JLabel("Weight (kg):"));
        add(weightField);

        calculateButton = new JButton("Calculate BMI");
        calculateButton.addActionListener(this::calculateBMI);
        add(calculateButton);

        saveButton = new JButton("Save Data");
        saveButton.addActionListener(this::saveData);
        add(saveButton);

        listButton = new JButton("List Students");
        listButton.addActionListener(this::listStudents);
        add(listButton);

        textArea = new JTextArea(10, 40);
        add(new JScrollPane(textArea));

        setVisible(true);
    }

    private void calculateBMI(ActionEvent e) {
        String name = nameField.getText();
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            Student student = new Student(name, height, weight);
            double bmi = student.calculateBMI();

            textArea.setText(String.format("%s's BMI: %.2f", name, bmi));
        } catch (NumberFormatException nfe) {
            textArea.setText("Please ensure height and weight are correct numbers.");
        }
    }

    private void saveData(ActionEvent e) {
        String name = nameField.getText();
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            Student student = new Student(name, height, weight);

            Path path = Paths.get("BMI_Data.csv");
            List<String> lines = new ArrayList<>();

            // Read existing data
            if (Files.exists(path)) {
                try (BufferedReader reader = Files.newBufferedReader(path)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException ex) {
                    textArea.setText("Failed to read existing data.");
                    return;
                }
            }

            // Check for existing record and update or add new
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                if (data[0].equals(name)) {
                    lines.set(i, student.toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                lines.add(student.toString());
            }

            // Write updated data back to file
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                textArea.append("\nData saved to BMI_Data.csv");
            } catch (IOException ex) {
                textArea.setText("Failed to save data.");
            }
        } catch (NumberFormatException nfe) {
            textArea.setText("Please ensure height and weight are correct numbers.");
        }
    }

    private void listStudents(ActionEvent e) {
        Path path = Paths.get("BMI_Data.csv");
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                textArea.setText(sb.toString());
            } catch (IOException ex) {
                textArea.setText("Failed to read data from file.");
            }
        } else {
            textArea.setText("No data file found.");
        }
    }

    public static void main(String[] args) {
        new BMIManager();
    }
}
