package Lecture3.Task2.factory;

import Lecture3.Task2.Student;
import Lecture3.Task2.util.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {

    private StudentFactory() {
    }

    public static List<Student> createRandomStudentList(int listSize) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            students.add(new Student(RandomUtil.generateRandomString(), RandomUtil.generateRandomString(), (int) (Math.random() * 18) + 7));
        }
        return students;
    }
}
