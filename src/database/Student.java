package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student {



    //   ATTRIBUTS
    private String name;

    private List<Module> moduleList;

    private static int idCounter = 0;
    private final int studentID;

    private double studentGrade;

    //   GETTERS

    protected String getName() {
        return name;
    }

    protected List<Module> getModuleList() {
        return moduleList;
    }

    protected final int getStudentID() {
        return studentID;
    }

    protected double getStudentGrade() {
        computeStudentGrade();
        return studentGrade;
    }

    //   SETTERS

    protected void setName(String name) {
        this.name = name;
    }


    //   CONSTRUCTOR

    protected Student(String name){
        this.name = name;
        this.moduleList = new ArrayList<>();
        this.studentID = idCounter++;
        this.studentGrade = 0;
    }

    // METHODS



    protected void computeStudentGrade(){
        double mean = 0;
        double meanmodule = 0;
        double coeffs = 0;
        double sum = 0;

        for (int i = 0; i < moduleList.size(); i++) {
            meanmodule = moduleList.get(i).getGradeList().getGradeListMean();
            if (meanmodule != 0){
                coeffs += moduleList.get(i).getModuleCredits();
                for (int j = 0; j < moduleList.get(i).getModuleCredits(); j++) {
                    sum += meanmodule;
                }
            }
        }
        if (coeffs != 0) {
            mean = sum / coeffs;
            this.studentGrade = mean;
        }
    }

    // FUNCTIONS

    protected void AddModule(String name, int moduleCredits){
        this.moduleList.add(new Module(name, moduleCredits));
    }

    protected Module SearchModule(String moduleName){
        Optional<Module> moduleSearched =
                moduleList.stream().filter(student -> student.getName().equalsIgnoreCase(moduleName)).findFirst();
        if (moduleSearched.isPresent()) return moduleSearched.get();
        return null;
    }

    protected void DeleteModule(String moduleName){
        moduleList.remove(SearchModule(moduleName));
    }
}
