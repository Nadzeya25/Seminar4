package ClassWork4;

import java.util.LinkedList;
import java.util.Scanner;

//1. Реализовать консольное приложение, которое:
//        Принимает от пользователя строку вида
//        text~num
//        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//        Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
public class Less4T1 {
    public static void main(String[] args) {
        LinkedList<String> ourList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите текст в формате text~num: ");
            String text = scanner.nextLine();
            String[] parts = text.split("\\~");
            if (parts.length == 2){
                if (parts[0].equals("stop")) {
                    break;
                } else if (parts[0].equals("print")) {
                    String value = String.valueOf(ourList.remove(parts[1]));
                    System.out.println(value);
                } else {
                    if (Integer.parseInt(parts[1]) < ourList.size()) {
                        ourList.set(Integer.parseInt(parts[1]), parts[0]);
                    } else if (Integer.parseInt(parts[1]) == ourList.size()) {
                        ourList.add(Integer.parseInt(parts[1]), parts[0]);
                    } else {
                        int size = ourList.size();
                        for (int i = 0; i < Integer.parseInt(parts[1]) - size; i++) {
                            ourList.add(null);
                        }
                        ourList.add(Integer.parseInt(parts[1]), parts[0]);
                    }


            }
        } else {
                System.out.println("Введите текст в формате text~num: ");
            }
        }
        scanner.close();
    }
}
