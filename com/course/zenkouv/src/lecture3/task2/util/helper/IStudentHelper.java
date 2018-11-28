package lecture3.task2.util.helper;

import lecture3.task2.Student;

import java.util.List;
import java.util.Map;

public interface IStudentHelper {

    List<Student> sortStudentsByAge(List<Student> students);

    double getAvgAge(List<Student> students);

    Map<Integer, Student> getStudentsAsMap(List<Student> students);
}
