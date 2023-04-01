/*
Реализовать простой калькулятор (+,-,=,*), только с целыми числами.
*/

import java.util.Scanner;
import java.util.logging.*;

public class task1_3 {

    private static Logger logger = Logger.getLogger(task2_5.class.getName());
    private static String logFileName = "task1_3__log.txt";

    public static void main(String[] args) {

        // Настройка обработчика файлового логгера
        try {
            FileHandler fileHandler = new FileHandler(logFileName);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось настроить логгер:\n", e+"\n");
        }
        
        Scanner in = new Scanner(System.in);

        System.out.printf("Введите первое число: ");
        int a = in.nextInt();
        in.nextLine();

        logger.info("Ввели первое число: "+a+"\n");

        System.out.printf("Введите второе число: ");
        int b = in.nextInt();
        in.nextLine();

        logger.info("Ввели второе число: "+b+"\n");

        System.out.printf("Введите действие (+,-,*,/): ");
        String o = in.nextLine();

        logger.info("Ввели требуемое действие: "+o+"\n");

        in.close();

        int res = 0;

        switch (o) {
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/": res = a / b; break;
        }
    
        System.out.println("Результат: "+res);

        logger.info("Получили результат: "+res+"\n");
    }
}


