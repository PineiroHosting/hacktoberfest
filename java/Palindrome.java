import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your word to check: ");

        final String input = scanner.nextLine().trim();
        final boolean palindrome = isPalindrome(input);

        final String message = String.format("The word %s is%s a palindrome.",
                input,
                (palindrome ? "" : " not"));
        System.out.println(message);
    }

    private static boolean isPalindrome(String input) {
        final int length = input.length();

        boolean palindrome = true;

        for (int i = 0; i <= length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }

}
