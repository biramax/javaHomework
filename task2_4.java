/*
Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
Требуется перехватить все возможные ошибки и вывести их в логгер.

После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
*/
import java.util.Scanner;
import java.io.FileWriter;
import java.util.logging.*;

public class task2_4 {
    
    private static Logger logger = Logger.getLogger(task2_4.class.getName());
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // настройка обработчика файлового логгера
        try {
            FileHandler fileHandler = new FileHandler("task2_4__log.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось настроить логгер", e);
        }

        try {
            System.out.printf("Введите число от -128 до 128: ");
            byte a = sc.nextByte();
            
            try (FileWriter fw = new FileWriter("task2_4__file.txt", false)) {
                fw.write(Byte.toString(a));
                fw.flush();
                logger.info("Число успешно записано в файл.");
            }
            catch(Exception e) {    
                logger.log(Level.SEVERE, "Ошибка сохранения числа в файл: ", e);
            }
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Ошибка ввода числа в формате byte: ", e);
        }
    }
}

