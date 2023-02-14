package database;


import java.util.Optional;

public class Module {


    //   ATTRIBUTS
    private String name;
    private GradeList gradeList;
    private static int idCounter = 0;

    private final int moduleID;
    private int moduleCredits;

    //   GETTERS

    protected String getName() {
        return name;
    }

    protected GradeList getGradeList() {
        return gradeList;
    }

    protected int getModuleID() {
        return moduleID;
    }

    protected int getModuleCredits() {
        return moduleCredits;
    }

    //   SETTERS

    protected void setName(String name) {
        this.name = name;
    }

    protected void setModuleCredits(int moduleCredits) {
        this.moduleCredits = moduleCredits;
    }

    //   CONSTRUCTOR

    protected Module(String name, int moduleCredits){
        this.name = name;
        this.gradeList = new GradeList();
        this.moduleID = idCounter++;
        this.moduleCredits = moduleCredits;
    }

    // FUNCTIONS

}
