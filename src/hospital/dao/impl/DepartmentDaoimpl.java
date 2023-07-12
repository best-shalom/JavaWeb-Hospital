package hospital.dao.impl;

import hospital.dbc.DbConnection;
import hospital.user.Department;
import hospital.user.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoimpl {
    public List<Department> findAll(int id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from hosdep where hospitalid = ?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            List<Department> departmentList = new ArrayList<>();

            while (rs.next()) {
                Department department = new Department();
                department.setHospitalid(rs.getInt(2));
                department.setDepartmentid(rs.getInt(3));
                department.setDepartmentname(rs.getString(4));
                department.setDepartmenthead(rs.getString(5));
                department.setIntroduction(rs.getString(6));
                department.setClinichours(rs.getString(7));

                departmentList.add(department);
            }
            if (departmentList == null) {
                System.out.println("no");
            }
            return departmentList;
        } catch (Exception e) {
            System.out.println("NO");
            e.printStackTrace();
            return null;
        }
    }

    public Department add(Department department) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into hosdep(hospitalid,departmentid,departmentname,DepartmentHead,introduction,ClinicHours) values(?,?,?,?,?,?)";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,department.getHospitalid());
            pt.setInt(2,department.getDepartmentid());
            pt.setString(3,department.getDepartmentname());
            pt.setString(4,department.getDepartmenthead());
            pt.setString(5,department.getIntroduction());
            pt.setString(6,department.getClinichours());

            if(pt.executeUpdate()>0){
                //返回添加成功的patient以获取分配的id
                String s="select * from hosdep where hospitalid=? and departmentid=? and departmentname=? and DepartmentHead=? and introduction=? and ClinicHours=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setInt(1,department.getHospitalid());
                p.setInt(2,department.getDepartmentid());
                p.setString(3,department.getDepartmentname());
                p.setString(4,department.getDepartmenthead());
                p.setString(5,department.getIntroduction());
                p.setString(6,department.getClinichours());
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    department.setId(rs.getInt("ID"));
                    return department;
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
            String sql="delete from hosdep where ID=?";
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

    public boolean update(Department department) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update hosdep set hospitalid=? and departmentid=? and departmentname=? and DepartmentHead=? and introduction=? and ClinicHours=? where ID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,department.getHospitalid());
            pt.setInt(2,department.getDepartmentid());
            pt.setString(3,department.getDepartmentname());
            pt.setString(4,department.getDepartmenthead());
            pt.setString(5,department.getIntroduction());
            pt.setString(6,department.getClinichours());
            pt.setString(7,department.getClinichours());
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Department find(int id) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from hosdep where ID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs=pt.executeQuery();
            Department department=new Department();
            if(rs.next()){
                department.setId(rs.getInt("ID"));
                department.setHospitalid(rs.getInt("hospitalid"));
                department.setDepartmentid(rs.getInt("departmentid"));
                department.setDepartmentname(rs.getString("departmentname"));
                department.setDepartmenthead(rs.getString("DepartmentHead"));
                department.setIntroduction(rs.getString("introduction"));
                department.setIntroduction(rs.getString("ClinicHours"));
                return department;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
