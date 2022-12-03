//        Реализуйте очередь с помощью LinkedList со следующими методами:
//        enqueue() - помещает элемент в конец очереди,
//        dequeue() - возвращает первый элемент из очереди и удаляет его,
//        first() - возвращает первый элемент из очереди, не удаляя.


import java.util.LinkedList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
    LinkedList <Integer> testList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            testList.add(i, rand.nextInt(100));
        }

        //запуски и проверки
        System.out.println(testList);
        enqueue(testList,123);
        System.out.println(testList);
        int myValue = dequeue(testList);
        System.out.println(myValue);
        System.out.println(testList);
        myValue =  first(testList);
        System.out.println(myValue);
        System.out.println(testList);
    }

    public static void enqueue(LinkedList myList, int value) {;
        myList.add(value);
    }

    public static int dequeue(LinkedList myList) {
        int answer = (Integer) myList.get(0);
        myList.remove(0);
        return answer;
    }

    public static int first(LinkedList myList) {
        return (Integer) myList.get(0);
    }
}
