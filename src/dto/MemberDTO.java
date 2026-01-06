package dto;

public class MemberDTO {
    int id;
    String name;
    String membership_type;


    public MemberDTO() {}

    public MemberDTO(int id, String name, String membership_type) {
        this.id = id;
        this.name = name;
        this.membership_type = membership_type;
    }

    public MemberDTO(String name, String membership_type) {
        this.name = name;
        this.membership_type = membership_type;
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

    public String getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(String membership_type) {
        this.membership_type = membership_type;
    }
}