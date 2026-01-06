package view;

import controller.MemberController;
import controller.TrainerController;
import dto.MemberDTO;
import dto.TrainerDTO;
import java.sql.SQLException;
import java.util.Scanner;
import model.MemberModel;
import model.TrainerModel;

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
