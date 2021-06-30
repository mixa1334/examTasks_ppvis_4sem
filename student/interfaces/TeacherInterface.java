package interfaces;

import java.util.List;
import java.util.Optional;

import javafx.util.Pair;
import studentAndGroup.*;

public interface TeacherInterface {
    List<Student> getStudentsOfGroup(Group group);

    List<Pair<Student, Optional<Group>>> findStudentBySurname(String surname);
}
