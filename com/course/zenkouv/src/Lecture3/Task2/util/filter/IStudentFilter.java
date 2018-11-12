package Lecture3.Task2.util.filter;

import Lecture3.Task2.Student;

import java.util.List;
import java.util.Map;

public interface IStudentFilter {

    List<Student> findStudentsByLastNameFirstLetter(List<Student> students, char letter);

    Map<Integer, Student> findStudentsById(Map<Integer, Student> studentMap, int id);
}
