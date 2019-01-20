package springbook.user;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("ccc");
        user.setName("이예지");
        user.setPassword("123");

        dao.add(user);

        System.out.println(user.getId()+"등록 성공!");

        User user2 = dao.get("ccc");
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId()+"조회 성공");

    }

}
