import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        StudentDAO studentDAO = new StudentDAO();
        Session session = studentDAO.openCurrentSession();
        for (int i = 0; i < 1000; i++) {
            int randomMark = a + (int) (Math.random() * b);
            studentDAO.save(new Student("Name" + i, randomMark));
        }

        List<Student> students = studentDAO.findAll();
        for (Student s : students) {
            System.out.println(s.toString());
        }
        Student student = studentDAO.findById(5L);
        System.out.println("Student: " + student.toString());
        studentDAO.delete(student);
        studentDAO.closeCurrentSessionWithTransaction();

    }
}
