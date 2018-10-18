package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.UserDao;
import my.examples.miniboard.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/miniboard/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 아이디와 암호를 읽어들이기
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("signup 페이지: " + name + "(" + password + ") 입력됨");

        User user = new User(name, password);
        UserDao userDao = new UserDao();
        HttpSession session = req.getSession();

        try {
            // 이미 가입된 ID일 경우
            if (userDao.getUser(name) != null) {
                session.setAttribute("isExistingUser", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
                dispatcher.forward(req, resp);
            }
            // user 테이블에 회원정보 추가
            else {
                session.setAttribute("isExistingUser", false);
                int count = userDao.addUser(user);

                // DB에 추가한 회원정보 확인
                List<User> userList = userDao.getUserList();
                String getName = userList.get(userList.size() - 1).getName();
                String getPassword = userList.get(userList.size() - 1).getPassword();

                System.out.println(getName + "(" + getPassword + ") 가입됨. 현재 user " + count + "명.");

                // LoginServlet으로 forwarding하여 로그인까지 바로 처리
                System.out.println("회원가입 완료. LoginServlet으로 forwarding.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/miniboard/login");
                dispatcher.forward(req, resp);
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}
