package hospital.user;
import java.util.Date;


/**
 * @author Administrator
 * 病人信息数据结构
 * --id
 * --姓名
 * --密码
 * --性别
 * --年龄
 * --身份证号
 * --电话号码
 * --邮箱
 * --出生日期
 */
public class Patient {
    private int id;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String idnum;
    private String phone;
    private String email;
    private Date birth;


    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
