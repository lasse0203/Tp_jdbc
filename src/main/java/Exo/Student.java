package Exo;

import Exo.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Student {


    private static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        Connection connection = null;
        System.out.println("Enter your lastname plz: ");
        String lastname = scanner.nextLine();
        System.out.println("Enter your firstname plz: ");
        String firstname = scanner.nextLine();
        System.out.println("Enter your class number plz: ");
        int classNumber = scanner.nextInt();
        System.out.println("Enter your graduation date  plz: format ( yyyy-MM-dd) ");
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate degreeDate = LocalDate.parse(dateString, formatter);

        String request = "INSERT INTO student (last_name, first_name, class_number, degree_date ) VALUES('" + lastname + "','" + firstname + "','" + classNumber + "','" + degreeDate + "')";
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            Statement statement = connection.createStatement();

            boolean res = statement.execute(request);
            if (res) {
                System.out.println("Student added successfully ! ");
            } else {
                System.out.println("Error adding student !");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void listStudents() {
        Connection connection = null;
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            String request = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " , " + resultSet.getString("last_name")
                        + " , " + resultSet.getString("first_name") + " , " +
                        resultSet.getString("class_number") + " , " + resultSet.getString("degree_date"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static void deleteStudent() {
        listStudents();
        System.out.println("which student would like to delete? ");
        int idStudent = scanner.nextInt();

        Connection connection = null;
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            String request = "DELETE FROM student where id = " + idStudent;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }
    public static void studentByClass(){
        listStudents();
        System.out.println("which classroom do you like to check? ");
        int classNumber = scanner.nextInt();

       Connection connection = null;
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            String request = "select * FROM student where class_number = " + classNumber;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " , " + resultSet.getString("last_name")
                        + " , " + resultSet.getString("first_name") + " , " +
                        resultSet.getString("class_number") + " , " + resultSet.getString("degree_date"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }


    }

}