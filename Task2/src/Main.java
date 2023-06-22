/**
 * Реализовать статический метод, который принимает в качестве аргумента строку, содержащую английский текст.
 * Текст можно внести в сам код, или вводить в ручную. Метод должен разделить текст на слова и вернуть строку,
 * состоящую из полученных слов, каждое слово на отдельной строке.
 * Знаки препинания и числа не являются словами.
 */
import java.util.Scanner;
public class Main {
    private static final String ONLY_ENGLISH_REGEX = "[^A-z ]";
    private static final String NO_DOUBLE_SPACES_REGEX = " {2,}";

    public static void main(String[] args) {
        showTask();
    }

//    Просто захотел отдельный метод для вывода
    private static void showTask() {
        System.out.println("Введите текст:");
        String text = new Scanner(System.in).nextLine();
        text = words(text);
        System.out.print(text);
    }
//    метод возвращает только английские слова без знаков и цифр, каждое слово с новой строки.
    private static String words(String text) {
        text = text.replaceAll(ONLY_ENGLISH_REGEX,"");
        text = text.replaceAll(NO_DOUBLE_SPACES_REGEX," ").trim();
        return text.replaceAll(" ","\n");
    }

}