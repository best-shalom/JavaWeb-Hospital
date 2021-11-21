package hospital.user;

/**
 * @author Administrator
 * 医生信息数据结构
 * --id(自增主键,不用手动放入)
 * --姓名
 * --密码
 * --年龄
 * --性别
 * --科室
 */
public class Doctor {
    private int id;
    private String name;
    private String password;
    private int age;
    private String sex;
    private String part;

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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
