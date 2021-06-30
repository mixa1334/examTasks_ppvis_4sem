package actors;

import database.StudentDatabase;
import interfaces.DeanInterface;
import studentAndGroup.Group;
import studentAndGroup.Student;
import studentAndGroup.StudentException;

import java.util.List;
import java.util.stream.Collectors;

public class Dean implements DeanInterface {
    private StudentDatabase database;

    public Dean(StudentDatabase database) {
        this.database = database;
    }

    @Override
    public void changeStudentStatus(Student student, boolean status) {
        student.changeStudyingStatus(status);
    }

    @Override
    public List<Student> getStudentsByCity(String city) {
        return database.getAllStudents().stream().filter(student -> student.getCity().equals(city)).collect(Collectors.toList());
    }

    @Override
    public void changeStudentGroup(Student student, Group groupFrom, Group groupTo) {
        try {
            groupTo.addStudent(student);
            groupFrom.deleteStudent(student);
        } catch (StudentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
