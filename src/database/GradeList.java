package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GradeList {

    //   ATTRIBUTES
    private List<Grade> listofGrade;

    private double gradeListMean;

    //   GETTERS
    protected List<Grade> getListofGrade() {
        return listofGrade;
    }

    protected double getGradeListMean() {
        computeGPA();
        return gradeListMean;
    }

    //   CONSTRUCTOR

    protected GradeList(){
        this.gradeListMean = 0;
        this.listofGrade = new ArrayList<>();
    }

    //   METHODS

    private void computeGPA(){
        double mean = 0;
        double coeffs = 0;
        double sum = 0;

        for(int i = 0; i < listofGrade.size(); i++){
            coeffs += listofGrade.get(i).getCredits();
            for (int j = 0; j < listofGrade.get(i).getCredits(); j++) {
                switch (listofGrade.get(i).getGrade()){
                    case "A":
                        sum += 4;
                        break;
                    case "B":
                        sum += 3;
                        break;
                    case "C":
                        sum += 2;
                        break;
                    case "D":
                        sum += 1;
                        break;
                    default:
                        break;
                }
            }
        }
        if (coeffs != 0) {
            mean = sum / coeffs;
            this.gradeListMean = mean;
        }
    }

    protected void PrintGradeList(){
        System.out.println("List of grades:");
        for (Grade grade : listofGrade) {
            System.out.println("   -> " + grade.getGrade() + " (" + grade.getCredits() + ")");
        }
    }

    // FUNCTIONS

    protected void AddGrade(String grade, int credits){
        Grade newgrade;
        if (grade.equals("A") || grade.equals("B") || grade.equals("C")
                || grade.equals("D") || grade.equals("F")) newgrade = new GradeString(grade, credits);
        else newgrade = new GradeInt(grade, credits);
        listofGrade.add(newgrade);
    }

    protected Grade SearchGrade(String gradename, int credits){
        Optional<Grade> moduleSearched =
                listofGrade.stream().filter
                        (grade -> grade.getGrade().equalsIgnoreCase(gradename) &&
                                grade.getCredits() == credits).findFirst();
        if (moduleSearched.isPresent()) return moduleSearched.get();
        return null;
    }

    protected void DeleteGrade(String moduleName, int credits){
        listofGrade.remove(SearchGrade(moduleName, credits));
    }


}
