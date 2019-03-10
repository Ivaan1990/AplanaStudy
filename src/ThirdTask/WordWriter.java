package ThirdTask;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ivan Yushin
 * Для тестирования работы программы, укажите путь к вашему файлу в параметра объекта writer
 * @see #writeWordsIntoFile(FileWriter)
 * @see FileWriter
 * @see #listOfAllWorld намеренно установил общую вместимость списка для повышения производительности
 */
public class WordWriter {

    private static String[] words ={"Ы", "Ёж", "Суп", "Кадр", "Привет", "Выход", "Квадрат", "Персонал", "Аукционер", "Арифметика"};
    private static List<String> listOfAllWorld = new ArrayList<>(10000);

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Asus\\Desktop\\testExample.txt");

        /** записываем данные в файл*/
        writeWordsIntoFile(writer);

    }

    /**
     *  @param writer объект файла который пишет строку в файл
     *  @throws IOException
     *  Паралельно ведётся запись слов в список listOfAllWorld
     *  @see #listOfAllWorld
     */
    private static void writeWordsIntoFile(FileWriter writer) throws IOException {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            int randumIndex = random.nextInt(words.length);
            builder.append(words[randumIndex]).append(" ");
            listOfAllWorld.add(words[randumIndex]);
        }

        writer.write(builder.toString().trim());
        writer.close();
    }
}
