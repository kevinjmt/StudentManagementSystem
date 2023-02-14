package database;

public class Grade {

    //   ATTRIBUTS
    private String grade;
    private int credits;

    //   GETTERS

    protected String getGrade() {
        return grade;
    }

    protected int getCredits() {
        return credits;
    }

    //   SETTERS


    protected void setGrade(String grade) {
        this.grade = grade;
    }

    protected void setCredits(int credits) {
        this.credits = credits;
    }

    //   CONSTRUCTOR

    protected Grade(String grade, int credits){
        this.grade = grade;
        this.credits = credits;
    }
}
