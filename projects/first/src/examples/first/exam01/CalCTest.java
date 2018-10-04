package examples.first.exam01;

public class CalCTest {
    public static void main(String[] args) {
        CalC cal1 = new CalC(500);
        System.out.println(cal1.getValue());

        cal1.plus(50);
        System.out.println(cal1.getValue());

        cal1.plus(100);
        System.out.println(cal1.getValue());

        cal1.minus(100);
        System.out.println(cal1.getValue());

        cal1.multiply(2);
        System.out.println(cal1.getValue());

        cal1.divide(4);
        System.out.println(cal1.getValue());

        cal1.clear();
        System.out.println(cal1.getValue());
    }
}
