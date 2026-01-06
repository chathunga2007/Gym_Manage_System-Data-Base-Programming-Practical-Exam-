package model;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrainingSessionModel {

    public void assignTrainer(int memberId, int trainerId) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        con.setAutoCommit(false);

        try {
            String checkSql =
                    "SELECT max_trainers, current_trainer_count FROM trainers WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(checkSql);
            ps1.setInt(1, trainerId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next() ||
                    rs.getInt("current_trainer_count") >= rs.getInt("max_trainers")) {
                throw new Exception("Trainer capacity full!");
            }

            String insertSession =
                    "INSERT INTO training_sessions(member_id, trainer_id) VALUES (?,?)";
            PreparedStatement ps2 = con.prepareStatement(insertSession);
            ps2.setInt(1, memberId);
            ps2.setInt(2, trainerId);
            ps2.executeUpdate();

            String updateTrainer =
                    "UPDATE trainers SET current_trainer_count = current_trainer_count + 1 WHERE id=?";
            PreparedStatement ps3 = con.prepareStatement(updateTrainer);
            ps3.setInt(1, trainerId);
            ps3.executeUpdate();

            con.commit();
            System.out.println("Trainer assigned successfully!");

        } catch (Exception e) {
            con.rollback();
            System.out.println("Assignment failed!");
        } finally {
            con.setAutoCommit(true);
        }
    }

    public void removeAssignment(int sessionId, int trainerId) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        con.setAutoCommit(false);

        try {
            String deleteSession =
                    "DELETE FROM training_sessions WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(deleteSession);
            ps1.setInt(1, sessionId);
            ps1.executeUpdate();

            String updateTrainer =
                    "UPDATE trainers SET current_trainer_count = current_trainer_count - 1 WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(updateTrainer);
            ps2.setInt(1, trainerId);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Assignment removed successfully!");

        } catch (Exception e) {
            con.rollback();
            System.out.println("Remove failed!");
        } finally {
            con.setAutoCommit(true);
        }
    }
}
