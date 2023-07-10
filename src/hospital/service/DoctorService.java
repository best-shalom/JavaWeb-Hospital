package hospital.service;

import hospital.dao.impl.DoctorDaoImpl;
import hospital.dao.impl.SickDaoImpl;
import hospital.user.Doctor;
import hospital.user.Sick;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * 医生服务
 * --登录
 * --注册(可随意注册,没有什么信息是唯一的)
 * --显示自身信息
 * --修改自身信息
 * --显示相同科室的病人数据
 * --删除病人数据
 * --修改病人数据
 */
public class DoctorService {
    DoctorDaoImpl doctorDao=new DoctorDaoImpl();
    SickDaoImpl sickDao=new SickDaoImpl();

    public boolean DoctorLogin(int id,String password){
        Doctor doctor=doctorDao.find(id);
        if(doctor==null){
            return false;
        }
        if(!Objects.equals(doctor.getPassword(), password)){
            return false;
        }
        return true;
    }

    public Doctor DoctorRegister(String name,String password,String sex,int age,
                                 String phone, String part, String part2, String part3, String discript){
        Doctor doctor=new Doctor();
        doctor.setName(name);
        doctor.setPassword(password);
        doctor.setSex(sex);
        doctor.setAge(age);
        doctor.setPhone(phone);
        doctor.setPart(part);
        doctor.setPart2(part2);
        doctor.setPart3(part3);
        doctor.setDiscript(discript);
        return doctorDao.add(doctor);
    }

    /**
     * 显示自身信息
     * @param id 这里的id可以直接由登录界面的id传入
     *           注册界面则由传入的doctor.getId()获取
     * @return 返回医生信息
     */
    public Doctor DoctorShow(int id){
        return doctorDao.find(id);
    }

    public boolean DoctorUpdate(int id,String name,String password,int age,String sex,String part){
        Doctor doctor=doctorDao.find(id);
        if(doctor==null){
            return false;
        }
        doctor.setName(name);
        doctor.setPassword(password);
        doctor.setAge(age);
        doctor.setSex(sex);
        doctor.setPart(part);
        return doctorDao.update(doctor);
    }

    /**
     * 显示相同科室的病人数据
     * @param part 所属科室(由医生主页传入)
     * @return 返回该科室的病人数据
     */
    public List<Sick> SickShow(String part){
        return sickDao.find(part);
    }

    public boolean SickDelete(int id){
        Sick sick=sickDao.findById(id);
        if(sick==null){
            return false;
        }
        return sickDao.delete(id);
    }

    /**
     * 更新挂号信息
     * @param id 根据id查找更新
     * @param part 可更新内容--科室
     * @param sick 可更新内容--病名
     * @param inform 可更新内容--病情描述
     * @return 返回是否更新成功
     */
    public boolean SickUpdate(int id,String part,String sick,String inform){
        Sick s=sickDao.findById(id);
        if(s==null){
            return false;
        }
        s.setPart(part);
        s.setSick(sick);
        s.setInform(inform);
        return sickDao.update(s);
    }
    public Sick SickFindById(int id){
        return sickDao.findById(id);
    }
}
