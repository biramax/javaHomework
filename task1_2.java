/*
Вводится число n, затем n чисел целых, по одному на каждой строке. Затем вводится число, на которое нужно умножить все введённые выше числа. Выведите на экран результат умножения построчно.

Sample Input:
4
1
2
3
5
2

Sample Output:
2
4
6
10
*/

import java.util.Scanner;

public class task1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Размерность: ");
        int size = in.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i ++) {
            System.out.printf("Элемент #"+(i + 1)+": ");
            arr[i] = in.nextInt();
        }

        System.out.printf("На что умножить: ");
        int k = in.nextInt();

        in.close();

        for (int item : arr)
            System.out.println(item * k);
    }
}
