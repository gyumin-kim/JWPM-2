package examples.first.exam01;

public class MyMainTest {
    public static void main(String[] args) {
        MyDAO myDAO = new MyDAOImpl();
        MyService myService = new MyServiceImpl(myDAO); // 가지는 것들은 생성자(혹은 setter)에 넣는다.
        MyController myController = new MyController(myService);    // 궁극적으로 사용하고자 하는 객체는 myController
    }
}

