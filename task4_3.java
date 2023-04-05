import java.util.ArrayDeque;
import java.util.Deque;

public class task4_3 {

    //Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

    public static void main(String[] args) {

        String str = "()[]"; // true
        // String str = "()"; // true
        // String str = "{[()]}"; // true
        // String str = "()()"; // true
        // String str = ")()("; // false
        // String str = "({([})"; // false
        // String str = "(test)(){hello[()ok]}"; // true

        String openTags  = "({["; // набор открывающих скобок
        String closeTags = ")}]"; // набор закрывающих скобок
        
        boolean res = true;

        Deque<Character> deque = new ArrayDeque<>();
        
        // Сделаем перебор символов в заданной строке.
        // Если попадётся открывающая скобка, положим её в начало deque.
        // Если попадётся закрывающая скобка, возьмём (с удалением) первый элемент deque (открывающая скобка) и проверим его на соответствие нашей закрывающей скобке.
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            // Если симол является открывающей скобкой
            if (openTags.indexOf(ch) >= 0) {
                // Кладём его в начало deque
                deque.offerFirst(ch);
            } 
            else {
                int index = closeTags.indexOf(ch);
                // Если симол является закрывающей скобкой
                if (index >= 0) {
                    // Если deque пустой (ещё не было открывающих скобок) или закрывающая скобка не соответствует открывающей
                    if (deque.size() == 0 || deque.pollFirst() != openTags.charAt(index)) {
                        res = false;
                        break;
                    }
                }
            }
            if (!res)
                break;
        }

        System.out.println(res);
    }
}