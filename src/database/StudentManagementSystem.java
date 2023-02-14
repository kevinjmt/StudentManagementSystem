package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagementSystem {

    // ATTRIBUTES

    private List<Student> studentList;

    // GETTERS


    public List<Student> getStudentList() {
        return studentList;
    }

    // CONSTRUCTORS

    public StudentManagementSystem(){
        this.studentList = new ArrayList<>();
    }


    // METHODS

    public void PrintStudentList(){
        System.out.println("----------------------------------------------");
        System.out.println("Student List:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("   -> " + studentList.get(i).getName() + " | " + studentList.get(i).getStudentGrade());
        }
        System.out.println("----------------------------------------------");
    }



    // FUNCTIONS

    // GRADES

    public List<Grade> GetListOfGrades(String studentname, String modulename){
        Student searched = SearchStudent(studentname);
        Module module = searched.SearchModule(modulename);
        return module.getGradeList().getListofGrade();
    }

    public void AddGrade(String studentname, String modulename, String grade, int credits) {
        Student searched = SearchStudent(studentname);
        Module studentmodule = searched.SearchModule(modulename);
        studentmodule.getGradeList().AddGrade(grade, credits);
    }

    public void DeleteGrade(String studentname, String modulename, String grade, int credits) {
        Student searched = SearchStudent(studentname);
        Module studentmodule = searched.SearchModule(modulename);
        studentmodule.getGradeList().DeleteGrade(grade, credits);
    }

    public void PrintGradeList(String studentname, String studentmodule) {
        Student searched = SearchStudent(studentname);
        Module module = searched.SearchModule(studentmodule);
        module.getGradeList().PrintGradeList();
    }



    // MODULES

    public void PrintStudentModuleList(String studentname){
        List<Module> moduleList = GetStudentModuleList(studentname);
        System.out.println(studentname);
        for (Module module : moduleList) {
            System.out.println("   -> " + module.getModuleID() + " | " + module.getName() + " (" +
                    module.getModuleCredits() + ")");
        }
    }

    public void AddModule(String studentname, String name, int moduleCredits){
        Student searched = SearchStudent(studentname);
        searched.AddModule(name, moduleCredits);
    }

    public void DeleteModule(String studentname, String modulename){
        Student searched = SearchStudent(studentname);
        searched.DeleteModule(modulename);
    }

    public List<Module> GetStudentModuleList(String studentName){
        Student student = SearchStudent(studentName);
        return student.getModuleList();
    }


    // STUDENT

    public List<Module> GetModuleList(String studentname){
        Student searched = SearchStudent(studentname);
        return searched.getModuleList();
    }

    public int GetModuleID(String studentname, String modulename){
        Student searched = SearchStudent(studentname);
        return searched.SearchModule(modulename).getModuleID();
    }

    public int GetStudentID(String studentname){
        Student searched = SearchStudent(studentname);
        return searched.getStudentID();
    }

    public double GetStudentGrade(String studentname){
        Student searched = SearchStudent(studentname);
        return searched.getStudentGrade();
    }

    public Student SearchStudent(String Name){
        Optional<Student> searchedstudent =
                studentList.stream().filter(student -> student.getName().equalsIgnoreCase(Name)).findFirst();
        if (searchedstudent.isPresent()) return searchedstudent.get();
        return null;
    }

    public void AddStudent(String name){
        Student newstudent = new Student(name);
        this.studentList.add(newstudent);
    }

    public void DeleteStudent(String name){
        this.studentList.remove(SearchStudent(name));
    }

}
