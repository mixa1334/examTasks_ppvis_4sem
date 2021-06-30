package studentAndGroup;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String name;
    private int courseNumber;
    private final List<Student> students;

    public Group(String name, int courseNumber) {
        this(name, courseNumber, new ArrayList<>());
    }

    public Group(String name, int courseNumber, List<Student> students) {
        this.students = students;
        this.name = name;
        this.courseNumber = courseNumber;
    }

    public int getCourse() {
        synchronized (this) {
            return courseNumber;
        }
    }

    public void setCourse(int courseNumber) {
        synchronized (this) {
            this.courseNumber = courseNumber;
        }
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        synchronized (this) {
            return new ArrayList(students);
        }
    }

    public void addStudent(Student student) throws StudentException {
        synchronized (this) {
            for (Student tempStudent : students) {
                if (tempStudent.getSurname().equals(student.getSurname()))
                    throw new StudentException("Студент с такой фамилией уже есть в группе!");
            }
            students.add(student);
        }
    }

    public void deleteStudent(Student student) {
        synchronized (this) {
            students.remove(student);
        }
    }
}
