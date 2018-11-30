package lecture3.task2.util.helper;

import lecture3.task2.Student;

import java.util.List;
import java.util.Map;

public class ViewHelper {

    private static final String SEPARATOR = "-----------------------------------------------------------------------------";

    private ViewHelper(){
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println(SEPARATOR);
    }

    public static void printStudents(Map<Integer, Student> studentMap) {
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.printf("Key - [%3d]: %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println(SEPARATOR);
    }
}
