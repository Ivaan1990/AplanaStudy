package FirstTask;

import java.util.Scanner;

/**
 * Точка входа программы
 * @author Ivan Yushin
 *
 * @see Calculator
 * @see StringArray
 */
public class Launcher {
    public static void main(String[] args) {
        while (true){
            System.out.println("Введите номер задачи: (1 - calculator, 2 - string array)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine().trim();
            switch (choice){
                case "1":
                    Calculator calculator = new Calculator();
                    calculator.startCalculator();
                    break;
                case "2":
                    StringArray stringArray = new StringArray();
                    System.out.println("Максимальная длина у слова " + stringArray.getMaximumLengthWord());
                    break;
                default:
                    System.out.println("Некорректная команда");
                    break;
            }
            System.out.println("\nВведите q чтобы выйти, продолжить Enter ");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("q")){
                break;
            }
        }
    }
}