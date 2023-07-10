package hospital.dao.impl;

import hospital.dao.AdminDao;
import hospital.dbc.DbConnection;
import hospital.user.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin add(Admin admin) {
        try{
            Connection connection= DbConnection.getConnection();
            String sql="insert into admin(A_Name,A_password,A_phone,create_time) values(?,?,?,?)";
            //sql语句预处理
            PreparedStatement pt=connection.prepareStatement(sql);
            //将数据放入问号处
            pt.setString(1, admin.getA_Name());
            pt.setString(2, admin.getA_password());
            pt.setString(3,admin.getA_phone());
            pt.setString(4, admin.getCreate_time());
            //如果更新量大于零,即操作成功
            if(pt.executeUpdate()>0){
                //返回添加成功的doctor以获取分配的id
                String s="select * from admin where A_Name=? and A_password=? and A_phone=? and create_time=?";
                PreparedStatement p=connection.prepareStatement(s);
                p.setString(1,admin.getA_Name());
                p.setString(2, admin.getA_password());
                p.setString(3,admin.getA_phone());
                p.setString(4,admin.getCreate_time());
                ResultSet rs=p.executeQuery();
                if(rs.next()){
                    admin.setAdminID(rs.getInt("adminID"));
                    return admin;
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean delete(int adminID){
        try {
            Connection connection=DbConnection.getConnection();
            String sql="delete from admin where adminID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,adminID);
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Admin admin){
        try{
            Connection connection=DbConnection.getConnection();
            String sql="update admin set A_Name=?,A_password=?,A_phone=?,create_time=? where adminID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setString(1, admin.getA_Name());
            pt.setString(2, admin.getA_password());
            pt.setString(3, admin.getA_phone());
            pt.setString(4, admin.getCreate_time());
            pt.setInt(5, admin.getAdminID());
            if(pt.executeUpdate()>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Admin find(String A_Name) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM admin WHERE A_Name=?";
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, A_Name);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminID(rs.getInt("adminID"));
                admin.setA_Name(rs.getString("A_Name"));
                admin.setA_password(rs.getString("A_password"));
                admin.setA_phone(rs.getString("A_phone"));
                admin.setCreate_time(rs.getString("create_time"));
                return admin;
            }
            //System.out.println("find no");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("FIND NO");
            return null;
        }
    }
    public Admin findID(int adminID) {
        try{
            Connection connection=DbConnection.getConnection();
            String sql="select * from admin where adminID=?";
            PreparedStatement pt=connection.prepareStatement(sql);
            pt.setInt(1,adminID);
            ResultSet rs=pt.executeQuery();
            Admin admin=new Admin();
            if(rs.next()){
                admin.setAdminID(rs.getInt("adminID"));
                admin.setA_Name(rs.getString("A_Name"));
                admin.setA_password(rs.getString("A_password"));
                admin.setA_phone(rs.getString("A_phone"));
                admin.setCreate_time(rs.getString("create_time"));
                return admin;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
