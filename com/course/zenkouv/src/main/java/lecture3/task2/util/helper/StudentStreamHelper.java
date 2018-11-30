package lecture3.task2.util.helper;

import lecture3.task2.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentStreamHelper implements IStudentHelper {

    @Override
    public List<Student> sortStudentsByAge(List<Student> students) {
        return students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
    }

    @Override
    public double getAvgAge(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).average().orElse(0.0);

    }

    @Override
    public Map<Integer, Student> getStudentsAsMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getStudentId, student -> student));
    }
}
