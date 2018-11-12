package Lecture3.Task2.util.helper;

import Lecture3.Task2.Student;

import java.util.List;
import java.util.Map;

public interface IStudentHelper {

    double getAvgAge(List<Student> students);

    Map<Integer, Student> getStudentsAsMap(List<Student> students);
}
