package examples.first.exam01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
//        Calendar calendar = new Calendar();       // Calendar는 추상클래스이므로 인스턴스 생성 불가
//        자동차 c = new 자동차(); (X);
//        자동차 c = new 버스();  (O);

        Calendar cal1 = new GregorianCalendar();    // GregorianCalendar는 추상클래스가 아니므로 인스턴스 생성 가능

        Calendar cal2 = Calendar.getInstance();     // static 메소드 활용
        // Calendar.getInstance();의 결과로 GregorianCalendar 객체가 리턴됨 (등록된 Locale 정보에 따라 달라짐)

        // Calendar의 필드값 출력
        System.out.println(Calendar.AM);
        System.out.println(Calendar.PM);
        System.out.println(cal2.get(Calendar.YEAR));    // get은 Calendar의 메소드
        System.out.println(cal2.get(Calendar.MONTH));   // 달력의 이름(String)이 배열에 들어가 있다. (9월이면 8번째)
        System.out.println(cal2.get(Calendar.DAY_OF_MONTH));
    }
}
