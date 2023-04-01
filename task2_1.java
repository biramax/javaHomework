/*
Посчитайте сколько драгоценных камней в куче обычных камней

Пример:
jewels = “aB”, stones = “aaaAbbbB”
Результат в консоль ”a3B1”
*/


public class task2_1 {

    public static void main(String[] args) {

        String jewels = "aB", stones = "aaaAbbbB";

        System.out.println(findJewelsInStones(jewels, stones));
    }

    public static String findJewelsInStones(String jewels, String stones) {

        String res = "";
        int counter = 0;

        for (int i = 0; i < jewels.length(); i ++) {
            
            res += jewels.charAt(i);
            counter = 0;
            
            for (int j = 0; j < stones.length(); j ++)
                if (jewels.charAt(i) == stones.charAt(j))
                    counter ++;
            
            res += counter;
        }
        
        return res;
    }

}