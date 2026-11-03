package lt.vcd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int subjects = scanner.nextInt();
        int students = scanner.nextInt();

        double[] averages = new double[students];
        boolean[] hasLowGrade = new boolean[students];
        double totalSum = 0;
        double maxAverage = -1;

        for (int i = 0; i < students; i++) {
            double studentSum = 0;
            for (int j = 0; j < subjects; j++) {
                int grade = scanner.nextInt();
                studentSum += grade;
                if (grade < 5) {
                    hasLowGrade[i] = true;
                }
            }
            averages[i] = studentSum / subjects;
            totalSum += averages[i];

            if (averages[i] > maxAverage) {
                maxAverage = averages[i];
            }
        }


        System.out.println("Student averages:");
        for (int i = 0; i < students; i++) {
            if (averages[i] == (int) averages[i]) {
                System.out.println((int) averages[i]);
            } else {
                System.out.println(averages[i]);
            }
        }


        System.out.println("\nGroup average:");
        double groupAvg = totalSum / students;
        System.out.println(groupAvg);


        System.out.println("\nHighest-performing student:");
        for (int i = 0; i < students; i++) {
            
            if (Math.abs(averages[i] - maxAverage) < 1e-9) {
                System.out.println(i + 1);
            }
        }


        System.out.println("\nStudents with at least one grade below 5:");
        boolean anyLow = false;
        for (int i = 0; i < students; i++) {
            if (hasLowGrade[i]) {
                System.out.println(i + 1);
                anyLow = true;
            }
        }
        if (!anyLow) {
            System.out.println("None");
        }

        scanner.close();
    }
}
