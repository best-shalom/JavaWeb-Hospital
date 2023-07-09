package hospital.dao;
import hospital.user.Admin;

public interface AdminDao {
    public Admin add(Admin admin);
    public boolean delete(int adminID);
    public boolean update(Admin admin);
    public Admin find(String A_Name);
    public  Admin findID(int adminID);
}
