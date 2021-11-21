package hospital.user;


/**
 * @author Administrator
 * 挂号信息数据结构(不一定是登录的人--给别人挂号)
 * --id
 * --patientId(用于查看该挂号数据是由哪位病人提交的,以显示病人的挂号信息)
 * --姓名
 * --年龄
 * --性别
 * --科室
 * --病名
 * --描述
 */
public class Sick {
    private int id;
    private int patientId;
    private String name;
    private int age;
    private String sex;
    private String part;
    private String sick;
    private String inform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
