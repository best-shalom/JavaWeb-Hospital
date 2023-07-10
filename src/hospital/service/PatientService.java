package hospital.service;

import hospital.dao.impl.PatientDaoImpl;
import hospital.dao.impl.SickDaoImpl;
import hospital.user.Patient;
import hospital.user.Sick;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * 病人服务
 * --登录
 * --注册(可随意注册,没有什么信息是唯一的)
 * --显示自身信息
 * --修改自身信息
 * --显示挂号记录(sick.patientId==patient.id)
 * --添加挂号记录
 * --删除挂号记录
 * --修改挂号记录
 */
public class PatientService {
    PatientDaoImpl patientDao=new PatientDaoImpl();
    SickDaoImpl sickDao=new SickDaoImpl();

    public boolean PatientLogin(int id,String password){
        Patient patient=patientDao.find(id);
        if(patient==null){
            return false;
        }
        if(!Objects.equals(patient.getPassword(), password)){
            return false;
        }
        return true;
    }

    public Patient PatientRegister(String name,String password,int age,String sex,String email,String idCard,String DateOfBirth,String PhoneNumber){
        Patient patient=new Patient();
        patient.setName(name);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setSex(sex);
        patient.setEmail(email);
        patient.setIdCard(idCard);
        patient.setDateOfBirth(DateOfBirth);
        patient.setPhoneNumber(PhoneNumber);

        return patientDao.add(patient);
    }

    /**
     * 显示自身信息
     * @param id 这里的id可以直接由登录界面的id传入
     *           注册界面则由传入的patient.getId()获取
     * @return 返回病人信息
     */
    public Patient PatientShow(int id){
        return patientDao.find(id);
    }

    public boolean PatientUpdate(int id,String name,String password,int age,String sex){
        Patient patient=patientDao.find(id);
        if(patient==null){
            return false;
        }
        patient.setName(name);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setSex(sex);
        return patientDao.update(patient);
    }

    /**
     * 显示挂号数据
     * @param patientId 获取id(由病人主页传入)
     * @return 返回相应挂号数据
     */
    public List<Sick> SickShow(int patientId){
        return sickDao.find(patientId);
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
     * 病人可对挂号数据进行更多更改
     * @param id 根据id查找更新
     * @param part 可更新内容--科室
     * @param sick 可更新内容--病名
     * @param inform 可更新内容--病情描述
     * @return 返回是否更新成功
     */
    public boolean SickUpdate(int id,String name,int age,String sex,String part,String sick,String inform){
        Sick s=sickDao.findById(id);
        if(s==null){
            return false;
        }
        s.setName(name);
        s.setAge(age);
        s.setSex(sex);
        s.setPart(part);
        s.setSick(sick);
        s.setInform(inform);
        return sickDao.update(s);
    }
    public boolean SickAdd(int patientId,String name,int age,String sex,String part,String sick,String inform){
        Sick s=new Sick();
        s.setPatientId(patientId);
        s.setName(name);
        s.setAge(age);
        s.setSex(sex);
        s.setPart(part);
        s.setSick(sick);
        s.setInform(inform);
        return sickDao.add(s);
    }
    public Sick SickFindById(int id){
        return sickDao.findById(id);
    }
}
