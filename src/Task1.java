//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        LinkedList <Integer> myList = new LinkedList<>();
        Random rand = new Random();
        int length = rand.nextInt(40);
        for (int i = 0; i < length; i++) {
            myList.add(i, rand.nextInt(100));
        }
        System.out.println(myList);
        myList = flip(myList);
        System.out.println(myList);

    }

    public static LinkedList<Integer> flip(LinkedList<Integer> array) {
        int temp;
        int size = array.size();
        for (int i = 0; i < size / 2; i++) {
            temp = array.get(i);
            array.set(i, array.get(size - i - 1));
            array.set(size - i - 1, temp);
        }
        return array;
    };

}
