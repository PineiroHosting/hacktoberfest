import java.util.Scanner;

public class PasswordStrength {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Password");
        String i = s.nextLine().trim();

        System.out.println("Password Score is " + passwordStrength(i));

    }

    public static int passwordStrength(String password) {
        int iPasswordScore = 0;

        if( password.length() < 8 )
            iPasswordScore = 0;
        else if( password.length() >= 10 )
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        if( password.matches("(?=.*[0-9].*[0-9]).*") )
            iPasswordScore += 2;
        else if ( password.matches("(?=.*[0-9]).*") )
            iPasswordScore += 1;

        if( password.matches("(?=.*[a-z]).*") )
            iPasswordScore += 2;

        if( password.matches("(?=.*[A-Z].*[A-Z]).*") )
            iPasswordScore += 2;
        else if( password.matches("(?=.*[A-Z]).*") )
            iPasswordScore += 1;

        if( password.matches("(?=.*[~!@#$%^&*()_-].*[~!@#$%^&*()_-]).*") )
            iPasswordScore += 2;
        else if( password.matches("(?=.*[~!@#$%^&*()_-]).*") )
            iPasswordScore += 1;

        return iPasswordScore;

    }

}

