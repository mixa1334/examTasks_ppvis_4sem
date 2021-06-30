package interfaces;

import studentAndGroup.*;

import java.util.List;

public interface SecretaryInterface {
    void createGroup(String nameOfGroup, int course, List<Student> listOfStudents);

    void deleteGroup(Group group);

    List<Student> getStudentOfGroup(Group group);

    List<Student> getStuntsOfCourse(int courseNumber);

    void addStudentToGroup(Student student, Group group);
}
