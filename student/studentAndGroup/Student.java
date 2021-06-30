package studentAndGroup;

public class Student {
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String city;
    private boolean studyingStatus;

    public Student(String name, String surname, String patronymic, String city) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.studyingStatus = false;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public boolean isStudying() {
        synchronized (this) {
            return studyingStatus;
        }
    }

    public void changeStudyingStatus(boolean status) {
        synchronized (this) {
            this.studyingStatus = status;
        }
    }
}
