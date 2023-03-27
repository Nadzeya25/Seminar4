package HomeWork4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class Task4_2 {
    public static void main(String[] args) {
        List<Integer> listInt = new LinkedList<>();
        listInt.add(11);
        listInt.add(22);
        listInt.add(33);
        listInt.add(44);
        System.out.println(listInt);
        Stack<Integer> stackInt = new Stack<>();
        stackInt.addAll(listInt);
        listInt.clear();
        while (!stackInt.empty())//Проверяет, пуст ли этот стек.
            listInt.add(stackInt.pop());//Удаляет объект в верхней части этого стека и возвращает этот объект как значение этой функции
        System.out.println(listInt);
    }
}