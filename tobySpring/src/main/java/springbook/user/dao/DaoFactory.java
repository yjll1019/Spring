package springbook.user.dao;

public class DaoFactory {

    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }

    public UserDao userDao(){
        ConnectionMaker connectionMaker = connectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
