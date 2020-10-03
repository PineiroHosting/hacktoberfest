import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseEncoder {

    private final static Map<Character, String> DICTIONARY = new HashMap<>();

    static {
        DICTIONARY.put(' ', " ");
        DICTIONARY.put('a', ".-");
        DICTIONARY.put('b', "-...");
        DICTIONARY.put('c', "-.-.");
        DICTIONARY.put('d', "-..");
        DICTIONARY.put('e', ".");
        DICTIONARY.put('f', "..-.");
        DICTIONARY.put('g', "--.");
        DICTIONARY.put('h', "....");
        DICTIONARY.put('i', "..");
        DICTIONARY.put('j', ".---");
        DICTIONARY.put('k', "-.-");
        DICTIONARY.put('l', ".-..");
        DICTIONARY.put('m', "--");
        DICTIONARY.put('n', "-.");
        DICTIONARY.put('o', "---");
        DICTIONARY.put('p', ".--.");
        DICTIONARY.put('q', "--.-");
        DICTIONARY.put('r', ".-.");
        DICTIONARY.put('s', "...");
        DICTIONARY.put('t', "-");
        DICTIONARY.put('u', "..-");
        DICTIONARY.put('v', "...-");
        DICTIONARY.put('w', ".--");
        DICTIONARY.put('x', "-..-");
        DICTIONARY.put('y', "-.--");
        DICTIONARY.put('z', "--..");

        DICTIONARY.put('0', "-----");
        DICTIONARY.put('1', ".----");
        DICTIONARY.put('2', "..---");
        DICTIONARY.put('3', "...--");
        DICTIONARY.put('4', "....-");
        DICTIONARY.put('5', ".....");
        DICTIONARY.put('6', "-....");
        DICTIONARY.put('7', "--...");
        DICTIONARY.put('8', "---..");
        DICTIONARY.put('9', "----.");

        DICTIONARY.put('.', ".-.-.-");
        DICTIONARY.put(',', "--..--");
        DICTIONARY.put('?', "..--..");
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your word to encode: ");

        final String input = scanner.nextLine().trim();
        final String output = encode(input);

        System.out.printf("%s encoded as morse: %s\n", input, output);
    }

    public static String encode(String input) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (char c : input.toLowerCase().toCharArray()) {
            if (!DICTIONARY.containsKey(c)) {
                System.out.printf("Error. Character %s not found.\n", c);
                continue;
            }

            stringBuilder.append(DICTIONARY.get(c)).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}