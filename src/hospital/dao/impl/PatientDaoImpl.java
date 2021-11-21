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
            String sql="insert into patient(name,password,age,sex) values(?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,patient.getName());
            pt.setString(2,patient.getPassword());
            pt.setInt(3,patient.getAge());
            pt.setString(4,patient.getSex());
            if(pt.executeUpdate()>0){
                //返回添加成功的patient以获取分配的id
                String s="select * from patient where name=? and password=? and age=? and sex=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1,patient.getName());
                p.setString(2,patient.getPassword());
                p.setInt(3,patient.getAge());
                p.setString(4,patient.getSex());
                ResultSet rs=p.executeQuery();
                if(rs.next()){
                    patient.setId(rs.getInt("id"));
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
            pt.setInt(5,patient.getId());
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
    public Patient find(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from patient where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Patient patient=new Patient();
            if(rs.next()){
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setPassword(rs.getString("password"));
                patient.setAge(rs.getInt("age"));
                patient.setSex(rs.getString("sex"));
                return patient;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
