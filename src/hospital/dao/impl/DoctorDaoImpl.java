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
            String sql="insert into doctor(DoctorName,D_Password,sex,age,phone,hospital,DepartmentName,ProfessionalTitle,introduction) values(?,?,?,?,?,?,?,?,?)";
            //sql语句预处理
            PreparedStatement pt=connection.prepareStatement(sql);
            //将数据放入问号处
            pt.setString(1,doctor.getName());
            pt.setString(2,doctor.getPassword());
            pt.setString(3,doctor.getSex());
            pt.setInt(4,doctor.getAge());
            pt.setString(5,doctor.getPhone());
            pt.setString(6,doctor.getPart());
            pt.setString(7,doctor.getPart2());
            pt.setString(8,doctor.getPart3());
            pt.setString(9,doctor.getDiscript());
            System.out.print("pt.setString(9,doctor.getDiscript());");


            //如果更新量大于零,即操作成功
            if(pt.executeUpdate()>0){
                //返回添加成功的doctor以获取分配的id
                String s="select * from doctor where DoctorName=? and D_Password=? and sex=?  and age=? and phone=? and hospital=? and DepartmentName=? and ProfessionalTitle=? and introduction=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1, doctor.getName());
                p.setString(2, doctor.getPassword());
                p.setString(3, doctor.getSex());
                p.setInt(4, doctor.getAge());
                p.setString(5, doctor.getPhone());
                p.setString(6, doctor.getPart());
                p.setString(7, doctor.getPart2());
                p.setString(8, doctor.getPart3());
                p.setString(9, doctor.getDiscript());

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
