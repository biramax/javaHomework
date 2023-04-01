/*
На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк - строки книги. потом вводится натуральное число m - количество продуктов, на которые у человека аллергия. Потом вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на который у человека аллергия и продукт2 - продукт, на который следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова. название продуктов написаны строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену, не встречаются изначально в тексте.

Выходные данные
Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться с большой буквы!

Sample Input:
2
Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
3
арахис - колбаса
клубника - вишня
сгущенка - молоко

Sample Output:
Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его. Посыпьте измельчённый колбаса на мороженое.
Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class task2_3 {
    public static void main(String[] args) {

        /* Для тестирования
        List<String> recipesList = new ArrayList<>(Arrays.asList(
            "Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.",
            "Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни."
        ));

        List<String> prodsSearchList = new ArrayList<>(Arrays.asList(
            "арахис",
            "клубника",
            "сгущенка"
        ));

        List<String> prodsReplaceList = new ArrayList<>(Arrays.asList(
            "колбаса",
            "вишня",
            "молоко"
        ));
        */

        // Вводим данные -----------------------------------------------------
        Scanner sc = new Scanner(System.in, "Cp866");

        System.out.printf("Введите число строк в книге: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> recipesList = new ArrayList<>(); // Рецепты

        for (int i = 0; i < n; i ++) {
            System.out.printf("Введите строку #"+(i + 1)+": ");
            recipesList.add(sc.nextLine());
        }

        System.out.printf("Введите число замен продуктов: ");
        int m = sc.nextInt();
        sc.nextLine();
        
        List<String> prodsSearchList = new ArrayList<>(); // Продукты, удаляемые из рецепта
        List<String> prodsReplaceList = new ArrayList<>(); // Новые продукты

        for (int i = 0; i < m; i ++) {
            System.out.printf("Введите продукт и его замену #"+(i + 1)+": ");
            String[] prods = sc.nextLine().split("-");
            prodsSearchList.add(prods[0].trim());
            prodsReplaceList.add(prods[1].trim());
        }

        sc.close();
        // /Вводим данные ----------------------------------------------------

        // Добавляем в prodsSearchList и prodsReplaceList те же продукты с Большой буквы
        for (int i = 0, size = prodsSearchList.size(); i < size; i ++) {
            prodsSearchList.add(prodsSearchList.get(i).substring(0, 1).toUpperCase()+prodsSearchList.get(i).substring(1));
            prodsReplaceList.add(prodsReplaceList.get(i).substring(0, 1).toUpperCase()+prodsReplaceList.get(i).substring(1));
        }

        // Открываем пустой список рецептов с заменёнными продуктами
        List<String> recipesListNew = new ArrayList<>();

        // Перечисляем рецепты и заменяем в них слова
        for (int i = 0; i < recipesList.size(); i ++) {
            String recipe = recipesList.get(i);
            for (int j = 0; j < prodsSearchList.size(); j ++)
                recipe = recipe.replaceAll(prodsSearchList.get(j), prodsReplaceList.get(j));
            recipesListNew.add(recipe);
        }

        // Вывод
        for (String recipe : recipesListNew)
            System.out.println(recipe);
    }
}
