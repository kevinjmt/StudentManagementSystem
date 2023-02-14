import database.*;
import database.Module;

public class Main {
    public static void main(String[] args) {

        // -----   TESTS   -----

        StudentManagementSystem school1 = new StudentManagementSystem();

        school1.AddStudent("Maxence");

        school1.PrintStudentList();

        school1.AddModule("Maxence", "POO", 2);
        school1.AddModule("Maxence", "Frontend", 1);
        school1.AddModule("Maxence", "BackEnd", 1);

        school1.AddGrade("Maxence", "POO", "A", 2);
        school1.AddGrade("Maxence", "POO", "C", 2);

        school1.PrintStudentModuleList("Maxence");
        school1.PrintGradeList("Maxence", "POO");

        school1.PrintStudentList();
    }
}