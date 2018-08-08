import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Roster roster;
    private static ArrayList<Double> grades;

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> studentsRawInfo = readGrades();
        processGrades(studentsRawInfo);
        roster.displayStudentInfo();
        roster.generateStatData();


    }

    public static ArrayList<String> readGrades() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input file => ");
        String file = scanner.nextLine();
        String fileName = System.getProperty("user.dir") + "/" + file;
        ArrayList<String> studentStrs = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            String studentRecord = bufferedReader.readLine();
            while (studentRecord != null) {
                studentStrs.add(studentRecord);
                studentRecord = bufferedReader.readLine();
            }
            if (bufferedReader != null)
                bufferedReader.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return studentStrs;
    }

    public static void processGrades(ArrayList<String> studentRecords) {
        ArrayList<Student> students = new ArrayList<>();
        roster = new Roster(students);
        grades = new ArrayList<>();
        for (String record : studentRecords) {
            String firstName = record.split(" ")[0];
            String lastName = record.split(" ")[1];
            int cla = Integer.parseInt(record.split(" ")[2]);
            int ola = Integer.parseInt(record.split(" ")[3]);
            int test1 = Integer.parseInt(record.split(" ")[4]);
            int test2 = Integer.parseInt(record.split(" ")[5]);
            int finalGrade = Integer.parseInt(record.split(" ")[6]);
            double avg = (cla + ola + test1 + test2 + finalGrade) / 5.0;
            grades.add(avg);
            Student student = new Student(firstName, lastName, cla, ola, test1, test2, finalGrade, avg, setLetterGrade(avg));
            student.setAverageScore(avg);
            roster.addNewStudent(student);
        }
        Collections.sort(students);
        roster.setStudents(students);
        roster.setAverageGrades(grades);
    }

    private static String setLetterGrade(double averageScore) {
        double avg = Math.round(averageScore);
        String grd = "";
        if (avg >= 90)
            grd = "A";
        else if (avg >= 80)
            grd = "B";
        else if (avg >= 70)
            grd = "C";
        else if (avg >= 60)
            grd = "D";
        else
            grd = "F";
        return grd;
    }

}
