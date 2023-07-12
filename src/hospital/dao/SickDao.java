package hospital.dao;

import hospital.user.Sick;

import java.util.List;

/**
 * @author Administrator
 * 对病人挂号数据的增删查改
 * (病人和医生都可操作)
 * 病人操作---对应patientId
 * 医生操作---对应科室
 */
public interface SickDao {
    /**
     * 添加挂号数据
     * @param sick 添加挂号数据时输入sick内容
     * @return 返回是否添加成功
     */
    public boolean add(Sick sick);

    /**
     * 删除挂号数据
     * (根据id唯一删除)
     * @param id 挂号id
     * @return 返回是否删除成功
     */
    public boolean delete(int id);

    /**
     * 修改挂号信息
     * @param sick 由修改界面传入
     * @return 返回是否修改成功
     */
    public boolean update(Sick sick);

    /**
     * 查找挂号信息
     * --按id唯一查找
     * @param id 挂号id
     * @return 返回查找结果
     */
    public Sick findById(int id);

    /**
     * 查找挂号信息
     * --根据String类型的数据查找
     * @param key 姓名,性别,所属科室,病名
     * @return 返回列表
     */
    public List<Sick> find(String key);
    /**
     * 查找挂号信息
     * --根据int类型的数据查找
     * @param key 所属病人,年龄
     * @return 返回列表
     */
    public List<Sick> find(int key);
    public List<Sick> docfind(int id);
}
