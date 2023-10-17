package ContactsManagerMain;

import java.util.Scanner;

public class SearchContacts {
    public static final Scanner scanner = new Scanner(System.in);

    public static void searchContactByPhoneNumber() {
        System.out.println("Please enter phone number: ");
        String userInputPhoneNumber = scanner.nextLine();
        if (userInputPhoneNumber.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")) {
            System.out.println("You entered: " + userInputPhoneNumber);
        } else {
            System.out.println("Please enter a valid phone number.");
        }
    }

    public static void searchContactByName() {
        //^ Start of string
        //[A-Z] Match an uppercase char A-Z
        //(?=.{1,29}$) Assert 1-29 chars to the right till the end of the string
        //[A-Za-z]* Optionally match a char A-Za-z
        //(?:\h+[A-Z][A-Za-z]*)* Optionally repeat 1+ horizontal whitespace chars followed by again an uppercase char A-Z and optional chars A-Za-z
        //$ End of string
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        System.out.println("Please enter a name: ");
        String userInputName = scanner.nextLine();
        if (userInputName.matches(regex)) {
            System.out.println("You entered: " + userInputName);

        } else {
            System.out.println("Please enter a valid name.");
        }
    }
}
