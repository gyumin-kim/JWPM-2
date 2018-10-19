package studentbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {
    /**
     * 사용자에게 선택사항을 제시하고 사용자가 입력한 값을 리턴한다.
     * @return selectedOption - 사용자가 입력한 옵션
     */
    public int main() {
        int selectedOption = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("옵션을 선택하세요.");
        System.out.println("1. 학생 등록");
        System.out.println("2. 학생 목록 보기");
        System.out.println("3. 종료");
        System.out.print("선택! ");

        try {
            selectedOption = in.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
        return selectedOption;
    }

    /**
     * 등록할 학생의 정보를 입력 받고 리턴한다.
     * @return student
     */
    public Student addStudent() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studentbookConfig.xml");
//        Student student = applicationContext.getBean("student", Student.class);
        Student student = new Student();
        String addOrNot = "";
        Scanner in = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("등록할 학생의 이름과 성적을 입력하세요.");
        try {
            System.out.print("이름: ");
            student.setName(in.next());
            System.out.print("국어: ");
            student.setKorean(in.nextInt());
            System.out.print("영어: ");
            student.setEnglish(in.nextInt());
            System.out.print("수학: ");
            student.setMath(in.nextInt());

            System.out.print("등록할까요? (Y/N): ");
            addOrNot = in.next();
        } catch (InputMismatchException ime) {
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }

        if (addOrNot.toUpperCase().equals("Y")) return student;
        else return null;
    }

    /**
     * studentList를 입력 받아 전체 학생의 성적 정보를 출력한다.
     * @param studentList - 전체 학생들의 이름과 성적 정보 리스트
     */
    public void listStudent(List<Student> studentList) {
        System.out.println("------------------------------");
        System.out.printf("%8s", "이름\t\t");
        System.out.println("국어\t영어\t수학");
        for (Student student : studentList) {
//            System.out.print(student.getName() + "\t");
            System.out.printf("%10s", student.getName() + "\t");
            System.out.print(student.getKorean() + "\t");
            System.out.print(student.getEnglish() + "\t");
            System.out.println(student.getMath() + "\t");
        }
    }

    /**
     * 프로그램 종료를 알린다.
     */
    public void end() {
        System.out.println("------------------------------");
        System.out.println("프로그램을 종료합니다.");
    }
}
