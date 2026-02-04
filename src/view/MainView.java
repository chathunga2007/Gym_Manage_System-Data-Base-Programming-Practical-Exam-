package view;

import java.util.Scanner;

public class MainView {
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Gym Management System ---");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View Trainers");
        System.out.println("5. Assign Trainer");
        System.out.println("6. Remove Assignment");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
        return sc.nextInt();
    }
}
