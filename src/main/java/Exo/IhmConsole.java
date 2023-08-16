package Exo;


import java.util.Scanner;

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
                    Student.listStudents();
                    break;
                case 2:
                    Student.studentByClass();
                    break;
                case 3:
                    Student.deleteStudent();
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
}








