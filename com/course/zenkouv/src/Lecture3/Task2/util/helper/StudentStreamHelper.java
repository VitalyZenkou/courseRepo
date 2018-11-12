package Lecture3.Task2.util.helper;

import Lecture3.Task2.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentStreamHelper implements IStudentHelper {

    @Override
    public double getAvgAge(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).average().orElse(0.0);

    }

    @Override
    public Map<Integer, Student> getStudentsAsMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getStudentId, student -> student));
    }
}
