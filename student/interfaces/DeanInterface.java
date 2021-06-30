package interfaces;

import studentAndGroup.Group;
import studentAndGroup.Student;

import java.util.List;

public interface DeanInterface {
    void changeStudentStatus(Student student, boolean status);

    List<Student> getStudentsByCity(String city);

    void changeStudentGroup(Student student, Group groupFrom, Group groupTo);
}
