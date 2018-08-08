/**
 * Represents a student record.
 */
public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private int cla;
    private int ola;
    private int test1;
    private int test2;
    private int finalGrade;
    private double averageScore;
    private String letterGrade;

    public Student(String firstName, String lastName, int cla, int ola, int test1, int test2, int finalGrade, double averageScore, String letterGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cla = cla;
        this.ola = ola;
        this.test1 = test1;
        this.test2 = test2;
        this.finalGrade = finalGrade;
        this.averageScore = averageScore;
        this.letterGrade = letterGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCla() {
        return cla;
    }

    public void setCla(int cla) {
        this.cla = cla;
    }

    public int getOla() {
        return ola;
    }

    public void setOla(int ola) {
        this.ola = ola;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String toString() {
        String str =
                String.format("%-10s,%-10s%-5d%-5d%-8d%-8d%-8d%-7.2f%5s", lastName, firstName
                        , cla, ola, test1, test2, finalGrade, averageScore, letterGrade);
        return str;
    }

    @Override
    public int compareTo(Student that) {
        if(!this.lastName .equals(that.lastName))
            return this.lastName.compareTo(that.lastName);
        return this.firstName.compareTo(that.firstName);

    }
}
