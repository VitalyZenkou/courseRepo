package lecture3.task2.util.filter;

import lecture3.task2.Student;

import java.util.List;
import java.util.Map;

public interface IStudentFilter {

    List<Student> findStudentsByLastNameFirstLetter(List<Student> students, char letter);

    Map<Integer, Student> findStudentsById(Map<Integer, Student> studentMap, int id);
}
