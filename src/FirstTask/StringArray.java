package FirstTask;

import java.util.Scanner;

/**
 * @author Ivan Yushin
 * @see #getMaximumLengthWord()
 * @see #array
 */
public class StringArray {

    /** Поле массив слов */
    private String[] array;

    public StringArray() {
        System.out.println("Welcome to String array");
    }

    /**
     * метод заполнения масссива, длина выбирается пользователем
     * @return результат работы метода getWord()
     * @see #getWord()
     */
    public String getMaximumLengthWord(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number ");
        String anyNumber;
        int number;

        while (true){
            try {
                anyNumber = scanner.nextLine();
                number = Integer.parseInt(anyNumber);
                if (number > 0){
                    break;
                } else {
                    System.out.println("Not correct input, try again");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Not correct input, try again");
            }
        }

        array = new String[number];
        for (int i = 0; i < array.length; i++) {
            String word = scanner.nextLine();
            array[i] = word;
        }
        return getWord();
    }

    /**
     * Метод находит в массиве самое длинное слово и возвращает его
     * @return слово максимальной длины
     */
    private String getWord(){

        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = array[i].length();
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]){
                max = numbers[i];
                index = i;
            }
        }
        return array[index];
    }
}