package springbook.user;

import springbook.user.dao.NUserDao;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //UserDao를 상속하는 NUserDao와 DUserDao 클래스 생성 후, 필요(db연결방법)에 따라 다른 유형의 객체(NUserDao와 DUserDao)를 생성한다.
        UserDao dao = new NUserDao();

        User user = new User();
        user.setId("aaa");
        user.setName("이예지");
        user.setPassword("123");

        dao.add(user);

        System.out.println(user.getId()+"등록 성공!");

        User user2 = dao.get("aaa");
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId()+"조회 성공");

    }

}
