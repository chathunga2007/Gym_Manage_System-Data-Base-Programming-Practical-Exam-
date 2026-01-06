package model;

import java.sql.Connection;
import db.DBConnection;
import dto.TrainerDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerModel {
    public boolean addTrainer(TrainerDTO trainer) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO trainers(name, max_trainers) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, trainer.getName());
        ps.setInt(2, trainer.getMax_trainers());

        return ps.executeUpdate() > 0;
    }

    public boolean updateTrainer(TrainerDTO dto) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE trainers SET name = ?, max_trainers = ?, current_trainer_count = ? WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, dto.getName());
        pst.setString(2, String.valueOf(dto.getMax_trainers()));
        pst.setString(3, String.valueOf(dto.getCurrent_trainer_count()));
        pst.setString(4, String.valueOf(dto.getId()));
        return pst.executeUpdate() > 0;
    }

    public boolean deleteTrainer(TrainerDTO dto) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM trainers WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, String.valueOf(dto.getId()));
        return pst.executeUpdate() > 0;
    }

    public void viewTrainer() throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        ResultSet rs = conn.prepareStatement("SELECT * FROM trainers").executeQuery();
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+" | "+
                            rs.getString("name")+" | "+
                            rs.getInt("max_trainers")+" | "+
                            rs.getInt("current_trainer_count")
            );
        }
    }
}
