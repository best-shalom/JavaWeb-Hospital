package hospital.user;


/**
 * @author Administrator
 * 病人信息数据结构
 * --id
 * --姓名
 * --密码
 * --年龄
 * --性别
 */

public class Patient {
    private int UserID;
    private String name;
    private String password;
    private int age;
    private String sex;

    private  String PhoneNumber;
    private  String DateOfBirth;
    private  String IdCard;
    private  String Email;


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(String phoneNumber) {this.PhoneNumber = phoneNumber;}

    public void setDateOfBirth(String dateOfBirth) {this.DateOfBirth = dateOfBirth;}

    public void setIdCard(String idCard) { this.IdCard = idCard;}

    public void setEmail(String email) { this.Email = email; }

    public String getIdCard() {return IdCard;}


    public String getEmail() {return Email;}

    public String getDateOfBirth() { return DateOfBirth; }

    public String getPhoneNumber() {return PhoneNumber;}
}
