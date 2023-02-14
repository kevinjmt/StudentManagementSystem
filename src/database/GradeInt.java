package database;

public class GradeInt extends Grade {
    protected GradeInt(String grade, int credits) {
        super(grade, credits);
        int nb = Integer.parseInt(grade);
        switch (nb){
            case 4:
                this.setGrade("A");
                break;
            case 3:
                this.setGrade("B");
                break;
            case 2:
                this.setGrade("C");
                break;
            case 1:
                this.setGrade("D");
                break;
            case 0:
                this.setGrade("F");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + grade);
        }

    }
}
