package lt.vcd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int d = sc.nextInt();
        int st = sc.nextInt();
        
        double[] vidurkiai = new double[st];
        boolean[] blogi = new boolean[st];
        double bendraSuma = 0;
        double maxVid = -1;
        
        for (int i = 0; i < st; i++) {
            double suma = 0;
            for (int j = 0; j < d; j++) {
                int paz = sc.nextInt();
                suma += paz;
                if (paz < 5) {
                    blogi[i] = true;
                }
            }
            vidurkiai[i] = suma / d;
            bendraSuma += vidurkiai[i];
            if (vidurkiai[i] > maxVid) {
                maxVid = vidurkiai[i];
            }
        }
        
        System.out.println("Student averages:");
        for (int i = 0; i < st; i++) {
            if (vidurkiai[i] == (int) vidurkiai[i]) {
                System.out.println((int) vidurkiai[i]);
            } else {
                System.out.println(vidurkiai[i]);
            }
        }
        
        System.out.println("\nGroup average:");
        System.out.println(bendraSuma / st);
        
        System.out.println("\nHighest-performing student:");
        for (int i = 0; i < st; i++) {
            if (Math.abs(vidurkiai[i] - maxVid) < 1e-9) {
                System.out.println(i + 1);
            }
        }
        
        System.out.println("\nStudents with at least one grade below 5:");
        boolean yra = false;
        for (int i = 0; i < st; i++) {
            if (blogi[i]) {
                System.out.println(i + 1);
                yra = true;
            }
        }
        if (!yra) {
            System.out.println("None");
        }
    }
}
