import java.util.logging.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class task2_5 {
    
    private static Logger logger = Logger.getLogger(task2_5.class.getName());
    private static String logFileName = "task2_5__log.txt";
    private static String fileName = "task2_5__file.txt";

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
        
        // Загружаем файл по ссылке, выводим в консоль содержимое и сохраняем в файл
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String fileContent = download(fileUrl, fileName);
        logger.info("Содержимое скачанного файла:\n"+fileContent+"\n");

        // Заменяем имя по маске, выводим в консоль содержимое
        String replacedContent = change("Максим", fileContent);
        logger.info("Изменили имя:\n"+replacedContent+"\n");

        // Снова сохраняем в файл
        saveOnLocal(fileName, replacedContent);

        // Читаем из файла
        read(fileName);

        // Удаляем файл
        removeFromLocale(fileName);

    }
    
    public static String download(String fileUrl, String localFilename) {
        
        StringBuilder content = new StringBuilder();
        
        try {
            URI uri = new URI(fileUrl);
            URL url = uri.toURL();
            
            // Сохраняем файл в переменную content
            BufferedReader in_ = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in_.readLine()) != null)
                content.append(inputLine);
            in_.close();

            // И сохраняем в файл
            InputStream in = url.openStream();
            FileOutputStream out = new FileOutputStream(localFilename);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();

            logger.info("Файл скачан и сохранён.\n");
        } 
        catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось скачать файл:\n", e+"\n");
        }

        return content.toString();
    }
    
    public static String change(String name, String fileContent) {
        return fileContent.replaceAll("%s", name);
    }
    
    public static void read(String localFilename) {

        try {
            File file = new File(localFilename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            reader.close();
            String content = stringBuilder.toString();
            logger.info("Считали файл:\n"+content);
        } 
        catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка чтения файла:\n", e+"\n");
        }
    }
    
    public static void saveOnLocal(String fileName, String fileContent) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(fileContent);
            fw.flush();
            logger.info("Файл сохранён.\n");
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Ошибка сохранения в файл:\n", e+"\n");
        }

    }
    
    public static void removeFromLocale(String fileName) {
        File file = new File(fileName);
        try {
            file.delete();
            logger.info("Файл успешно удалён.\n");
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Ошибка удаления файла:\n", e+"\n");
        }
    }
}