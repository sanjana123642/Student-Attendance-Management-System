import java.util.Scanner;

public class StudentAttendanceManagement {

    static Scanner sc = new Scanner(System.in);

    static String[] names = new String[50];
    static int[] rolls = new int[50];
    static int[] totalClasses = new int[50];
    static int[] attendedClasses = new int[50];

    static int count = 0;

    // Register a new student
    public static void registerStudent() {

        System.out.print("Enter Roll Number: ");
        rolls[count] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        names[count] = sc.nextLine();

        totalClasses[count] = 0;
        attendedClasses[count] = 0;

        count++;

        System.out.println("Student registered successfully!");
    }

    // Enter attendance for a student
    public static void enterAttendance() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        int index = search(roll);

        if (index == -1) {
            System.out.println("Student not found.");
        } else {

            System.out.print("Enter Total Classes: ");
            totalClasses[index] = sc.nextInt();

            System.out.print("Enter Classes Attended: ");
            attendedClasses[index] = sc.nextInt();

            if (attendedClasses[index] > totalClasses[index]) {
                System.out.println("Error: Attended classes cannot be more than total classes.");
            } else {
                System.out.println("Attendance saved successfully.");
            }
        }
    }

    // Calculate attendance percentage
    public static double getPercentage(int index) {

        if (totalClasses[index] == 0) {
            return 0;
        }

        double percentage =
                (attendedClasses[index] * 100.0) / totalClasses[index];

        return percentage;
    }

    // Search student using roll number
    public static int search(int roll) {

        for (int i = 0; i < count; i++) {

            if (rolls[i] == roll) {
                return i;
            }
        }

        return -1;
    }

    // Display attendance report
    public static void showReport() {

        if (count == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        System.out.println("\n----- ATTENDANCE REPORT -----");

        for (int i = 0; i < count; i++) {

            double percentage = getPercentage(i);

            System.out.println("Roll Number: " + rolls[i]);
            System.out.println("Name: " + names[i]);

            System.out.printf("Attendance: %.2f%%\n", percentage);

            if (percentage >= 75) {
                System.out.println("Status: Eligible");
            } else {
                System.out.println("Status: Not Eligible");
            }

            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT ATTENDANCE MANAGEMENT =====");
            System.out.println("1. Register Student");
            System.out.println("2. Add Attendance");
            System.out.println("3. Check Attendance Percentage");
            System.out.println("4. Check Eligibility");
            System.out.println("5. Attendance Report");
            System.out.println("6. Search Student");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    enterAttendance();
                    break;

                case 3:

                    System.out.print("Enter Roll Number: ");
                    int roll1 = sc.nextInt();

                    int index1 = search(roll1);

                    if (index1 != -1) {
                        System.out.printf(
                                "Attendance Percentage: %.2f%%\n",
                                getPercentage(index1)
                        );
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Roll Number: ");
                    int roll2 = sc.nextInt();

                    int index2 = search(roll2);

                    if (index2 != -1) {

                        double percentage = getPercentage(index2);

                        if (percentage >= 75) {
                            System.out.println("Student is Eligible.");
                        } else {
                            System.out.println("Student is Not Eligible.");
                        }

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:
                    showReport();
                    break;

                case 6:

                    System.out.print("Enter Roll Number: ");
                    int roll3 = sc.nextInt();

                    int index3 = search(roll3);

                    if (index3 != -1) {

                        System.out.println("Student Name: " + names[index3]);
                        System.out.println(
                                "Attendance: " +
                                getPercentage(index3) + "%"
                        );

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 7:
                    System.out.println("Thank you! Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}