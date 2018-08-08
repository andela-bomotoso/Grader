/**
 * Represents a student records.
 */

import java.util.ArrayList;

public class Roster {
    private ArrayList<Student> students;
    private ArrayList<Double> averageGrades;

    public Roster(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Double> getAverageGrades() {
        return averageGrades;
    }

    public void setAverageGrades(ArrayList<Double> averageGrades) {
        this.averageGrades = averageGrades;
    }

    public void addNewStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void displayStudentInfo() {
        System.out.println();
        System.out.println("======================================================================");
        System.out.printf("%-20s%-5s%-5s%-8s%-8s%-8s%-10s%5s\n", "Student Name", "CLA", "OLA", "test1", "test2", "Final", "Average", "Grade");
        System.out.println("======================================================================");
        System.out.println();
        for (Student student : students)
            System.out.println(student.toString());
    }

    public void generateStatData() {
        String str = "";
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;
        double sum = 0.0;
        for (double grade : averageGrades) {
            if (grade >= 90)
                aCount++;
            else if (grade >= 80)
                bCount++;
            else if (grade >= 70)
                cCount++;
            else if (grade >= 60)
                dCount++;
            else
                fCount++;
            sum += grade;
        }
        double avg = sum / (double) averageGrades.size();

        System.out.println("===========================================");
        System.out.println("GRADE\tNumber of Students");
        System.out.println("===========================================");
        System.out.printf("%s%10d\n", "A", aCount);
        System.out.printf("%s%10d\n", "B", bCount);
        System.out.printf("%s%10d\n", "C", cCount);
        System.out.printf("%s%10d\n", "D", dCount);
        System.out.printf("%s%10d\n", "F", fCount);

        System.out.println("The class average is " + avg);

        str += "===========================================\n";
        str += "GRADE\tNumber of Students\n";
        str += "===========================================\n";
        str += String.format("%s%10d\n", "A", aCount);
        str += String.format("%s%10d\n", "B", bCount);
        str += String.format("%s%10d\n", "C", cCount);
        str += String.format("%s%10d\n", "D", dCount);
        str += String.format("%s%10d\n", "F", fCount);
    }

    public double getClassAverage() {
        double sum = 0.0;
        for (double avg : averageGrades)
            sum += avg;
        return sum / (double) averageGrades.size();
    }

    public double getStudentAverage(int ola, int cla, int test1, int test2, int finalGrade) {
        double sum = (ola + cla + test1 + test2 + finalGrade);
        return sum / 5.0;
    }
}
