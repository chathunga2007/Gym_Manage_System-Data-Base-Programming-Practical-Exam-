import dto.MemberDTO;
import dto.TrainerDTO;
import model.MemberModel;
import model.TrainerModel;
import model.TrainingSessionModel;
import view.MainView;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        MemberModel member = new MemberModel();
        TrainerModel trainer = new TrainerModel();
        TrainingSessionModel session = new TrainingSessionModel();

        while (true) {
            int choice = MainView.menu();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Membership Type: ");
                    String type = sc.next();
                    member.saveMember(new MemberDTO(name, type));
                }
                case 2 -> member.viewMember();
                case 3 -> {
                    System.out.print("Trainer Name: ");
                    String name = sc.next();
                    System.out.print("Max Members: ");
                    int max = sc.nextInt();
                    trainer.addTrainer(new TrainerDTO(name, max));
                }
                case 4 -> trainer.viewTrainer();
                case 5 -> {
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    System.out.print("Trainer ID: ");
                    int tid = sc.nextInt();
                    session.assignTrainer(mid, tid);
                }
                case 6 -> {
                    System.out.print("Session ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Trainer ID: ");
                    int tid = sc.nextInt();
                    session.removeAssignment(sid, tid);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}