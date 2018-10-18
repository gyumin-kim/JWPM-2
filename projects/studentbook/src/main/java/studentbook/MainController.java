package studentbook;

import java.util.List;

public class MainController {
    private UI ui;
    private StudentDAO studentDAO;

    public MainController(UI ui, StudentDAO studentDAO) {
        this.ui = ui;
        this.studentDAO = studentDAO;
    }

    public void control() {
        while (true) {
            // 사용자에게 선택할 수 있는 옵션들을 출력하고 옵션을 입력받는다.
            int selectedOption = ui.main();

            // 사용자가 입력한 옵션에 따라 다른 일 수행 (StudentDAO 사용)
            switch (selectedOption) {
                case 1:
                    if (ui.addStudent() != null) {
                        Student student = ui.addStudent();
                        studentDAO.add(student);
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    List<Student> studentList = studentDAO.getList();
                    ui.listStudent(studentList);
                    break;
                case 3:
                    ui.end();
                    return;
            }
        }
    }
}
