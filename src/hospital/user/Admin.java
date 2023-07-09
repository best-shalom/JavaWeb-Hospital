package hospital.user;

public class Admin {
    private int adminID;
    private String A_Name;
    private String A_password;
    private String A_phone;
    private String create_time;

    public int getAdminID() {
        return adminID;
    }

    public String getA_Name() {
        return A_Name;
    }

    public String getA_password() {
        return A_password;
    }

    public String getA_phone() {
        return A_phone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setA_Name(String a_Name) {
        A_Name = a_Name;
    }

    public void setA_password(String a_password) {
        A_password = a_password;
    }

    public void setA_phone(String a_phone) {
        A_phone = a_phone;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
