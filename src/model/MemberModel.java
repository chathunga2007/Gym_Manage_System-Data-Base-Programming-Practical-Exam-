package model;

import db.DBConnection;
import dto.MemberDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberModel {
    public boolean saveMember(MemberDTO mem) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO members (name, membership_type) VALUES (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, mem.getName());
        pst.setString(2, mem.getMembership_type());
        return pst.executeUpdate() > 0;
    }

    public boolean updateMember(MemberDTO mem) throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "UPDATE members SET name = ?, membership_type = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mem.getName());
        pst.setString(2, mem.getMembership_type());
        pst.setString(3, String.valueOf(mem.getId()));
        return pst.executeUpdate() > 0;
    }

    public boolean deleteMember(MemberDTO mem) throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM members WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, String.valueOf(mem.getId()));
        return pst.executeUpdate() > 0;
    }

    public void viewMember() throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        ResultSet rs = conn.prepareStatement("SELECT * FROM members").executeQuery();
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+" | "+
                            rs.getString("name")+" | "+
                            rs.getString("membership_type")
            );
        }
    }
}
