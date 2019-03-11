package ThirdTask;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * @author Ivan Yushin
 * Для тестирования работы программы, укажите путь к вашему файлу в переменной FILE_PATH
 * @see FILE_PATH
 * @see #writeWordsIntoFile(FileWriter)
 * @see FileWriter
 */

public class WordWriter {

    static final String FILE_PATH = "C:\\Users\\Asus\\Desktop\\testExample.txt";

    private static String[] words ={"Ы", "Яд", "Суп", "Кадр", "Привет", "Выход", "Квадрат", "Персонал", "Аукционер", "Арифметика"};
    private static List<String> listOfAllWords = new ArrayList<>();
    private static Map<String, Integer> map = new TreeMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        /** записываем данные в файл */
        writeWordsIntoFile();
        /** Сортируем  по алфавиту и перезаписываем в файл */
        sortAndWriteInFile();

        /** @see map Подсчет повторений, сбор информации в словарь */
        for(String word : words){
            int countOfWords = Collections.frequency(listOfAllWords, word);
            map.put(word, countOfWords);
        }

        /** Вывод в консоль статистики повторений слов */
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println("Cлово: " + pair.getKey() + ", повторений " + pair.getValue());
        }

        /** Поиск слова с максимальным количеством повторений */
        findMax();

        /** @see #getAverageSizeOfAllWords() */
        double avg = getAverageSizeOfAllWords();
        System.out.printf("Средняя длина все слов %.2f", avg);

        /** Сортировка слов по длине и перезапись в новый файл */
        mySortLength();
    }

    /**
     *
     * @return среднею длину всех слов в файле
     */
    private static double getAverageSizeOfAllWords(){
        double sum = 0;
        for(String word : listOfAllWords){
            sum += word.length();
        }
        return sum / listOfAllWords.size();
    }

    /**
     * @see #findMax()
     */
    private static void findMax() {
        int max = Collections.max(map.values());
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            if (pair.getValue() == max){
                System.out.println("\nМаксимум повторов у " + pair.getKey() + "\nВстречается в файле " + pair.getValue());
            }
        }
    }

    /**
     *  @throws IOException
     *  Паралельно ведётся запись слов в список listOfAllWorld
     *  @see #listOfAllWorld
     */
    private static void writeWordsIntoFile() throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(words.length);
            builder.append(words[randomIndex]).append(" ");
            listOfAllWords.add(words[randomIndex]);
        }

        writer.write(builder.toString().trim());
        writer.close();
    }

    /**
     * Сортировка содержимого файла по алвафиту и перезапись его в тот же файл
     * @throws IOException
     */
    public static void sortAndWriteInFile() throws IOException {
        ArrayList<String> temp = new ArrayList<String>(listOfAllWords);
        FileWriter writer = new FileWriter(FILE_PATH);
        StringBuilder builder = new StringBuilder();
        Collections.sort(temp);
        for(String word : temp){
            builder.append(word).append(" ");
        }
        writer.write(builder.toString().trim());
        writer.close();
    }

    /**
     * Сортировка по длине слов своим компаратором, и перезапись в новый файл
     */
    public static void mySortLength() throws IOException {
        FileWriter writer = new FileWriter(new File("C:\\Users\\Asus\\Desktop\\testExample2.txt"));
        StringBuilder builder = new StringBuilder();
        Collections.sort(listOfAllWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for(String s : listOfAllWords){
            builder.append(s).append(" ");
        }
        writer.write(builder.toString().trim());
        writer.close();
    }

}