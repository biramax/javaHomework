/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class task5_2 {
    public static void main(String[] args) {

        String[] names = {
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"            
        };

        String fname;
        String[] nameParts;
        HashMap<String, Integer> map = new HashMap<>();

        // Получаем массив имён с количеством их повторений
        // {Мария=3, Марина=2, Светлана=1, Кристина=1, Анна=3, Иван=4, Петр=3, Павел=1}
        for (String name : names) {
            nameParts = name.split(" ");
            fname = nameParts[0];
            map.put(fname, map.containsKey(fname) ? map.get(fname) + 1 : 1);
        }
        
        // Составляем массив только из количеств повторений имён
        // [3, 2, 1, 1, 3, 4, 3, 1]
        int[] arr = map.values().stream().mapToInt(Integer::intValue).toArray();

        // Оставляем только уникальные числа. Значения 1 убираем
        // [3, 2, 4]
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i > 1 && list.indexOf(i) == -1)
                list.add(i);
        }

        // ArrayList преобразуем в массив
        int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();

        // Сортируем его в порядке убывания 4 3 2
        selectionSort(arr2);

        // Выводим имена, которые встречаются более одного раза
        /*
        Иван (4)
        Мария (3)
        Анна (3)
        Петр (3)
        Марина (2)
        */
        for (int i : arr2) {
            for (var j : map.entrySet()) {
                if (j.getValue() == i)
                    System.out.println(j.getKey()+" ("+i+")");
            }
        }
    }

    // Сортировка выборкой
    public static int[] selectionSort(int[] arr) {
                
        int minIndex, temp;
        for (int i = 0; i < arr.length; i ++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] > arr[minIndex])
                    minIndex = j;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        return arr;
    }
}
