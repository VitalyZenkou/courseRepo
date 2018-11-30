package lecture3.task2.util.filter;

import lecture3.task2.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentStreamFilter implements IStudentFilter {


    @Override
    public List<Student> findStudentsByLastNameFirstLetter(List<Student> students, char letter) {
        return students.stream().
                filter(student -> Character.toLowerCase(student.getLastName().charAt(0)) == Character.toLowerCase(letter))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Student> findStudentsById(Map<Integer, Student> studentsMap, int id) {
        return studentsMap.entrySet().stream()
                .filter(studentMap -> studentMap.getKey() >= id)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
