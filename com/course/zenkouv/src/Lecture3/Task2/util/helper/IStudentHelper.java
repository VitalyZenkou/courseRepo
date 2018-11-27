package Lecture3.Task2.util.helper;

import Lecture3.Task2.Student;

import java.util.List;
import java.util.Map;

public interface IStudentHelper {

    List<Student> sortStudentsByAge(List<Student> students);

    double getAvgAge(List<Student> students);

    Map<Integer, Student> getStudentsAsMap(List<Student> students);
}
