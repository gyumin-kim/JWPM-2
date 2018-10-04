package examples.first.exam01;

public class MyServiceImpl implements MyService {
    private MyDAO dao;

    public MyServiceImpl(MyDAO myDAO) {
        this.dao = myDAO;
    }

    @Override
    public void hi() {

    }
}
