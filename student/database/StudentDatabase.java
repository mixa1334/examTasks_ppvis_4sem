package database;

import studentAndGroup.Group;
import studentAndGroup.Student;

import java.util.*;

public class StudentDatabase {
    private final List<Student> allStudents;
    private final List<Deque<Group>> allGroups;

    public StudentDatabase(List<Student> allStudents, List<Deque<Group>> allGroups) {
        this.allGroups = allGroups;
        this.allStudents = allStudents;
    }

    public List<Student> getAllStudents() {
        synchronized (this) {
            return new ArrayList<>(allStudents);
        }
    }

    public List<Deque<Group>> getAllGroups() {
        synchronized (this) {
            return new ArrayList<>(allGroups);
        }
    }

    public void addGroup(Group group, int courseNumber) throws IllegalArgumentException {
        if (courseNumber < 1) throw new IllegalArgumentException();
        synchronized (this) {
            for (var course : allGroups) {
                if (course.getFirst().getCourse() == courseNumber) {
                    course.add(group);
                    return;
                }
            }
            LinkedList<Group> temp = new LinkedList<>();
            temp.add(group);
            allGroups.add(temp);
        }
    }

    public void deleteGroup(Group group) {
        synchronized (this) {
            for (var course : allGroups) {
                if (course.getFirst().getCourse() == group.getCourse()) {
                    course.remove(group);
                    return;
                }
            }
        }
    }

    public Optional<Group> findStudentsGroup(Student student) {
        synchronized (this) {
            for (var course : allGroups) {
                for (var group : course) {
                    if (group.getStudents().contains(student)) {
                        return Optional.of(group);
                    }
                }
            }
            return Optional.empty();
        }
    }
}