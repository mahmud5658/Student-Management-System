package student.classes;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import operations.Operations;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentOperations implements Operations {
    StudentIO studentIO;
    Scanner sc;

    public StudentOperations() {
        studentIO = new StudentIO();
        sc = new Scanner(System.in);
    }

    @Override
    public void add() throws Exception {
        try {
            System.out.println("\n-----Enter Student Information-----");
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Department: ");
            sc.nextLine();
            String department = sc.nextLine();

            System.out.print("Section: ");
            String section = sc.nextLine();

            System.out.print("Gender(Male/Female): ");
            String gender = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Credit passed: ");
            int creditPassed = sc.nextInt();

            Student newStudent = new Student(id, name, age, department, section, gender, cgpa, creditPassed);
            studentIO.WriteIntoFile(newStudent);
            System.out.println("-----///-----New student added-----///-----");
            sc.nextLine();
        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given");
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void search() throws Exception {
        try {
            System.out.print("\nEnter student ID to search: ");
            String id = sc.nextLine();
            Student student = studentIO.searchFromFile(id);
            if (student.getId() == null) {
                System.out.println("///===No student found with this ID===///");
            } else {
                student.showDetails();
            }

        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void delete() throws Exception {
        try {
            System.out.println("\nEnter student ID to delete: ");
            String id = sc.nextLine();
            Student student = studentIO.searchFromFile(id);
            if (student.getId() == null) {
                System.out.println("///===No student found with this ID===///");
            } else {
                String studentString = student.studentToString() + "\r\n\r\n";
                studentIO.updateData(studentString, "");
                System.out.println("\n----///----Student data deleted----///----");
            }

        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void update() throws Exception {
        try {
            System.out.println("\nEnter student ID to update: ");
            String id = sc.nextLine();
            Student student = studentIO.searchFromFile(id);
            if (student.getId() == null) {
                System.out.println("No student found with this ID");
            } else {
                String studentString = student.studentToString();
                System.out.println("\n----Edit student Information----");
                System.out.print("Name(" + student.getName() + "): ");
                String name = sc.nextLine();
                System.out.print("Age(" + student.getAge() + "): ");
                String age = sc.nextLine();
                System.out.print("Department(" + student.getDepartment() + "): ");
                String department = sc.nextLine();
                System.out.print("Section(" + student.getSection() + "): ");
                String section = sc.nextLine();
                System.out.print("Gender(" + student.getGender() + "): ");
                String gender = sc.nextLine();
                System.out.print("CGPA(" + student.getCgpa() + "): ");
                String cgpa = sc.nextLine();
                System.out.print("CreditPassed(" + student.getCreditPassed() + "): ");
                String creditPassed = sc.nextLine();

                Student updatedStudent = new Student(
                        student.getId(),
                        name == "" ? student.getName() : name,
                        age == "" ? student.getAge() : Integer.parseInt(age),
                        department == "" ? student.getDepartment() : department,
                        section == "" ? student.getSection() : section,
                        gender == "" ? student.getGender() : gender,
                        cgpa == "" ? student.getCgpa() : Double.parseDouble(cgpa),
                        creditPassed == "" ? student.getCreditPassed() : Integer.parseInt(creditPassed));
                String updatedStudentString = updatedStudent.studentToString();
                studentIO.updateData(studentString, updatedStudentString);
                System.out.println("\n----//----Student data updated----//----");
            }
        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given.");
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }
    @Override
    public void showAll() throws Exception {
        try {
            Student[] students = studentIO.getAllStudent();
            for (Student student : students) {
                student.showDetails();
            }
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }
}
