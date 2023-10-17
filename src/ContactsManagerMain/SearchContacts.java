package ContactsManagerMain;

import java.util.Scanner;

public class SearchContacts {
    public static final Scanner scanner = new Scanner(System.in);

    public static void searchContactByPhoneNumber() {
        System.out.println("Please enter phone number: ");
        String userInputPhoneNumber = scanner.nextLine();
        if (userInputPhoneNumber.matches("^(?=(?:[8-9]){1})(?=[0-9]{8}).*")) {
            System.out.println("You entered: " + userInputPhoneNumber);
        } else {
            System.out.println("Please enter a valid phone number.");
        }
    }

    public static void searchContactByName() {
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
