package Exo;

import Exo.utils.DatabaseManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {


    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        Connection connection = null;

        System.out.print(" Enter your lastname plz : ");
        student.setLastname(scanner.next());
        System.out.print("Enter your firstname plz : ");
        student.setFirstname(scanner.next());
        System.out.print("Enter your class number plz ");
        student.setClassNumber(Integer.parseInt(scanner.next()));
        System.out.print("Enter your graduation date  plz: format ( yyyy-MM-dd) ");
        student.setDegreeDate(LocalDate.parse(scanner.next()));
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate degreeDate = LocalDate.parse(dateString, formatter);*/


        String query = "INSERT INTO student (last_name, first_name, class_number, degree_date ) VALUES (?, ?, ?, ?)";

        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getLastname());
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setInt(3, student.getClassNumber());
            preparedStatement.setDate(4, Date.valueOf(student.getDegreeDate()));

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student added Successfully !");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("which student would like to delete? ");
        getAllStudents();
        int idStudent = scanner.nextInt();

        Connection connection = null;
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            String request = "DELETE FROM student where id = " + idStudent;
            Statement statement = connection.createStatement();
            ResultSet resultSet = ((Statement) statement).executeQuery(request);

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

    public static void studentByClass() {
    }

      public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
            String query = "SELECT * FROM student";

            try {
                connection = DatabaseManager.getPostgreSQLConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setLastname(resultSet.getString("last_name"));
                    student.setFirstname(resultSet.getString("first_name"));
                    student.setClassNumber(resultSet.getInt("class_number"));
                    student.setDegreeDate(resultSet.getDate("degree_date").toLocalDate());
                    students.add(student);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return students;
        }



    }
