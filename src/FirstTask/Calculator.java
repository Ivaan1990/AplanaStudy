package FirstTask;

import java.util.Scanner;

/**
 * @author Ivan Yushin
 * @see #startCalculator()
 */
public class Calculator {

    private double first;
    private double second;
    private char operation;

    public Calculator() {
        System.out.println("Welcome to calculator");
    }

    /**
     * Метод работы калькулятора
     * @see #getResult(double, double, char), вызывается после корректного ввода цифр и команды вычисления
     */
    public void startCalculator(){
        Scanner sc = new Scanner(System.in);
        String line;
        try {
            System.out.print("Введите первое число ");
            line = sc.nextLine();
            first = Double.parseDouble(line);
            System.out.print("Введите второе число ");
            line = sc.nextLine();
            second = Double.parseDouble(line);
            System.out.print("Выберите операцию - * / + - ");
            operation = sc.next().charAt(0);
            getResult(first, second, operation);
        } catch (NumberFormatException ex){
            System.out.println("повторите ввод");
            startCalculator();
        }
    }

    /**
     * Метод выводит в консоль результат вычисления двух чисел
     * @param first первая цифра введённая пользователем
     * @param second вторая цифра введённая пользователем
     * @param oper выбранная операция вычисления
     */
    private void getResult(double first, double second, char oper){
        switch(oper){
            case '*':
                System.out.printf("Multiply is %.4f", first * second);
                break;
            case '/':
                if (first == 0 | second == 0){
                    System.out.print("На ноль делить нельзя!");
                    break;
                }
                System.out.printf("Divide is %.4f", first / second);

                break;
            case '+':
                System.out.printf("Sum is %.4f", first + second);
                break;
            case '-':
                System.out.printf("Difference is %.4f", first - second);
                break;
        }
    }
}