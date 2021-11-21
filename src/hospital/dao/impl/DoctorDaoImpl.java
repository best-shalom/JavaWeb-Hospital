package hospital.dao.impl;

import hospital.dao.DoctorDao;
import hospital.dbc.DbConnection;
import hospital.user.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Administrator
 * DoctorDao的实现
 */
public class DoctorDaoImpl implements DoctorDao {
    @Override
    public Doctor add(Doctor doctor) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into doctor(name,password,age,sex,part) values(?,?,?,?,?)";
            //sql语句预处理
            PreparedStatement pt=connection.prepareStatement(sql);
            //将数据放入问号处
            pt.setString(1,doctor.getName());
            pt.setString(2,doctor.getPassword());
            pt.setInt(3,doctor.getAge());
            pt.setString(4,doctor.getSex());
            pt.setString(5,doctor.getPart());
            //如果更新量大于零,即操作成功
            if(pt.executeUpdate()>0){
                //返回添加成功的doctor以获取分配的id
                String s="select * from doctor where name=? and password=? and age=? and sex=? and part=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1,doctor.getName());
                p.setString(2,doctor.getPassword());
                p.setInt(3,doctor.getAge());
                p.setString(4,doctor.getSex());
                p.setString(5,doctor.getPart());
                ResultSet rs=p.executeQuery();
                if(rs.next()){
                    doctor.setId(rs.getInt("id"));
                    return doctor;
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
            String sql="delete from doctor where id=?";
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
    public boolean update(Doctor doctor) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update doctor set name=?,password=?,age=?,sex=?,part=? where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,doctor.getName());
            pt.setString(2,doctor.getPassword());
            pt.setInt(3,doctor.getAge());
            pt.setString(4,doctor.getSex());
            pt.setString(5,doctor.getPart());
            pt.setInt(6,doctor.getId());
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
    public Doctor find(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from doctor where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Doctor doctor=new Doctor();
            if(rs.next()){
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setPassword(rs.getString("password"));
                doctor.setAge(rs.getInt("age"));
                doctor.setSex(rs.getString("sex"));
                doctor.setPart(rs.getString("part"));
                return doctor;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
