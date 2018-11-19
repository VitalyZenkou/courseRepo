package Lecture3.Task2;

import Lecture3.Task2.factory.StudentFactory;
import Lecture3.Task2.util.filter.IStudentFilter;
import Lecture3.Task2.util.filter.StudentFilter;
import Lecture3.Task2.util.helper.IStudentHelper;
import Lecture3.Task2.util.helper.StudentHelper;
import Lecture3.Task2.util.helper.ViewHelper;

import java.util.List;
import java.util.Map;

class StudentApp {

    private static final int LIST_SIZE = 30;
    private static final char LETTER = 'g';
    private static final int ID = 17;
    private static final IStudentFilter FILTER = new StudentFilter();
    private static final IStudentHelper HELPER = new StudentHelper();

    public static void main(String[] args) {
        List<Student> students = StudentFactory.createRandomStudentList(LIST_SIZE);
        ViewHelper.printStudents(students);
        students = HELPER.sortStudentsByAge(students);
        ViewHelper.printStudents(students);
        System.out.printf("The average age = %.2f\n", HELPER.getAvgAge(students));
        ViewHelper.printStudents(FILTER.findStudentsByLastNameFirstLetter(students, LETTER));
        Map<Integer, Student> studentMap = HELPER.getStudentsAsMap(students);
        ViewHelper.printStudents(studentMap);
        studentMap = FILTER.findStudentsById(studentMap, ID);
        ViewHelper.printStudents(studentMap);
    }
}
