package ClassWork4;

import java.util.LinkedList;
import java.util.Scanner;

//  1. Реализовать консольное приложение, которое:
//  Принимает от пользователя и “запоминает” строки.
// Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.
public class TEST4_1 {
    public static void main(String[] args) {
        startNB();
    }

    private static void startNB() {
        //сканер, который будет читать, что ввел  пользователь
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();


        while (true) {
            System.out.println();
            System.out.print("Вы находитесь в Блокноте \n" +
                    "Введите запись , которую хотите сохранить, или выберите действие:\n" +
                    " 'print' - печать блокнота\n" +
                    " 'выход' - окончание действий \n" +
                    " 'revert' - удаление последней записи и возвращение в меню \n");

            String inputString = in.nextLine();


            if (inputString.trim().length() == 0) { //убирает все незначимые символы в самом начале и в конце

                if (inputString.isBlank()) { //проверяет на то , что есть хоть один значимый символ
                    System.out.println("Строка не должна быть пустой");
                    continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод пользователя
                }
            }
            //проверка введенного сообщения в любом регистре
            if (inputString.equalsIgnoreCase("выход")) {
                System.out.println("До новых записей! ");
                break;//завершаем программу
            }
            //вызываем метод по определенному сообщению пользователя()печать всех элементов
            if (inputString.equalsIgnoreCase("print")) {

                if (!emptyBlock(wordsList)) {

                    printAllNotebook(wordsList);
                }
                //...и возвращаемся в начало цикла, где заново запрашивается ввод строки
                continue;

            }
            if (inputString.equalsIgnoreCase("revert")) {
                if (!emptyBlock(wordsList)) {
                    wordsList.removeFirst();
                    System.out.println("Последняя запись удалена");
                }
                continue;
            }
            wordsList.addFirst(inputString);
            System.out.println(("Заметка добавлена в начало списка"));

        }
    }
    private static void printAllNotebook(LinkedList<String> wordsList) {

        for (int i = 0; i < wordsList.size(); i++) {
            //выводим пронумерованные элементы в консоль
            System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
        }
    }

    private static boolean emptyBlock(LinkedList<String> wordsList) {

        //нет строк в блокноте
        System.out.println("В списке пока ничего нет, сначала заполните его:");
        return wordsList.size() == 0;
    }
}
