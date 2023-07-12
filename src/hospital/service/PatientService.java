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

    public Patient PatientLogin(String PhoneNumber,String password){
        Patient patient=patientDao.find(PhoneNumber);
        if(patient==null){
            System.out.println("Patient not found");
            return null;
        }
        if(!Objects.equals(patient.getPassword(), password)){
            System.out.println("Password error" + password);
            return null;
        }
        return patient;
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

    public Patient PatientShow(String PhoneNumber){
        return patientDao.find(PhoneNumber);
    }
    public Patient PatientShow(int UserID){
        return patientDao.find(UserID);
    }

    public boolean PatientUpdate(int UserID, String Name,String Sex, int Age, String IDCard, String PhoneNumber, String Email, String DateOfBirth){
        Patient patient=patientDao.find(UserID);
        if(patient==null){
            return false;
        }
        patient.setName(Name);
        patient.setSex(Sex);
        patient.setAge(Age);
        patient.setIdCard(IDCard);
        patient.setPhoneNumber(PhoneNumber);
        patient.setEmail(Email);
        patient.setDateOfBirth(DateOfBirth);
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
     * @return 返回是否更新成功
     */
    public boolean SickUpdate(int id,String P_Name,String D_Name,String AppointmentDate,String AppointmentTime,String HospitalName,String DepartmentName){
        Sick s=sickDao.findById(id);
        if(s==null){
            return false;
        }
        s.setP_name(P_Name);
        s.setD_name(D_Name);
        s.setData(AppointmentDate);
        s.setTime(AppointmentTime);
        s.setHospitalname(HospitalName);
        s.setDepartmentname(DepartmentName);
        return sickDao.update(s);
    }
    public boolean SickAdd(int patientId,int DoctorId,String P_Name,String D_Name,String AppointmentDate,String AppointmentTime,String HospitalName,String DepartmentName,String AppointmentStatus,String PaymentStatus,String PaymentAmount){
        Sick s=new Sick();
        s.setPatientId(patientId);
        s.setP_name(P_Name);
        s.setDoctorid(DoctorId);
        s.setD_name(D_Name);
        s.setData(AppointmentDate);
        s.setTime(AppointmentTime);
        s.setHospitalname(HospitalName);
        s.setDepartmentname(DepartmentName);
        s.setAppointmentstatus(AppointmentStatus);
        s.setPaymentstatus(PaymentStatus);
        s.setPaymentamount(PaymentAmount);
        return sickDao.add(s);
    }
    public Sick SickFindById(int id){
        return sickDao.findById(id);
    }
}
