package hospital.dao;

import hospital.user.Doctor;

/**
 * @author Administrator
 * 对医生登录数据表的增删改查
 */
public interface DoctorDao {
    /**
     * 添加医生数据
     * (从注册导入医生数据)
     * @param doctor 注册时会输入完整的数据
     * @return 返回是否添加成功
     */
    public Doctor add(Doctor doctor);

    /**
     * 删除医生数据
     * (注销医生账号)
     * @param id 通过id注销
     * @return 返回是否删除成功
     */
    public boolean delete(int id);

    /**
     * 修改医生数据
     * (修改个人信息界面)
     * @param doctor 修改时会给出完整的更新信息
     * @return 返回是否成功
     */
    public boolean update(Doctor doctor);

    /**
     * 查找医生数据
     * (登录时判断是否存在)
     * @param id 医生id
     * @return 返回医生数据(不存在则为null)
     */
    public Doctor find(int id);
}
