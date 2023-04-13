import java.util.HashMap;
import java.util.TreeSet;

public class task6_notebooks {

    static int nbKey = 0;

    // id ноутбука | Название
    public HashMap<Integer, String> db_nb = new HashMap<>();

    // id ноутбука | ОЗУ
    public HashMap<Integer, Integer> db_ram = new HashMap<>();

    // id ноутбука | SSD
    public HashMap<Integer, Integer> db_ssd = new HashMap<>();


    void addNotebook(String name, int ram, int ssd, String os, String color) {
        nbKey ++;
        db_nb.put(nbKey, name);
        db_ram.put(nbKey, ram);
        db_ssd.put(nbKey, ssd);
    }

    void showNotebooks() {
        System.out.println("Все ноутбуки:");
        for (int i = 1; i <= db_nb.size(); i++) {
            System.out.println(db_nb.get(i));
        }
    }

    void showMenu() {
        showDelimiter();
        System.out.println("Доступные критерии поиска:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        // System.out.println("3 - Операционная система");
        // System.out.println("4 - Цвет");
        showDelimiter();
    }

    void showRamAvailable() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= db_ram.size(); i++)
            set.add(db_ram.get(i));        
        showDelimiter();
        System.out.println("Доступные варианты ОЗУ:");
        for (int elem : set)
            System.out.print(elem+" ");
        System.out.println();
        showDelimiter();
    }

    void showSsdAvailable() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= db_ssd.size(); i++)
            set.add(db_ssd.get(i));
        showDelimiter();
        System.out.println("Доступные варианты SSD:");
        for (int elem : set)
            System.out.print(elem+" ");
        System.out.println();
        showDelimiter();
    }

    void showQueryResult(String category, String value) {
        showDelimiter();
        System.out.println("Подходящие ноутбуки:");
        boolean found = false;
        switch (category) {
            case "ram":
                int ram = Integer.parseInt(value);
                for (int i = 1; i <= db_ram.size(); i++) {
                    if (db_ram.get(i) == ram) {
                        found = true;
                        System.out.println("- "+db_nb.get(i));
                    }
                }
                break;
            case "ssd":
                int ssd = Integer.parseInt(value);
                for (int i = 1; i <= db_ssd.size(); i++) {
                    if (db_ssd.get(i) == ssd) {
                        found = true;
                        System.out.println("- "+db_nb.get(i));
                    }
                }
                break;
        }
        if (!found)
            System.out.println("Варианты не найдены :(");
        showDelimiter();
    }

    void showDelimiter() {
        System.out.println("--------------------------------");
    }
}
