# 📚 Student Attendance Management System

A simple, menu-driven **Java console application** designed to manage student attendance, calculate attendance percentages, check eligibility, search student records, and generate attendance reports.

---

## 📌 About the Project

The **Student Attendance Management System** is a Java-based console application created to simplify basic student attendance management.

The system allows users to register students, record their attendance, calculate attendance percentages, determine whether students meet the required **75% attendance criteria**, search for individual students, and generate an attendance report.

The project demonstrates how fundamental Java programming concepts can be combined to build a practical real-world application.

---

## 🎯 Problem Statement

Managing attendance manually can be time-consuming and can make it difficult to quickly calculate percentages or identify students with low attendance.

This project provides a simple console-based solution where student information and attendance can be entered, processed, searched, and displayed through an easy-to-use menu.

---

## ✨ Features

- 👤 **Student Registration**
  - Register students using roll number and name.
  - Prevent duplicate roll numbers.

- 📝 **Attendance Entry**
  - Enter total classes conducted.
  - Enter classes attended.
  - Validate attendance values.

- 📊 **Attendance Calculation**
  - Automatically calculate attendance percentage.

- ✅ **Eligibility Checking**
  - Check whether attendance is at least 75%.
  - Display `Eligible` or `Not Eligible`.

- 🔍 **Student Search**
  - Search for a student using their roll number.
  - Display the student's attendance information.

- 📋 **Attendance Report**
  - Display attendance details of all registered students.

- 🛡️ **Input Validation**
  - Handle invalid numbers.
  - Prevent negative values.
  - Prevent attended classes from exceeding total classes.
  - Handle duplicate roll numbers.
  - Handle invalid menu choices.

---

## 🧮 Attendance Calculation

The system calculates attendance using:

```text
Attendance Percentage =
(Classes Attended / Total Classes) × 100
For example:

Classes Attended = 32
Total Classes    = 40

Attendance = (32 / 40) × 100
           = 80%
Eligibility Rule
Attendance ≥ 75%  → Eligible
Attendance < 75%  → Not Eligible
🏗️ System Modules

The application is divided into the following modules:

1. Student Registration

Allows the user to register a new student by entering their roll number and name.

2. Attendance Entry

Allows attendance information to be entered for a registered student.

3. Percentage Calculation

Calculates the student's attendance percentage based on total classes and attended classes.

4. Eligibility Check

Compares the calculated percentage with the required 75% attendance.

5. Student Search

Searches for a student using their roll number and displays their details.

6. Attendance Report

Displays the attendance percentage and eligibility status of all registered students.

🧠 Java Concepts Used

This project demonstrates the practical use of:

Arrays
Variables
Methods
Scanner
for loops
do-while loops
if-else
switch-case
Arithmetic operators
Comparison operators
Input validation
Linear searching
Formatted output
🗂️ Data Storage

The application uses parallel arrays to store student information.

names[]
rolls[]
totalClasses[]
attendedClasses[]

Each array position represents the same student.

For example:

Index 0
 ├── Student Name
 ├── Roll Number
 ├── Total Classes
 └── Classes Attended

The application can store up to 50 students in the current implementation.

🔄 Application Flow
Start
  ↓
Display Menu
  ↓
Register Student
  OR
Enter Attendance
  OR
Search Student
  OR
Generate Attendance Report
  OR
Exit
  ↓
Process User Input
  ↓
Display Result
  ↓
Return to Menu
  ↓
Exit
🛡️ Validation & Error Handling

The application handles common invalid inputs such as:

Duplicate student roll numbers
Unregistered student searches
Negative class values
Zero total classes
Attendance greater than total classes
Invalid menu options
Non-numeric input

This helps prevent incorrect information from being stored in the system.

🚀 How to Run
Prerequisites

Make sure Java is installed on your system.

Check the Java version:

java --version
Compile
javac AttendanceSystem.java
Run
java AttendanceSystem
📈 Future Enhancements

The current console application can be extended into a more complete attendance management system by adding:

🗄️ Database integration using MySQL or PostgreSQL
🔐 Teacher and administrator login
🖥️ Graphical User Interface
📅 Date-wise attendance tracking
📄 PDF or Excel report generation
☁️ Cloud-based data storage
🔔 Low-attendance notifications
👨‍🎓 Detailed student profiles
📊 Attendance statistics and analytics
⚠️ Current Limitations

Data is stored in memory using arrays.
Data is lost when the program is closed.
The current implementation supports up to 50 students.
No database is connected.
No login or authentication system is included.
The application uses a console interface.
🎓 Learning Outcomes

This project helped demonstrate how basic Java concepts can be combined to create a complete working application.

Through this project, the following were practised:

Arrays
   ↓
Input Handling
   ↓
Methods
   ↓
Loops
   ↓
Conditions
   ↓
Searching
   ↓
Validation
   ↓
Calculations
   ↓
Report Generation
📌 Project Summary

The Student Attendance Management System provides a simple and efficient way to manage basic student attendance through a Java console application.

It combines student registration, attendance recording, percentage calculation, eligibility checking, searching, validation, and reporting into a single menu-driven system.

The project focuses on applying fundamental Java programming concepts to solve a practical academic problem.

⭐ Project Status

Completed — Java Console Application

Built using fundamental Java programming concepts with a focus on simplicity, validation, and practical application.


This is much more suitable for a **GitHub project README** because it describes the project itself rather than looking like a college report.
