package hospital.dao.impl;

import hospital.dbc.DbConnection;
import hospital.user.Hospital;
import hospital.user.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HospitalDaoImpl {
    public List<Hospital> findAll() {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from hospital";
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            List<Hospital> hospitalList = new ArrayList<>();

            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getInt(1));
                hospital.setName(rs.getString(2));
                hospital.setLevel(rs.getString(3));
                hospital.setAddress(rs.getString(4));
                hospital.setNumber(rs.getString(5));
                hospital.setPresidentname(rs.getString(6));
                hospital.setTime(rs.getString(7));
                hospital.setStatus(rs.getString(8));
                hospital.setIntroduction(rs.getString(9));

                hospitalList.add(hospital);
            }
            if (hospitalList == null) {
                System.out.println("no");
            }
            return hospitalList;
        } catch (Exception e) {
            System.out.println("NO");
            e.printStackTrace();
            return null;
        }
    }

    public Hospital add(Hospital hospital) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into hospital(HospitalName,HospitalLevel,HospitalAddress,ContactNumber,PresidentName,EstablishmentDate,OperationStatus,Introduction) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,hospital.getName());
            pt.setString(2,hospital.getLevel());
            pt.setString(3,hospital.getAddress());
            pt.setString(4,hospital.getNumber());
            pt.setString(5,hospital.getPresidentname());
            pt.setString(6,hospital.getTime());
            pt.setString(7,hospital.getStatus());
            pt.setString(8,hospital.getIntroduction());
            if(pt.executeUpdate()>0){
                //返回添加成功的patient以获取分配的id
                String s="select * from hospital where HospitalName=? and HospitalLevel=? and HospitalAddress=? and ContactNumber=? and PresidentName=? and EstablishmentDate=? and OperationStatus=? and Introduction=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1,hospital.getName());
                p.setString(2,hospital.getLevel());
                p.setString(3,hospital.getAddress());
                p.setString(4,hospital.getNumber());
                p.setString(5,hospital.getPresidentname());
                p.setString(6,hospital.getTime());
                p.setString(7,hospital.getStatus());
                p.setString(8,hospital.getIntroduction());
                ResultSet rs=p.executeQuery();
                if(rs.next()){
                    hospital.setId(rs.getInt("HospitalID"));
                    return hospital;
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(int id) {
        try {
            Connection connection=DbConnection.getConnection();
            String sql="delete from hospital where HospitalID=?";
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

    public boolean update(Hospital hospital) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update hospital set HospitalName=?,HospitalLevel=?,HospitalAddress=?,ContactNumber=?,PresidentName=?,EstablishmentDate=?,OperationStatus=?,Introduction=? where HospitalID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,hospital.getName());
            pt.setString(2,hospital.getLevel());
            pt.setString(3,hospital.getAddress());
            pt.setString(4,hospital.getNumber());
            pt.setString(5,hospital.getPresidentname());
            pt.setString(6,hospital.getTime());
            pt.setString(7,hospital.getStatus());
            pt.setString(8,hospital.getIntroduction());
            pt.setInt(9,hospital.getId());
            int result = pt.executeUpdate();
            if(result>0){
                return true;
            }
            return false;
        }catch (Exception e){
            //System.out.println("NO");
            e.printStackTrace();
            return false;
        }
    }

    public Hospital find(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from hospital where HospitalID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Hospital hospital=new Hospital();
            if(rs.next()){
                hospital.setId(rs.getInt("HospitalID"));
                hospital.setName(rs.getString("HospitalName"));
                hospital.setLevel(rs.getString("HospitalLevel"));
                hospital.setAddress(rs.getString("HospitalAddress"));
                hospital.setNumber(rs.getString("ContactNumber"));
                hospital.setPresidentname(rs.getString("PresidentName"));
                hospital.setTime(rs.getString("EstablishmentDate"));
                hospital.setStatus(rs.getString("OperationStatus"));
                hospital.setIntroduction(rs.getString("Introduction"));
                return hospital;
            }
            else {return null;}
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int find(String HospitalName) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from hospital where hospitalName=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1,HospitalName);
            ResultSet rs=pt.executeQuery();
            Hospital hospital=new Hospital();
            if(rs.next()){
                return rs.getInt("HospitalID");
            }
            else {return -1;}
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

}
