package lecture3.task2.util.filter;

import lecture3.task2.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentFilter implements IStudentFilter {

    @Override
    public List<Student> findStudentsByLastNameFirstLetter(List<Student> students, char letter) {
        List<Student> foundStudents = new ArrayList<>();
        if (!students.isEmpty()) {
            for (Student student : students) {
                if (student.getLastName().toLowerCase().startsWith(Character.toString(letter).toLowerCase())) {
                    foundStudents.add(student);
                }
            }
        } else {
            System.out.println("This students list is empty");
        }
        return foundStudents;
    }

    @Override
    public Map<Integer, Student> findStudentsById(Map<Integer, Student> studentMap, int id) {
        Map<Integer, Student> studentsHashMap = new HashMap<>();
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            if (entry.getKey() >= id) {
                studentsHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return studentsHashMap;
    }
}
