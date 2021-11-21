package hospital.dao.impl;

import hospital.dao.SickDao;
import hospital.dbc.DbConnection;
import hospital.user.Sick;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * SickDao的实现
 */
public class SickDaoImpl implements SickDao {
    @Override
    public boolean add(Sick sick) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into sick(patientId,name,age,sex,part,sick,inform) values(?,?,?,?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,sick.getPatientId());
            pt.setString(2,sick.getName());
            pt.setInt(3,sick.getAge());
            pt.setString(4,sick.getSex());
            pt.setString(5,sick.getPart());
            pt.setString(6,sick.getSick());
            pt.setString(7,sick.getInform());
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
    public boolean delete(int id) {
        try {
            Connection connection=DbConnection.getConnection();
            String sql="delete from sick where id=?";
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
    public boolean update(Sick sick) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update sick set patientId=?,name=?,age=?,sex=?,part=?,sick=?,inform=? where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,sick.getPatientId());
            pt.setString(2,sick.getName());
            pt.setInt(3,sick.getAge());
            pt.setString(4,sick.getSex());
            pt.setString(5,sick.getPart());
            pt.setString(6,sick.getSick());
            pt.setString(7,sick.getInform());
            pt.setInt(8,sick.getId());
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
    public Sick findById(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from sick where id=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Sick sick=new Sick();
            if(rs.next()){
                sick.setId(rs.getInt("id"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setName(rs.getString("name"));
                sick.setAge(rs.getInt("age"));
                sick.setSex(rs.getString("sex"));
                sick.setPart(rs.getString("part"));
                sick.setSick(rs.getString("sick"));
                sick.setInform(rs.getString("inform"));
                return sick;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Sick> find(String key) {
        try{
            Connection connection=DbConnection.getConnection();
            List<Sick> result=new ArrayList<>();
            String sql="select * from sick where name=? or sex=? or part=? or sick=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,key);
            pt.setString(2,key);
            pt.setString(3,key);
            pt.setString(4,key);
            ResultSet rs=pt.executeQuery();
            while(rs.next()){
                Sick sick=new Sick();
                sick.setId(rs.getInt("id"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setName(rs.getString("name"));
                sick.setAge(rs.getInt("age"));
                sick.setSex(rs.getString("sex"));
                sick.setPart(rs.getString("part"));
                sick.setSick(rs.getString("sick"));
                sick.setInform(rs.getString("inform"));
                result.add(sick);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Sick> find(int key) {
        try{
            Connection connection=DbConnection.getConnection();
            List<Sick> result= new ArrayList<>();
            String sql="select * from sick where patientId=? ";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,key);
            ResultSet rs=pt.executeQuery();
            while(rs.next()){
                Sick sick=new Sick();
                sick.setId(rs.getInt("id"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setName(rs.getString("name"));
                sick.setAge(rs.getInt("age"));
                sick.setSex(rs.getString("sex"));
                sick.setPart(rs.getString("part"));
                sick.setSick(rs.getString("sick"));
                sick.setInform(rs.getString("inform"));
                result.add(sick);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
