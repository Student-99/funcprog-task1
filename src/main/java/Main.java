import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static String phraseOfAborigines = """
            Представьте, что вы попали на некоторый остров (вполне обитаемый), а местные жители пытаются с вами коммуницировать, записывая непонятные слова на бумажке. Вы хотите разобраться, что именно вам пишут и решаете начать с составления словаря.
            Задача заключается в том, чтобы написать генератор словаря аборигенов в функциональном стиле. Представьте, что у вас есть исходный текст сообщения местного жителя. Программа должна разбить текст на слова и отсортировать их в естесственном порядке. В комментариях укажите, какие отличительные черты функционального стиля присутствуют в вашей программе.
            Функция, которая составляет словарь, должна быть оформлена как реализатор Function
            """;


    static Function<String, List<String>> dictionaryGenerator = x -> {
        String[] phrase = String.valueOf(x) //переданное значение привожу к String
                .replaceAll("[^а-яА-Яa-zA-z\\s]", "") //из значения удаляю все небуквенные и не пробельные значения
                .toLowerCase() //привожу в нижний регистр
                .split("\\s"); // разбиваю фразу на слова по пробелу
        return Arrays.stream(phrase)
                .sorted() // сортирую список
                .distinct() // удалю повторяющиеся значения
                .collect(Collectors.toList()); // привожу результат к List<String>
    };

    public static void main(String[] args) {
        System.out.println(String.format("Текст разбитый на слова и отсортированный в естественном порядке %s",
                dictionaryGenerator.apply(phraseOfAborigines)));
    }
}
