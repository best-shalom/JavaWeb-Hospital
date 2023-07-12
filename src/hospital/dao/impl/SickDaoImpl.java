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
            String sql="insert into appointment(patientId,P_Name,doctorid,D_Name,AppointmentDate,AppointmentTime,HospitalName,DepartmentName,AppointmentStatus,PaymentStatus,PaymentAmount) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,sick.getPatientId());
            pt.setString(2,sick.getP_name());
            pt.setInt(3,sick.getDoctorid());
            pt.setString(4,sick.getD_name());
            pt.setString(5,sick.getData());
            pt.setString(6,sick.getTime());
            pt.setString(7,sick.getHospitalname());
            pt.setString(8,sick.getDepartmentname());
            pt.setString(9,sick.getAppointmentstatus());
            pt.setString(10,sick.getPaymentstatus());
            pt.setString(11,sick.getPaymentamount());
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
            String sql="delete from appointment where AppointmentID=?";
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
            String sql="update appointment set patientId=?,P_Name=?,D_Name=?,AppointmentDate=?,AppointmentTime=?,HospitalName=?,DepartmentName=?,AppointmentStatus=?,PaymentStatus=?,PaymentAmount=? where AppointmentID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,sick.getPatientId());
            pt.setString(2,sick.getP_name());
            pt.setString(3,sick.getD_name());
            pt.setString(4,sick.getData());
            pt.setString(5,sick.getTime());
            pt.setString(6,sick.getHospitalname());
            pt.setString(7,sick.getDepartmentname());
            pt.setString(8,sick.getAppointmentstatus());
            pt.setString(9,sick.getPaymentstatus());
            pt.setString(10,sick.getPaymentamount());
            pt.setInt(11,sick.getId());
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
            String sql="select * from appointment where AppointmentID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Sick sick=new Sick();
            if(rs.next()){
                sick.setId(rs.getInt("AppointmentID"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setP_name(rs.getString("P_Name"));
                sick.setDoctorid(rs.getInt("doctorid"));
                sick.setD_name(rs.getString("D_Name"));
                sick.setData(rs.getString("AppointmentDate"));
                sick.setTime(rs.getString("AppointmentTime"));
                sick.setHospitalname(rs.getString("HospitalName"));
                sick.setDepartmentname(rs.getString("DepartmentName"));
                sick.setAppointmentstatus(rs.getString("AppointmentStatus"));
                sick.setPaymentstatus(rs.getString("PaymentStatus"));
                sick.setPaymentamount(rs.getString("PaymentAmount"));
                return sick;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Sick> docfind(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from appointment where doctorid=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            List<Sick> result=new ArrayList<>();
            if(rs.next()){
                Sick sick=new Sick();
                sick.setId(rs.getInt("AppointmentID"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setP_name(rs.getString("P_Name"));
                sick.setDoctorid(rs.getInt("doctorid"));
                sick.setD_name(rs.getString("D_Name"));
                sick.setData(rs.getString("AppointmentDate"));
                sick.setTime(rs.getString("AppointmentTime"));
                sick.setHospitalname(rs.getString("HospitalName"));
                sick.setDepartmentname(rs.getString("DepartmentName"));
                sick.setAppointmentstatus(rs.getString("AppointmentStatus"));
                sick.setPaymentstatus(rs.getString("PaymentStatus"));
                sick.setPaymentamount(rs.getString("PaymentAmount"));
                result.add(sick);
                return result;
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
            String sql="select * from appointment where D_Name=? or HospitalName=? or DepartmentName=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,key);
            pt.setString(2,key);
            pt.setString(3,key);
            ResultSet rs=pt.executeQuery();
            while(rs.next()){
                Sick sick=new Sick();
                sick.setId(rs.getInt("AppointmentID"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setP_name(rs.getString("P_Name"));
                sick.setDoctorid(rs.getInt("doctorid"));
                sick.setD_name(rs.getString("D_Name"));
                sick.setData(rs.getString("AppointmentDate"));
                sick.setTime(rs.getString("AppointmentTime"));
                sick.setHospitalname(rs.getString("HospitalName"));
                sick.setDepartmentname(rs.getString("DepartmentName"));
                sick.setAppointmentstatus(rs.getString("AppointmentStatus"));
                sick.setPaymentstatus(rs.getString("PaymentStatus"));
                sick.setPaymentamount(rs.getString("PaymentAmount"));
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
            String sql="select * from appointment where patientId=? ";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,key);
            ResultSet rs=pt.executeQuery();
            while(rs.next()){
                Sick sick=new Sick();
                sick.setId(rs.getInt("AppointmentID"));
                sick.setPatientId(rs.getInt("patientId"));
                sick.setP_name(rs.getString("P_Name"));
                sick.setDoctorid(rs.getInt("doctorid"));
                sick.setD_name(rs.getString("D_Name"));
                sick.setData(rs.getString("AppointmentDate"));
                sick.setTime(rs.getString("AppointmentTime"));
                sick.setHospitalname(rs.getString("HospitalName"));
                sick.setDepartmentname(rs.getString("DepartmentName"));
                sick.setAppointmentstatus(rs.getString("AppointmentStatus"));
                sick.setPaymentstatus(rs.getString("PaymentStatus"));
                sick.setPaymentamount(rs.getString("PaymentAmount"));
                result.add(sick);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
