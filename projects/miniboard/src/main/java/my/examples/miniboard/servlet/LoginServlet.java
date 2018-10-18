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

@WebServlet("/miniboard/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("authUser");

        if (user != null) {
            // 이미 로그인되어 있으면, list로 redirect
            resp.sendRedirect("/miniboard/list");
        }
        else {
            // login 페이지로 forwarding
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // login 페이지에서 id와 password를 받아,
        // id가 null이거나, DB에서 id로 얻은 user의 password와 입력받은 password가 일치하지 않으면 다시 login 페이지로 redirect
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();

        try {
            User user = userDao.getUser(name);
            System.out.println("로그인시도 => name: " + name + ", password: " + password);

            // User 테이블에 해당 name을 갖는 user가 없는 경우
            if (user == null) {
                req.setAttribute("isIdNull", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
                dispatcher.forward(req, resp);
            } else {
                // 비밀번호 일치하지 않을 경우
                if (!user.getPassword().equals(password)) {
                    req.setAttribute("wrongPw", true);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
                    dispatcher.forward(req, resp);
                }
                // 비밀번호 일치할 경우(login 성공), session에 user 정보 set하고 index로 redirect
                else {
                    System.out.println("getUser(userName)으로 가져온 user 객체의 name: " + user.getName());
                    System.out.println("getUser(userName)으로 가져온 user 객체의 password: " + user.getPassword());
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("authUser", user);
                    resp.sendRedirect("/"); // index로 redirect
                }
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}
