/*
Вам дается строка S и целочисленный массив индексов int index[s.length].
Напишите программу, которая перетасует символы в S таким образом,
что символ c i-й позиции переместится на индекс index[i] в результирующей строке.

Пример: s = “cba”, index = [3,2,1] result “abc”
*/


public class task2_2 {

    public static void main(String[] args) {

        String s = "cba";
        
        int[] indexes = {3, 2, 1};
        
        System.out.println(reorder(s, indexes));
    }

    public static String reorder(final String s, final int[] indexes) {
        
        char[] chars = s.toCharArray();
        
        String res = "";

        for (int i : indexes)
            res += chars[i - 1];

        return res;
    }

}
