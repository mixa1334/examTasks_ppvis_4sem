package actors;

import database.StudentDatabase;
import interfaces.SecretaryInterface;
import studentAndGroup.Group;
import studentAndGroup.Student;
import studentAndGroup.StudentException;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements SecretaryInterface {
    private final StudentDatabase database;

    public Secretary(StudentDatabase database) {
        this.database = database;
    }

    @Override
    public void createGroup(String nameOfGroup, int course, List<Student> listOfStudents) {
        Group group = new Group(nameOfGroup, course, listOfStudents);
        database.addGroup(group, course);
    }

    @Override
    public void deleteGroup(Group group) {
        database.deleteGroup(group);
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) {
        return group.getStudents();
    }

    @Override
    public List<Student> getStuntsOfCourse(int courseNumber) {
        ArrayList<Student> result = new ArrayList<>();
        for (var course : database.getAllGroups()) {
            if (course.getFirst().getCourse() == courseNumber) {
                for (Group group : course) {
                    result.addAll(group.getStudents());
                }
                return result;
            }
        }
        return result;
    }

    @Override
    public void addStudentToGroup(Student student, Group group) {
        try {
            group.addStudent(student);
        } catch (StudentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
