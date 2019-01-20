package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

    //인터페이스를 통해 확장된 DB연결을 담당하는 메소드, NConnectionMaker와 db연결 방법이 다르다고 가정.
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook?useSSL=false", "root", "test123");
        return c;
    }


}
