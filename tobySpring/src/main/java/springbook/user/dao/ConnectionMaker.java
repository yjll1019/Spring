package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

    //서브 클래스에서 db연결에 대한 구체적인 코드 작성.
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
