package hospital.dao.impl;

import hospital.dao.PatientDao;
import hospital.dbc.DbConnection;
import hospital.user.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Administrator
 * PatientDao的实现
 */
public class PatientDaoImpl implements PatientDao {

    @Override
    public Patient add(Patient patient) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into patients(Name,Password,Sex,Age,IDCard,PhoneNumber,Email,DateOfBirth) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,patient.getName());
            pt.setString(2,patient.getPassword());
            pt.setString(3,patient.getSex());
            pt.setInt(4,patient.getAge());
            pt.setString(5,patient.getIdCard());
            pt.setString(6,patient.getPhoneNumber());
            pt.setString(7,patient.getEmail());
            pt.setString(8,patient.getDateOfBirth());
            if(pt.executeUpdate()>0){
                //返回添加成功的patient以获取分配的id
                String s="select * from patients where Name=? and Password=? and Sex=? and Age=? and IDCard=? and PhoneNumber=? and Email=? and DateOfBirth=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1,patient.getName());
                p.setString(2,patient.getPassword());
                p.setString(3,patient.getSex());
                p.setInt(4,patient.getAge());
                p.setString(5,patient.getIdCard());
                p.setString(6,patient.getPhoneNumber());
                p.setString(7,patient.getEmail());
                p.setString(8,patient.getDateOfBirth());
                ResultSet rs=p.executeQuery();
                if(rs.next()){
                    patient.setUserID(rs.getInt("UserID"));
                    return patient;
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection=DbConnection.getConnection();
            String sql="delete from patient where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Patient patient) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update patient set name=?,password=?,age=?,sex=? where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,patient.getName());
            pt.setString(2,patient.getPassword());
            pt.setInt(3,patient.getAge());
            pt.setString(4,patient.getSex());
            pt.setInt(5,patient.getUserID());
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Patient find(String PhoneNumber) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from patients where PhoneNumber=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,PhoneNumber);
            ResultSet rs=pt.executeQuery();
            Patient patient=new Patient();
            if(rs.next()){
                patient.setUserID(rs.getInt("UserId"));
                patient.setName(rs.getString("Name"));
                patient.setPassword(rs.getString("Password"));
                patient.setSex(rs.getString("Sex"));
                patient.setAge(rs.getInt("Age"));
                patient.setIdCard(rs.getString("IDCard"));
                patient.setPhoneNumber(rs.getString("PhoneNumber"));
                patient.setEmail(rs.getString("email"));
                patient.setDateOfBirth(rs.getString("DateOfBirth"));
                return patient;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
