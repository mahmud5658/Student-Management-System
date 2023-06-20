package student;

import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import student.classes.StudentOperations;
public class StudentManagement {
    public static void runStudentOperation() throws Exception {
        StudentOperations studentOps = new StudentOperations();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        try {
            while (option != 6) {
                System.out.println("===== MANAGE STUDENT =====");
                System.out.println();
                System.out.println("[1] Add Student");
                System.out.println("[2] Update Student Information");
                System.out.println("[3] Search Student");
                System.out.println("[4] Delete Student");
                System.out.println("[5] Show All Students Information");
                System.out.println("[6] Exit");

                System.out.print("\nSelect Option: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        studentOps.add();
                        break;
                    case 2:
                        studentOps.update();
                        break;
                    case 3:
                        studentOps.search();
                        break;
                    case 4:
                        studentOps.delete();
                        break;
                    case 5:
                        studentOps.showAll();
                        break;
                    case 6:
                        System.out.println("Program Exited");
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given");
        } catch (InvalidInputException error) {
            throw error;
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        } finally {
            sc.close();
        }
    }
}