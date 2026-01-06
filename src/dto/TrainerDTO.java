package dto;

public class TrainerDTO {
    int id;
    String name;
    int max_trainers;
    int current_trainer_count;

    public TrainerDTO() {
    }

    public TrainerDTO(String name, int max_trainers) {
        this.name = name;
        this.max_trainers = max_trainers;
    }

    public TrainerDTO(int id, String name, int max_trainers, int current_trainer_count) {
        this.id = id;
        this.name = name;
        this.max_trainers = max_trainers;
        this.current_trainer_count = current_trainer_count;
    }

    public TrainerDTO(String name, int max_trainers, int current_trainer_count) {
        this.name = name;
        this.max_trainers = max_trainers;
        this.current_trainer_count = current_trainer_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_trainers() {
        return max_trainers;
    }

    public void setMax_trainers(int max_trainers) {
        this.max_trainers = max_trainers;
    }

    public int getCurrent_trainer_count() {
        return current_trainer_count;
    }

    public void setCurrent_trainer_count(int current_trainer_count) {
        this.current_trainer_count = current_trainer_count;
    }
}
