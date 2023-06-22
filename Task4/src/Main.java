/**
 * Напишите программу в которой Вы реализуете удаление лишних символов при вводе номера телефона в консоли и
 * проверку соответствия номера формату мобильных номеров России. Если введённую строку нельзя привести к формату
 * мобильного номера — выводите сообщение о неверном вводе. Телефон может быть введён не только в формате
 * 79091234567, но и с лишними символами.
 * ---------------------------------------------------------------------------------------------------------------------
 * Усложнение:
 * Выводите новый номер в формате: +7 (999) 888 77-66
 * Используя регулярные выражения, создайте из символов номера несколько групп
 */
import java.util.Scanner;
public class Main {
    private static final String CLEAN_REGEX = "[^0-9]+";
    private static final String OFFICIAL_FORMAT_REGEX = "(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})";
    private static final String CODE_COUNTRY = "7";
    private static final int VALID_LENGTH_NUMBER = 11;
    private static final String INVALID_FORMAT = "Неверный формат номера";

    public static void main(String[] args) {
        showTask();
    }

//      Просто захотел отдельный метод для вывода
    private static void showTask() {
//        Обычное задание
        System.out.println("Введите номер:");
        String number = new Scanner(System.in).nextLine();
        number = cleanNumber(number);
        System.out.println("Только номер:\n"+ number);
//        Усложненное задние
        String cleanNumber = number;
        System.out.println("\nКонвертируем обратно:");
        cleanNumber = officialFormatNumber(cleanNumber);
        System.out.println(cleanNumber);

    }
//      метод обычного задания
    private static String cleanNumber(String number) {
        number = number.replaceAll(CLEAN_REGEX,"");
        if(number.length() == VALID_LENGTH_NUMBER - 1) number = CODE_COUNTRY + number;
        else if((number.charAt(0) != '7') && (number.charAt(0) != '8') || (number.length() != VALID_LENGTH_NUMBER))
            return INVALID_FORMAT;
        number = number.replaceFirst("8", CODE_COUNTRY);
        return number;
    }
//      метож усложненного задания
    private static String officialFormatNumber(String number) {
        if(number.length() == VALID_LENGTH_NUMBER - 1)
            number = CODE_COUNTRY + number;
        else if(number.length() != VALID_LENGTH_NUMBER)
            return INVALID_FORMAT;
        number = number.replaceAll(OFFICIAL_FORMAT_REGEX,"+$1 ($2) $3 $4-$5");
        return number;
    }
}
