import java.util.Scanner;

public class PasswordStrength {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Password");
        String i = s.nextLine().trim();

        System.out.println("Password Score is " + passwordScore(i));
        System.out.println("Password Strength is " + passwordStrength(i).getName());

    }

    public static PasswordStrengthLevel passwordStrength(String password) {
        int passScore = passwordScore(password);
        if (passScore < 3) return PasswordStrengthLevel.LOW;
        else if (passScore < 5) return PasswordStrengthLevel.MED;
        else return PasswordStrengthLevel.HI;
    }

    public static int passwordScore(String password) {
        int iPasswordScore = 0;

        if (password.length() < 8)
            iPasswordScore = 0;
        else if (password.length() >= 10)
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        if (password.matches("(?=.*[0-9].*[0-9]).*"))
            iPasswordScore += 2;
        else if (password.matches("(?=.*[0-9]).*"))
            iPasswordScore += 1;

        if (password.matches("(?=.*[a-z]).*"))
            iPasswordScore += 2;

        if (password.matches("(?=.*[A-Z].*[A-Z]).*"))
            iPasswordScore += 2;
        else if (password.matches("(?=.*[A-Z]).*"))
            iPasswordScore += 1;

        if (password.matches("(?=.*[~!@#$%^&*()_-].*[~!@#$%^&*()_-]).*"))
            iPasswordScore += 2;
        else if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
            iPasswordScore += 1;

        return iPasswordScore;

    }

}

enum PasswordStrengthLevel {

    LOW("Low"),
    MED("Medium"),
    HI("High");

    private String name;

    PasswordStrengthLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


