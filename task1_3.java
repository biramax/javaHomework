/*
Реализовать простой калькулятор (+,-,=,*), только с целыми числами.
*/

import java.util.Scanner;

public class task1_3 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.printf("Введите первое число: ");
        int a = in.nextInt();
        in.nextLine();

        System.out.printf("Введите второе число: ");
        int b = in.nextInt();
        in.nextLine();

        System.out.printf("Введите действие (+,-,*,/): ");
        String o = in.nextLine();

        in.close();

        int res = 0;

        switch (o) {
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/": res = a / b; break;
        }
    
        System.out.println("Результат: "+res);
    }
}
