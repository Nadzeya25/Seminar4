package ClassWork4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ex0();
        ex1();
    }

    private static void ex0() {
        final int SIZE = 1_000_000;
        Random random = new Random();

        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(0, random.nextInt());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(0, random.nextInt());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }

    private static void ex1() {
    //сканер, который будет читать, что ввел  пользователь
        Scanner in = new Scanner(System.in);
    //удобный способ добавить несколько элементов в существующую коллекцию
        LinkedList<String> wordsList = new LinkedList<>();
    //в скобках - куда добавляем, что добавляем
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            //Этот метод можно использовать для обрезки пробелов (как определено выше) в начале и в конце строки.
            if (inputString.trim().length() == 0) { //убирает все незначимые символы в самом начале и в конце

                // if (inputString.isBlank()) { проверяет на то , что есть хоть один значимый символ
                System.out.println("Строка не должна быть пустой");
                continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод строки
            }
            //проверка введенного сообщения в любом регистре
            if (inputString.equalsIgnoreCase("выход")) {
                break;//завершаем программу
            }
            //вызываем метод по определенному сообщению пользователя()печать всех элементов
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordsList);
                continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод строки
            }
            //если отсутствие тильды обнаружилось, выводим предупреждение
            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду");
                continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод строки
            }
//если тильда на месте, продолжаем:
            //сплитуем строку по тильде на 2 элемента
            String[] parts = inputString.split("\\~");
//проверяем, если элемента не два(как нам надо было), получаем предупреждение и ...
            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод строки
            }
//если все ок, то продолжаем:
            String word = parts[0]; //этот кусочек будет словом
            int num = 0;

            try {
                num = Integer.parseInt(parts[1]);//этот кусочек станет индексом, перевели в число
            } catch (NumberFormatException e) {
                //если перевод в число не получился, то выводим ошибку и ...
                System.out.println("Выражение не содержит числа");
                continue;//...и возвращаемся в начало цикла, где заново запрашивается ввод строки
            }
// продолжаем :

            //если введено слово принт...
            if (word.equalsIgnoreCase("print")) {

                //если число не попадает в диапазон И значение равно null
                if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)) {
                    System.out.println("Указанного значения не существует");
                } else {
                    System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
                    wordsList.remove(num - 1);
                }

                //если попали в диапазон, и там уже есть другое значнние, то
            } else if (isNumberInRange(num, wordsList.size())) {
                String oldWord = wordsList.get(num - 1);//Возвращает элемент в указанной позиции в этом списке.

                if (valueIsNull(wordsList, num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordsList.set(num - 1, word);//Заменяет элемент в указанной позиции в этом списке указанным элементом
            } else {
                int nullCount = num - wordsList.size() - 1;//количество пустых позиций , которые надо заполнить нулами
                for (int i = 0; i < nullCount; i++) {
                    wordsList.add(null);//заполняем нуллами
                }
                wordsList.add(word);
                printAddMessage(word, num);
            }
        }

    }


    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        //метод перебора всех элементов, чтобы строки со значением null не выводились
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                //выводим пронумерованные элементы в консоль
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {

        //число не null
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        //метод, проверяющий , попадает ли число в диапазон
        return num >= 1 & num <= size;
    }
}
