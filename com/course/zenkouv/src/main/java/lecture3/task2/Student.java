package lecture3.task2;

import java.util.Objects;

public class Student {

    private static int id;
    private final int studentId;
    private final String name;
    private final String lastName;
    private final int age;

    public Student(String name, String lastName, int age) {
        id++;
        studentId = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, lastName, age);
    }

    @Override
    public String toString() {
        return String.format("Student id%3d: Name - %-10s last name - %-10s age - %-2d", studentId, name, lastName, age);
    }
}
