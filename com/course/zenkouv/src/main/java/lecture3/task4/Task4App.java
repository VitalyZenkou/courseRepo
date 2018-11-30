package lecture3.task4;

import java.util.*;

public class Task4App {

    private static final int MAX_INIT = 10_000_000;
    private static final int CHANGE_SIZE = 1000;
    private static final String ARRAY_LIST_TIME = "arrayListTime: ";
    private static final String LINKED_LIST_TIME = "linkedListTime: ";
    private static HashMap<String, List<Long>> timeResult = new HashMap<>();
    private static final Random RANDOM = new Random();
    private static List<Integer> arrayList = new ArrayList<>();
    private static List<Integer> linkedList = new LinkedList<>();
    private static Long startTime;

    public static void main(String[] args) {
        initList(arrayList);
        initList(linkedList);
        addSomeElements(arrayList);
        addSomeElements(linkedList);
        findSomeElements(arrayList);
        findSomeElements(linkedList);
        deleteSomeElements(arrayList);
        deleteSomeElements(linkedList);
        printResult();
    }

    private static void initList(List<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_INIT; i++) {
            list.add(RANDOM.nextInt(1000));
        }
        putTime(list, System.currentTimeMillis() - startTime);
    }

    private static void addSomeElements(List<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < CHANGE_SIZE; i++) {
            list.add(RANDOM.nextInt(1000));
        }
        putTime(list, System.currentTimeMillis() - startTime);
    }

    private static void findSomeElements(List<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= CHANGE_SIZE; i++) {
            int randomNumber = RANDOM.nextInt(1000);
            for (Integer integer : list) {
                if (integer.equals(randomNumber)) {
                    break;
                }
            }
        }
        putTime(list, System.currentTimeMillis() - startTime);
    }

    private static void deleteSomeElements(List<Integer> list) {
        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < CHANGE_SIZE; i++) {
            int randomNumber = RANDOM.nextInt(1000);
            while (iterator.hasNext()) {
                Integer item = iterator.next();
                if (item.equals(randomNumber)) {
                    iterator.remove();
                    break;
                }
            }
        }
        putTime(list, System.currentTimeMillis() - startTime);
    }

    private static void putTime(List<Integer> list, Long value) {
        if (list instanceof ArrayList) {
            if (timeResult.containsKey(ARRAY_LIST_TIME)) {
                timeResult.get(ARRAY_LIST_TIME).add(value);
            } else {
                timeResult.putIfAbsent(ARRAY_LIST_TIME, new ArrayList<>());
                timeResult.get(ARRAY_LIST_TIME).add(value);
            }
        } else if (list instanceof LinkedList) {
            if (timeResult.containsKey(LINKED_LIST_TIME)) {
                timeResult.get(LINKED_LIST_TIME).add(value);

            } else {
                timeResult.put(LINKED_LIST_TIME, new ArrayList<>());
                timeResult.get(LINKED_LIST_TIME).add(value);
            }
        }
    }

    private static void printResult() {
        for (Map.Entry<String, List<Long>> time : timeResult.entrySet()) {
            if (time.getKey().equals(ARRAY_LIST_TIME)) {
                System.out.print(ARRAY_LIST_TIME + " ");
                for (Long sec : time.getValue()) {
                    System.out.printf("[%-4d]", sec);
                }
                System.out.println();
            } else {
                System.out.print(LINKED_LIST_TIME);
                for (Long sec : time.getValue()) {
                    System.out.printf("[%-4d]", sec);
                }
                System.out.println();
            }
        }
    }
}
