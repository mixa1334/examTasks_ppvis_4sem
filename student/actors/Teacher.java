package actors;

import database.StudentDatabase;
import interfaces.TeacherInterface;
import javafx.util.Pair;
import studentAndGroup.Group;
import studentAndGroup.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Teacher implements TeacherInterface {
    private final StudentDatabase database;

    public Teacher(StudentDatabase database) {
        this.database = database;
    }

    @Override
    public List<Student> getStudentsOfGroup(Group group) {
        return group.getStudents();
    }

    @Override
    public List<Pair<Student, Optional<Group>>> findStudentBySurname(String surname) {
        ArrayList<Pair<Student, Optional<Group>>> result = new ArrayList<>();
        for (var student : database.getAllStudents()) {
            if (student.getSurname().equals(surname)) {
                result.add(new Pair<>(student, database.findStudentsGroup(student)));
            }
        }
        return result;
    }
}
