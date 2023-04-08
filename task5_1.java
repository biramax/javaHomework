/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class task5_1 {
    public static void main(String[] args) {
        
        // База данных телефонов
        Map<Integer, String> tels = new HashMap<>(Map.of(
            1, "+79186713425",
            2, "+79186713524",
            3, "+79283450314", 
            4, "+79034903243"
        ));

        // База данных пользователей
        Map<Integer, String> users = new HashMap<>(Map.of(
            1, "Максим Бобков", 
            2, "Юрий Сысоев", 
            3, "Дмитрий Кимешкез"
        ));
        
        // Сводная база данных, где ключи - это id телефонов, а значения - id пользователей
        Map<Integer, Integer> tels_users = new HashMap<>(Map.of(
            1, 1,
            2, 1,
            3, 2,
            4, 2
        ));

        // Выводим телефоны Максима Бобкова
        System.out.println(users.get(1)+':');
        int tel_id;
        int user_id;
        for (var item : tels_users.entrySet()) {
            tel_id = item.getKey();
            user_id = item.getValue();
            if (user_id == 1)
                System.out.println(tels.get(tel_id));
        }
        /*  Output:
            Максим Бобков:
            +79186713425
            +79186713524
         */
    }
}
