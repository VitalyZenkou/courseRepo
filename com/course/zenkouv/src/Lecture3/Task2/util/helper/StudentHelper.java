package Lecture3.Task2.util.helper;

import Lecture3.Task2.Student;

import java.util.*;

public class StudentHelper implements IStudentHelper {

    @Override
    public List<Student> sortStudentsByAge(List<Student> students) {
        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort(Comparator.comparingInt(Student::getAge));
        return sortedStudents;
    }

    @Override
    public double getAvgAge(List<Student> students) {
        double avgAge = 0;
        for (Student student : students) {
            avgAge += student.getAge();
        }
        return avgAge / students.size();
    }

    @Override
    public Map<Integer, Student> getStudentsAsMap(List<Student> students) {
        Map<Integer, Student> studentsHashMap = new HashMap<>();
        for (Student student : students) {
            studentsHashMap.put(student.getStudentId(), student);
        }
        return studentsHashMap;
    }
}
