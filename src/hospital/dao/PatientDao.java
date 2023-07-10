package hospital.dao;


import hospital.user.Patient;

import java.util.List;

/**
 * @author Administrator
 * 对病人登录数据表的增删改查
 */
public interface PatientDao {
    /**
     * 添加病人数据
     * (从注册导入病人数据)
     * @param patient 注册时会输入完整的数据
     * @return 返回是否添加成功
     */
    public Patient add(Patient patient);

    /**
     * 删除病人数据
     * (注销病人账号)
     * @param id 通过id注销
     * @return 返回是否删除成功
     */
    public boolean delete(int id);

    /**
     * 修改病人数据
     * (修改个人信息界面)
     * @param patient 修改时会给出完整的更新信息
     * @return 返回是否成功
     */
    public boolean update(Patient patient);

    /**
     * 查找病人数据
     * (登录时判断是否存在)
     * @param id 病人id
     * @return 返回病人数据(不存在则为null)
     */
    public Patient find(String PhoneNumber);
    public List<Patient> findAll();
}
