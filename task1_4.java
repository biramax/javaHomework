/*
Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
*/

import java.util.Scanner;

public class task1_4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("Вам будет предложено ввести два слагаемых и сумму. Во всех трёх числах некоторые цифры вы можете заменять знаком ?");
        System.out.println("--------------------------");

        System.out.printf("Введите первое слагаемое: ");
        String a = in.nextLine();

        System.out.printf("Введите второе слагаемое: ");
        String b = in.nextLine();

        System.out.printf("Введите сумму: ");
        String c = in.nextLine();

        in.close();

        // Длина каждого числа
        int a_len = a.length();
        int b_len = b.length();
        int c_len = c.length();

        // Конкатенируем все числа как строки
        String all = a+b+c;
        // Переводим в массив чаров
        char[] all_chars = all.toCharArray();
        // Узнаём число знаков "?"
        long num_x = all.chars().filter(ch -> ch == '?').count(); 

        // Число комбинаций значений во всех "?" (например, при трёх "?" будет 999 комбинаций)
        int num_variants = 10;
        for (int i = 1; i < num_x; i ++) 
            num_variants *= 10;
        
        // Инициализируем массив для перечисления комбинаций, размерность по числу знаков "?"
        int arr[] = new int[(int)num_x];
        
        // Заготовка под ответ на решение задачи
        String res = "Решения нет";

        // Перечисляем все комбинации
        for (int i = 0; i < num_variants; i ++) {
            
            // Формируем очередной вариант наполнения массива arr, размерность по числу знаков "?", например {1, 2, 5}
            // Значения этого массива дальше распределим по всем знакам "?"
            int k = 10;
            for (int j = arr.length - 1; j >= 0; j --) {
                arr[j] = k > i ? (k / 10 > i ? 0 : i / (k / 10)) : i % k / (k / 10);
                k *= 10;
            }
            
            // Формируем строку, в которой все числа примера будут конкатенированы.
            // Вместо знаков "?" подставляем значения массива arr
            int j = 0;
            String str = "";
            for (char ch : all_chars) {
                if (ch == '?') {
                    str += arr[j];
                    j ++;
                } else 
                    str += ch;
            }
            
            // Разбиваем строку на составляющие примера - слагаемые и сумму
            int a_ = Integer.parseInt(str.substring(0, a_len));
            int b_ = Integer.parseInt(str.substring(a_len, a_len + b_len));
            int c_ = Integer.parseInt(str.substring(a_len + b_len, a_len + b_len + c_len));
            
            if (a_ + b_ == c_) {
                res = "Решение: "+a_+" + "+b_+" = "+c_;
                break;
            }
        }

        System.out.println("--------------------------");
        System.out.println(res);
        System.out.println("--------------------------");
    }
}