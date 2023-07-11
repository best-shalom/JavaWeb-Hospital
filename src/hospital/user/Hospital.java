package hospital.user;

/**
 * @author Hospital
 * 医院信息数据结构
 * --id(自增主键,不用手动放入)
 * --
 * --密码
 * --年龄
 * --性别
 * --科室
 */
public class Hospital {
    private int id;

    private String name;

    private String level;
    private String address;
    private String Number; // 容纳数量
    private String presidentname; // 院长
    private String time; //营业时间
    private String status; //营业状态
    private String introduction;// 简介

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPresidentname() {
        return presidentname;
    }

    public void setPresidentname(String presidentname) {
        this.presidentname = presidentname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
