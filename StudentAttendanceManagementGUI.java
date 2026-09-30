import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentAttendanceManagementGUI extends JFrame {

    // Arrays to store student information
    static String[] names = new String[50];
    static int[] rolls = new int[50];
    static int[] totalClasses = new int[50];
    static int[] attendedClasses = new int[50];

    static int count = 0;

    // GUI components
    JTextField rollField;
    JTextField nameField;
    JTextField totalField;
    JTextField attendedField;

    JTextArea outputArea;

    // Constructor
    public StudentAttendanceManagementGUI() {

        // Window title
        setTitle("Student Attendance Management System");

        // Window size
        setSize(700, 600);

        // Close program when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel title = new JLabel(
                "STUDENT ATTENDANCE MANAGEMENT SYSTEM",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 20));

        mainPanel.add(title, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        inputPanel.add(rollField);

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Total Classes:"));
        totalField = new JTextField();
        inputPanel.add(totalField);

        inputPanel.add(new JLabel("Classes Attended:"));
        attendedField = new JTextField();
        inputPanel.add(attendedField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));

        JButton registerButton = new JButton("Register Student");
        JButton attendanceButton = new JButton("Add Attendance");
        JButton percentageButton = new JButton("Check Percentage");
        JButton eligibilityButton = new JButton("Check Eligibility");
        JButton searchButton = new JButton("Search Student");
        JButton reportButton = new JButton("Attendance Report");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(registerButton);
        buttonPanel.add(attendanceButton);
        buttonPanel.add(percentageButton);

        buttonPanel.add(eligibilityButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(reportButton);

        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        mainPanel.add(scrollPane, BorderLayout.EAST);

        // Register button
        registerButton.addActionListener(e -> registerStudent());

        // Attendance button
        attendanceButton.addActionListener(e -> enterAttendance());

        // Percentage button
        percentageButton.addActionListener(e -> checkPercentage());

        // Eligibility button
        eligibilityButton.addActionListener(e -> checkEligibility());

        // Search button
        searchButton.addActionListener(e -> searchStudent());

        // Report button
        reportButton.addActionListener(e -> showReport());

        // Clear button
        clearButton.addActionListener(e -> clearFields());

        // Exit button
        exitButton.addActionListener(e -> System.exit(0));

        // Add main panel to window
        add(mainPanel);

        // Display window
        setVisible(true);
    }

    // Register a new student
    public void registerStudent() {

        try {

            if (count >= 50) {
                JOptionPane.showMessageDialog(
                        this,
                        "Student limit reached!"
                );
                return;
            }

            int roll = Integer.parseInt(rollField.getText());

            String name = nameField.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter student name."
                );
                return;
            }

            // Check duplicate roll number
            if (search(roll) != -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Roll number already exists."
                );
                return;
            }

            rolls[count] = roll;
            names[count] = name;

            totalClasses[count] = 0;
            attendedClasses[count] = 0;

            count++;

            outputArea.setText(
                    "Student registered successfully!\n\n" +
                    "Roll Number: " + roll + "\n" +
                    "Name: " + name
            );

            clearFields();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid roll number."
            );
        }
    }

    // Enter attendance
    public void enterAttendance() {

        try {

            int roll = Integer.parseInt(rollField.getText());

            int index = search(roll);

            if (index == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found."
                );

                return;
            }

            int total = Integer.parseInt(totalField.getText());
            int attended = Integer.parseInt(attendedField.getText());

            if (total <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Total classes must be greater than 0."
                );

                return;
            }

            if (attended < 0 || attended > total) {

                JOptionPane.showMessageDialog(
                        this,
                        "Attended classes cannot be more than total classes."
                );

                return;
            }

            totalClasses[index] = total;
            attendedClasses[index] = attended;

            double percentage = getPercentage(index);

            outputArea.setText(
                    "Attendance saved successfully!\n\n" +
                    "Student: " + names[index] + "\n" +
                    "Roll Number: " + roll + "\n" +
                    "Total Classes: " + total + "\n" +
                    "Classes Attended: " + attended + "\n" +
                    String.format("Attendance: %.2f%%", percentage)
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers."
            );
        }
    }

    // Calculate attendance percentage
    public double getPercentage(int index) {

        if (totalClasses[index] == 0) {
            return 0;
        }

        return (attendedClasses[index] * 100.0)
                / totalClasses[index];
    }

    // Search student using roll number
    public int search(int roll) {

        for (int i = 0; i < count; i++) {

            if (rolls[i] == roll) {
                return i;
            }
        }

        return -1;
    }

    // Check percentage
    public void checkPercentage() {

        try {

            int roll = Integer.parseInt(rollField.getText());

            int index = search(roll);

            if (index == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found."
                );

                return;
            }

            double percentage = getPercentage(index);

            outputArea.setText(
                    "ATTENDANCE PERCENTAGE\n\n" +
                    "Student: " + names[index] + "\n" +
                    "Roll Number: " + roll + "\n\n" +
                    String.format(
                            "Attendance: %.2f%%",
                            percentage
                    )
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid roll number."
            );
        }
    }

    // Check eligibility
    public void checkEligibility() {

        try {

            int roll = Integer.parseInt(rollField.getText());

            int index = search(roll);

            if (index == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found."
                );

                return;
            }

            double percentage = getPercentage(index);

            if (percentage >= 75) {

                outputArea.setText(
                        "ELIGIBILITY RESULT\n\n" +
                        "Student: " + names[index] + "\n" +
                        "Attendance: " +
                        String.format("%.2f%%", percentage) +
                        "\n\nSTATUS: ELIGIBLE"
                );

            } else {

                outputArea.setText(
                        "ELIGIBILITY RESULT\n\n" +
                        "Student: " + names[index] + "\n" +
                        "Attendance: " +
                        String.format("%.2f%%", percentage) +
                        "\n\nSTATUS: NOT ELIGIBLE"
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid roll number."
            );
        }
    }

    // Search student
    public void searchStudent() {

        try {

            int roll = Integer.parseInt(rollField.getText());

            int index = search(roll);

            if (index == -1) {

                outputArea.setText(
                        "Student not found."
                );

            } else {

                double percentage = getPercentage(index);

                outputArea.setText(
                        "STUDENT DETAILS\n\n" +
                        "Roll Number: " + rolls[index] + "\n" +
                        "Name: " + names[index] + "\n" +
                        "Total Classes: " +
                        totalClasses[index] + "\n" +
                        "Classes Attended: " +
                        attendedClasses[index] + "\n" +
                        String.format(
                                "Attendance: %.2f%%",
                                percentage
                        )
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid roll number."
            );
        }
    }

    // Display complete attendance report
    public void showReport() {

        if (count == 0) {

            outputArea.setText(
                    "No students registered yet."
            );

            return;
        }

        StringBuilder report = new StringBuilder();

        report.append(
                "========== ATTENDANCE REPORT ==========\n\n"
        );

        for (int i = 0; i < count; i++) {

            double percentage = getPercentage(i);

            report.append(
                    "Roll Number: " + rolls[i] + "\n"
            );

            report.append(
                    "Name: " + names[i] + "\n"
            );

            report.append(
                    "Total Classes: " +
                    totalClasses[i] + "\n"
            );

            report.append(
                    "Classes Attended: " +
                    attendedClasses[i] + "\n"
            );

            report.append(
                    String.format(
                            "Attendance: %.2f%%\n",
                            percentage
                    )
            );

            if (percentage >= 75) {

                report.append(
                        "Status: Eligible\n"
                );

            } else {

                report.append(
                        "Status: Not Eligible\n"
                );
            }

            report.append(
                    "----------------------------------------\n"
            );
        }

        outputArea.setText(report.toString());
    }

    // Clear input fields
    public void clearFields() {

        rollField.setText("");
        nameField.setText("");
        totalField.setText("");
        attendedField.setText("");
    }

    // Main method
    public static void main(String[] args) {

        new StudentAttendanceManagementGUI();
    }
}