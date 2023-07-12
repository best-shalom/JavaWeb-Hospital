package hospital.user;

public class Department {
    private int departmentid;
    private String departmentname; // 科室名

    private String departmenthead; // 科长

    private String introduction;
    private String clinichours;// 营业时间

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDepartmenthead() {
        return departmenthead;
    }

    public void setDepartmenthead(String departmenthead) {
        this.departmenthead = departmenthead;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getClinichours() {
        return clinichours;
    }

    public void setClinichours(String clinichours) {
        this.clinichours = clinichours;
    }

}
