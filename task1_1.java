/*
1.Создайте массив, в котором будут храниться кубы чисел от 1 до 1000. Затем вводятся 2 числа из этого диапазона. Используя данные из массива найдите их кубы.

Sample Input:
8
11

Sample Output:
512
1331
*/

import java.util.Scanner;

public class task1_1 {
    public static void main(String[] args) {
        
        int[] arr = new int[1001];
        for (int i = 0; i <= 1000; i ++)
            arr[i] = (int) Math.pow(i, 3);
        
        Scanner in = new Scanner(System.in);
        int a = getInt(in, "Первое число");
        int b = getInt(in, "Второе число");
        in.close();

        System.out.println("Куб первого числа: "+arr[a]);
        System.out.println("Куб второго числа: "+arr[b]);
    }

    public static int getInt(Scanner in, String input_text) {
        int x;
        while (true) {
            System.out.printf(input_text+": ");
            x = in.nextInt();
            if (x < 1 || x > 1000)
                System.out.println("Диапазон должен быть от 1 до 1000");
            else
                break;
        }
        return x;
    } 
}
