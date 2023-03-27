package Lesson_04;

import java.util.Stack;

public class Ex005 {

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // (1+2*3*4)*(10/5) - 20
        // 1 2 3 * 4 * + 10 5 / * 20 -

        //выражение в постфиксной форме
        //var exp = "20 30 - 10 *".split(" "); // (20-30)*10
//разбираем его с помощью сплита с учетом символоразделителя пробел
        var exp = "1 2 + 3 *".split(" "); // (1 + 2) * 3

        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        //переменная, где мы будем хранить результат вычисления
        int res = 0;
        System.out.println(exp);
        //стэк , который будет в себе хранить числа
        Stack<Integer> st = new Stack<>();

        //пробегаемся по всем элементам выражения, проверяем...
        for (int i = 0; i < exp.length; i++) {
//если текущий элемент выражения является числом,
            if (isDigit(exp[i])) {

                //то добавляем его в стэк, преобразовав из строки  в число
                st.push(Integer.parseInt(exp[i]));
            } else {
                //если элемент не число, а знак, рассматриваем все варианты вычислений
                switch (exp[i]) {
                    case "+":
                        //результат равен сумме двух извлеченных их стэка чисел
                        res = st.pop() + st.pop();
                        //кладем результата в стэк
                        st.push(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        res =  st.pop()/ st.pop();
                        st.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        //извлекаем последний элемент из стэка, получая значение выражения
        System.out.printf("%d\n", st.pop());
    }
}