package hospital.dao;

import hospital.user.Hospital;
import java.util.List;

public interface HospitalDao {
    /**
     * 查找所有医院数据
     * (登录时判断是否存在)
     * @return 返回医院数据(不存在则为null)
     */
    public List<Hospital> findAll();
}
