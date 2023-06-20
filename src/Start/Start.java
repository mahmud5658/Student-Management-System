package Start;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import student.StudentManagement;


import java.util.InputMismatchException;

public class Start {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("      W E L C O M E      ");
        System.out.println("           TO      ");
        System.out.println("STUDENT MANAGEMENT SYSTEM\n");
        try{
            StudentManagement.runStudentOperation();
        }catch (InputMismatchException error){
            System.out.println("Error: invalid input given");
        }catch (InvalidInputException error){
            System.out.println("Error: "+error.toString());
        }catch (FileReadWriteException error){
            System.out.println("Error: "+error.toString());
        }catch (Exception error){
            System.out.println("Error: "+error.toString());
        }
    }
}
