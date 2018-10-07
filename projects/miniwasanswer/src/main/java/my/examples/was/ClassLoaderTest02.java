package my.examples.was;

public class ClassLoaderTest02 {
    public static void main(String[] args) throws Exception {
        Sample s1 = new Sample();
        s1.print();
        s1.print("world");

        // Class라는 타입은 '클래스 정보'를 가지는 객체.
        // JVM은 클래스를 어디서 찾을까? CLASSPATH에서 찾는다.
        // JVM은 클래스 로더를 이용하여 클래스를 읽어들인다.
        Class clazz = Class.forName("my.examples.was.Sample");
        Sample s2 = (Sample)clazz.newInstance();
        s2.print();
        s2.print("world");
    }
}
