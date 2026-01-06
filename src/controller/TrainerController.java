package controller;

import dto.TrainerDTO;
import java.sql.SQLException;
import model.TrainerModel;

public class TrainerController {
    TrainerModel trainerModel = new TrainerModel();
    public boolean addTrainer(TrainerDTO trainer) throws SQLException {
        try {
            return trainerModel.addTrainer(trainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewTrainer() throws SQLException {
        trainerModel.viewTrainer();
    }
}
