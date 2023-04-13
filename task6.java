import java.util.Scanner;

public class task6 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        task6_notebooks nb = new task6_notebooks();

        nb.addNotebook("HP Compaq", 8, 512, "Windows 7", "black");
        nb.addNotebook("HP Envy", 16, 2048, "Windows 10", "gray");
        nb.addNotebook("Packard Bell EasyNote", 8, 1024, "Windows 10", "black");
        nb.addNotebook("Acer Nitro 5", 16, 1024, "Windows 11", "black");

        //nb.showNotebooks();

        nb.showMenu();
        System.out.print("Введите цифру, соответствующую необходимому критерию: ");
        int res = sc.nextInt();
        sc.nextLine();
        
        String query;

        switch(res) {
            case 1:
                nb.showRamAvailable();
                System.out.print("Введите значение ОЗУ: ");
                query = sc.nextLine();
                nb.showQueryResult("ram", query);
                break;
            case 2:
                nb.showSsdAvailable();
                System.out.print("Введите значение SSD: ");
                query = sc.nextLine();
                nb.showQueryResult("ssd", query);
                break;
        }
    }
}
