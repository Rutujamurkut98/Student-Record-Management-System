import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1–5): ");

            String inputChoice = sc.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number (1–5).");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID : ");
                    int studentId;
                    try {
                        studentId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter only numbers.");
                        break;
                    }

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks;
                    try {
                        marks = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks. Please enter a number.");
                        break;
                    }

                    students.add(new Student(studentId, email, name, marks));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("---------------------------------------------------------------------");
                        System.out.printf("| %-10s | %-25s | %-25s | %-5s |\n", "Student ID", "Email", "Name", "Marks");
                        System.out.println("---------------------------------------------------------------------");
                        for (Student s : students) {
                            System.out.printf("| %-10d | %-25s | %-25s | %-5.2f |\n",
                                    s.getStudentId(), s.getEmail(), s.getName(), s.getMarks());
                        }
                        System.out.println("---------------------------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean foundUpdate = false;

                    for (Student s : students) {
                        if (s.getStudentId() == updateId) {
                            System.out.print("Enter new Email: ");
                            String newEmail = sc.nextLine();

                            System.out.print("Enter new Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new Marks: ");
                            double newMarks;
                            try {
                                newMarks = Double.parseDouble(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid marks.");
                                break;
                            }

                            s.setEmail(newEmail);
                            s.setName(newName);
                            s.setMarks(newMarks);
                            System.out.println("Student updated successfully.");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean foundDelete = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentId() == deleteId) {
                            students.remove(i);
                            System.out.println("Student deleted successfully.");
                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting.....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select from 1–5.");
            }
        }
    }
}
