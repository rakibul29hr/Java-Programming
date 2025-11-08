import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();

        double totalCreditTaken = 0;
        double totalCreditEarned = 0;
        double totalGradePoints = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCourse " + i + ":");

            System.out.print("Credit (Max 3): ");
            double credit = sc.nextDouble();

            System.out.print("CT (Max 30): ");
            double ct = sc.nextDouble();

            System.out.print("AT (Max 10): ");
            double at = sc.nextDouble();

            System.out.print("FE (Max 60): ");
            double fe = sc.nextDouble();

            double totalMarks = ct + at + fe;
            double gradePoint = 0.0;
            String grade = "";
            if (totalMarks >= 80) {
                gradePoint = 4.0;
                grade = "A+";
            } else if (totalMarks >= 75) {
                gradePoint = 3.75;
                grade = "A";
            } else if (totalMarks >= 70) {
                gradePoint = 3.5;
                grade = "A-";
            } else if (totalMarks >= 65) {
                gradePoint = 3.25;
                grade = "B+";
            } else if (totalMarks >= 60) {
                gradePoint = 3.0;
                grade = "B";
            } else if (totalMarks >= 55) {
                gradePoint = 2.75;
                grade = "B-";
            } else if (totalMarks >= 50) {
                gradePoint = 2.5;
                grade = "C+";
            } else if (totalMarks >= 45) {
                gradePoint = 2.25;
                grade = "C";
            } else if (totalMarks >= 40) {
                gradePoint = 2.0;
                grade = "D";
            } else {
                gradePoint = 0.0;
                grade = "F";
            }
            totalCreditTaken += credit;
            if (gradePoint > 0.0) totalCreditEarned += credit;
            totalGradePoints += gradePoint * credit;

            System.out.println("Total Marks: " + totalMarks + " | Grade Point: " + gradePoint + " | Grade: " + grade);
        }

        double cgpa = totalGradePoints / totalCreditTaken;

        String finalGrade;
        if (cgpa >= 4.0)
            finalGrade = "A+";
        else if (cgpa >= 3.75)
            finalGrade = "A";
        else if (cgpa >= 3.5)
            finalGrade = "A-";
        else if (cgpa >= 3.25)
            finalGrade = "B+";
        else if (cgpa >= 3.0)
            finalGrade = "B";
        else if (cgpa >= 2.75)
            finalGrade = "B-";
        else if (cgpa >= 2.5)
            finalGrade = "C+";
        else if (cgpa >= 2.25)
            finalGrade = "C";
        else if (cgpa >= 2.0)
            finalGrade = "D";
        else
            finalGrade = "F";

        System.out.println("\n===== Result Summary =====");
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCreditTaken);
        System.out.println("Credit Earned: " + totalCreditEarned);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + finalGrade);

        sc.close();
    }
}
