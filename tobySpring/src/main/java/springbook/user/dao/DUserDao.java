package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao {

    //상속을 통해 확장된 getConnection()메소드, NUserDao와 db연결 방법이 다르다고 가정.
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook?useSSL=false", "root", "test123");
        return c;
    }


}
