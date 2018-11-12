package Lecture3.Task3;

import Lecture3.Task2.Student;
import Lecture3.Task2.factory.StudentFactory;
import Lecture3.Task2.util.filter.IStudentFilter;
import Lecture3.Task2.util.filter.StudentFilter;
import Lecture3.Task2.util.filter.StudentStreamFilter;
import Lecture3.Task2.util.helper.IStudentHelper;
import Lecture3.Task2.util.helper.StudentStreamHelper;
import Lecture3.Task2.util.helper.ViewHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StudentStreamApp {

    private static final int LIST_SIZE = 30;
    private static final char LETTER = 'g';
    private static final int ID = 29;
    private static final IStudentFilter FILTER = new StudentStreamFilter();
    private static final IStudentHelper HELPER = new StudentStreamHelper();
    private static List<Student> students;
    private static Map<Integer, Student> studentsMap;

    public static void main(String[] args) {
        students = StudentFactory.createRandomStudentList(LIST_SIZE);
        ViewHelper.printStudents(students);
        students = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        ViewHelper.printStudents(students);
        System.out.printf("The average age = %.2f\n", HELPER.getAvgAge(students));
        ViewHelper.printStudents(FILTER.findStudentsByLastNameFirstLetter(students, LETTER));
        studentsMap = HELPER.getStudentsAsMap(students);
        ViewHelper.printStudents(studentsMap);
        ViewHelper.printStudents(FILTER.findStudentsById(studentsMap, ID));
    }
}
