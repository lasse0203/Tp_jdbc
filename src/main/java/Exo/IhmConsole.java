package Exo;
import Exo.utils.DatabaseManager;

import java.util.List;
import java.util.Scanner;

import static Exo.StudentManager.getAllStudents;

public class IhmConsole {

    public static void Menu() {
        int choix;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=== Menu principal ===");
            System.out.println();
            System.out.println("1. List of students");
            System.out.println("2. Student by classroom");
            System.out.println("3. delete a student");
            System.out.println("4. quit");


            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    getAllStudent();
                    break;
                case 2:
                    StudentManager.studentByClass();
                    break;
                case 3:
                    StudentManager.deleteStudent();
                    break;
                case 4:
                    System.out.println("Bye bye");
                    break;

                default:
                    System.out.println("Invalid number please try again !");

            }

        } while (choix != 4);

        scanner.close();
    }


    public static void getAllStudent() {
        // Your existing code for adding a student

        List<Student> studentList = getAllStudents();

        System.out.println("List of students:");
        for (Student student : studentList) {
            System.out.println(" id : " + student.getId());
            System.out.println("Last Name: " + student.getLastname());
            System.out.println("First Name: " + student.getFirstname());
            System.out.println("Class Number: " + student.getClassNumber());
            System.out.println("Degree Date: " + student.getDegreeDate());

        }
    }



}









