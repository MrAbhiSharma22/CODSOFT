import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter the number of subjects: ");
        int tSubjects = scanner.nextInt();
        
        int[] marks = new int[tSubjects];
        
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < tSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        
        int tMarks = 0;
        for (int mark : marks) {
            tMarks += mark;
        }

        double avgPercentage = (double) tMarks / tSubjects;

        char grd;
        if (avgPercentage >= 90) {
            grd = 'A';
        } else if (avgPercentage >= 80) {
            grd = 'B';
        } else if (avgPercentage >= 70) {
            grd = 'C';
        } else if (avgPercentage >= 60) {
            grd = 'D';
        } else {
            grd = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + tMarks);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("grd: " + grd);
        
        scanner.close();
    }
}
