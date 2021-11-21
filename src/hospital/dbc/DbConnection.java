package hospital.dbc;

import java.sql.*;

/**
 * @author Administrator
 * 数据库连接
 */
public class DbConnection {
    /**
     * 1.定义数据库驱动
     * 2.数据库连接地址
     * 3.数据库连接用户名
     * 4.数据库连接密码
     * 5.声明数据库连接对象
     */
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/hospital";
    private static final String USER="hospital";
    private static final String PASSWORD="12345";
    private static Connection connection=null;
    private static void init(){
        try{
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        init();
        return connection;
    }
}
