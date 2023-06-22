/**
 * Напишите программу (аналог задания из прошлого ДЗ), которая на входе через консоль принимает фамилию,имя и отчество
 * одной строкой (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
 * Фамилия: Иванов
 * Имя: Сергей
 * Отчество: Петрович
 * Валидная строка от пользователя, которую мы можем интерпретировать как Ф. И. О., должна содержать три слова,
 * состоящих из символов кириллицы, разделённых пробелом, может содержать дефис. Если строка не соответствует формату,
 * то вывести в консоль:
 *  Введенная строка не является ФИО
 * Используйте для определения валидности строки регулярное выражение.
 */

import java.util.Scanner;

public class Main {
    private static final String VALID_REGEX = "([А-я-]+\\s){2}([А-я-]+)";
    private static final String[] fioArrays = {"Фамилия: ", "Имя: ", "Отчество: "};

    public static void main(String[] args) {
        showTask();
    }

//        Просто захотел отдельный метод для вывода
    private static void showTask() {
        System.out.println("Введите ФИО:");
        String fio = new Scanner(System.in).nextLine();
        fioInformation(fio);
    }
//        Метод задания
    private static void fioInformation(String fio) {
        if(!fio.matches(VALID_REGEX))
            System.out.println("Введенная строка не является ФИО");
        else {
            String[] words = fio.split(" ");
            for (int i = 0; i < fioArrays.length; i++)
                System.out.println(fioArrays[i] + words[i]);
        }
    }
}