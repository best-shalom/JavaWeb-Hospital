//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hospital.dao.impl;

import hospital.dao.DoctorDao;
import hospital.dbc.DbConnection;
import hospital.user.Department;
import hospital.user.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    public DoctorDaoImpl() {
    }

    public Doctor add(Doctor doctor) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "insert into doctor(DoctorName,HospitalId,DepartmentId, D_Password,sex,age,phone,hospitalname,departmentname,ProfessionalTitle,introduction) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, doctor.getName());
            pt.setInt(2, doctor.getHospitalid());
            pt.setInt(3, doctor.getDepartmentid());
            pt.setString(4, doctor.getPassword());
            pt.setString(5, doctor.getSex());
            pt.setInt(6, doctor.getAge());
            pt.setString(7, doctor.getPhone());
            pt.setString(8, doctor.getPart());
            pt.setString(9, doctor.getPart2());
            pt.setString(10, doctor.getPart3());
            pt.setString(11, doctor.getDiscript());
            if (pt.executeUpdate() > 0) {
                String s = "select * from doctor where DoctorName=? and HospitalId = ? and DepartmentId = ? and D_Password=? and sex=?  and age=? and phone=? and hospitalname=? and departmentname=? and ProfessionalTitle=? and introduction=?";
                PreparedStatement p = connection.prepareStatement(s);
                p.setString(1, doctor.getName());
                p.setInt(2, doctor.getHospitalid());
                p.setInt(3, doctor.getDepartmentid());
                p.setString(4, doctor.getPassword());
                p.setString(5, doctor.getSex());
                p.setInt(6, doctor.getAge());
                p.setString(7, doctor.getPhone());
                p.setString(8, doctor.getPart());
                p.setString(9, doctor.getPart2());
                p.setString(10, doctor.getPart3());
                p.setString(11, doctor.getDiscript());
                ResultSet rs = p.executeQuery();
                if (rs.next()) {
                    doctor.setId(rs.getInt("DoctorID"));
                    return doctor;
                }
            }

            return null;
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public boolean delete(int id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "delete from doctor where DoctorID=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            return pt.executeUpdate() > 0;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public boolean update(Doctor doctor) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "update doctor set DoctorName = ?, age=?,sex=?, phone = ?, hospitalname = ?, departmentname = ?, ProfessionalTitle = ?, introduction = ?  where DoctorID=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, doctor.getName());
            pt.setInt(2, doctor.getAge());
            pt.setString(3, doctor.getSex());
            pt.setString(4, doctor.getPhone());
            pt.setString(5, doctor.getPart());
            pt.setString(6, doctor.getPart2());
            pt.setString(7, doctor.getPart3());
            pt.setString(8, doctor.getDiscript());
            pt.setInt(9, doctor.getId());
            return pt.executeUpdate() > 0;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public Doctor find(String phone) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from doctor where phone=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, phone);
            ResultSet rs = pt.executeQuery();
            Doctor doctor = new Doctor();
            if (rs.next()) {
                doctor.setId(rs.getInt("DoctorID"));
                doctor.setName(rs.getString("DoctorName"));
                doctor.setPassword(rs.getString("D_Password"));
                doctor.setSex(rs.getString("sex"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setPart(rs.getString("hospitalname"));
                doctor.setPart2(rs.getString("departmentname"));
                doctor.setPart3(rs.getString("ProfessionalTitle"));
                doctor.setDiscript(rs.getString("introduction"));
                return doctor;
            } else {
                return null;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public Doctor find(int DoctorID) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from doctor where DoctorID=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, DoctorID);
            ResultSet rs = pt.executeQuery();
            Doctor doctor = new Doctor();
            if (rs.next()) {
                doctor.setId(rs.getInt("DoctorID"));
                doctor.setName(rs.getString("DoctorName"));
                doctor.setPassword(rs.getString("D_Password"));
                doctor.setSex(rs.getString("sex"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setPart(rs.getString("hospitalname"));
                doctor.setPart2(rs.getString("departmentname"));
                doctor.setPart3(rs.getString("ProfessionalTitle"));
                doctor.setDiscript(rs.getString("introduction"));
                return doctor;
            } else {
                return null;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }


    public List<Doctor> findAll(int hospitalid, int departmentid) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from doctor where HospitalId=? and DepartmentId=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, hospitalid);
            pt.setInt(2, departmentid);
            ResultSet rs = pt.executeQuery();
            List<Doctor> doctorList = new ArrayList<>();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("DoctorID"));
                doctor.setName(rs.getString("DoctorName"));
                doctor.setPassword(rs.getString("D_Password"));
                doctor.setSex(rs.getString("sex"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setPart(rs.getString("hospitalname"));
                doctor.setPart2(rs.getString("departmentname"));
                doctor.setPart3(rs.getString("ProfessionalTitle"));
                doctor.setDiscript(rs.getString("introduction"));
                doctorList.add(doctor);
            }
            if (doctorList == null) {
                System.out.println("no");
            }
            return doctorList;
        } catch (Exception e) {
            System.out.println("NO");
            e.printStackTrace();
            return null;
        }
    }
}
