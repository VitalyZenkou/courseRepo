package lecture3.task3;

import lecture3.task2.Student;
import lecture3.task2.factory.StudentFactory;
import lecture3.task2.util.filter.IStudentFilter;
import lecture3.task2.util.filter.StudentStreamFilter;
import lecture3.task2.util.helper.IStudentHelper;
import lecture3.task2.util.helper.StudentStreamHelper;
import lecture3.task2.util.helper.ViewHelper;

import java.util.List;
import java.util.Map;

class StudentStreamApp {

    private static final int LIST_SIZE = 30;
    private static final char LETTER = 'g';
    private static final int ID = 29;
    private static final IStudentFilter FILTER = new StudentStreamFilter();
    private static final IStudentHelper HELPER = new StudentStreamHelper();

    public static void main(String[] args) {
        List<Student> students = StudentFactory.createRandomStudentList(LIST_SIZE);
        ViewHelper.printStudents(students);
        students = HELPER.sortStudentsByAge(students);
        ViewHelper.printStudents(students);
        System.out.printf("The average age = %.2f\n", HELPER.getAvgAge(students));
        ViewHelper.printStudents(FILTER.findStudentsByLastNameFirstLetter(students, LETTER));
        Map<Integer, Student> studentsMap = HELPER.getStudentsAsMap(students);
        ViewHelper.printStudents(studentsMap);
        ViewHelper.printStudents(FILTER.findStudentsById(studentsMap, ID));
    }
}
