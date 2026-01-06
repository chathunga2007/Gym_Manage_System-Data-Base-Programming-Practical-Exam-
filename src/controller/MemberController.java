package controller;

import dto.MemberDTO;
import java.sql.SQLException;
import model.MemberModel;

public class MemberController {
    MemberModel memModel = new MemberModel();

    public boolean addMember(MemberDTO memDTO) throws SQLException {
        return memModel.saveMember(memDTO);
    }

    public void viewMember() throws SQLException {
        memModel.viewMember();
    }
}
