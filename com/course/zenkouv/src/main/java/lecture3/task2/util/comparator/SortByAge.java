package lecture3.task2.util.comparator;

import lecture3.task2.Student;

import java.util.Comparator;

public class SortByAge implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
