package Exo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class  Student {

        private int id;
        private String  lastname;
        private String firstname ;
        private int classNumber ;
        private LocalDate degreeDate;

        public Student() {

        }

        public Student(String lastname, String firstname, int classNumber, LocalDate degreeDate) {

                this.lastname = lastname;
                this.firstname = firstname;
                this.classNumber = classNumber;
                this.degreeDate = degreeDate;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public int getClassNumber() {
                return classNumber;
        }

        public void setClassNumber(int classNumber) {
                this.classNumber = classNumber;
        }

        public LocalDate getDegreeDate() {
                return degreeDate;
        }

        public void setDegreeDate(LocalDate degreeDate) {
                this.degreeDate = degreeDate;
        }


        public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", lastname='" + lastname + '\'' +
                        ", firstname='" + firstname + '\'' +
                        ", classNumber=" + classNumber +
                        ", degreeDate=" + degreeDate +
                        '}';
        }




}
