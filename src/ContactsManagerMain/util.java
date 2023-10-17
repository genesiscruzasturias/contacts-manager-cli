package ContactsManagerMain;


import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;


public class util {


    // Main Menu Method
    public static int menu() throws IOException {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an option below (1, 2, 3, 4 or 5):");
        System.out.println("1 - View contacts.");
        System.out.println("2 - Add a new contact.");
        System.out.println("3 - Search a contact by name.");
        System.out.println("4 - Delete an existing contact.");
        System.out.println("5 - Exit.");

        selection = input.nextInt();

            if(selection == 1){
                System.out.println("Displaying all contacts: ");
                System.out.println(" ");
                displayContacts();
                menu();
            } else if (selection ==2){
                addContact();
                menu();
            } else if (selection == 3){
                searchContactByName();
                menu();
            } else if (selection == 4){
                deleteContactByName();
                menu();
            } else {
                System.out.println("Goodbye!");
                return selection;
            }
            return selection;


    }


    // Method to show contacts
    public static void displayContacts () throws IOException {
        Path contactsPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactsPath);
        for (String oneLine : contactList) {
            String[] data = new String[]{oneLine};

            for (String s : data) {
//                System.out.println(s);
                data = oneLine.split(" : ");
                System.out.println(s.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));

            }
        }
    }

    public static void addContact () throws IOException {
        System.out.println("Enter Your contacts name.");
        String newName = scanner.nextLine();

        System.out.println("Enter your contact's Number.");
        int newNumber = scanner.nextInt();

        Files.write(
                Paths.get("src/data", "/contacts.txt"),List.of(newName + " | " + newNumber),StandardOpenOption.APPEND
        );

        System.out.println("Your contact has been added!");
    }

    // Method to Delete a contact
    static void deleteContactByName() throws IOException {

        Path contactPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactPath);
        String regexPattern = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        System.out.println("Which contact would you like to delete?");
        String userDeleteInput = scanner.nextLine();

        boolean contactDeleted = false;
        for (String contact : contactList) {
            if (contact.contains(userDeleteInput) || contact.matches(regexPattern)) {
                System.out.println("Are you sure you want to delete this contact?");
                String userConfirmDelete = scanner.nextLine();
                if (userConfirmDelete.contains("Y") || userConfirmDelete.contains("y")) {
                    contactList.remove(contact);
                    contactDeleted = true;
                    break;
                } else {
                    System.out.println("Goodbye!");
                }
            }
        }
        if (contactDeleted) {
            Files.write(contactPath, contactList);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Multi-use scanner
    public static final Scanner scanner = new Scanner(System.in);

    // Method to search for contact
    public static void searchContactByName() throws IOException {
        System.out.println("Please enter a name: ");
        String userInputName = scanner.nextLine();
        List<String> lineCheck = Files.readAllLines(Paths.get("src/data", "/contacts.txt"));
        for (String Line: lineCheck){
            if (Line.contains(userInputName)) {
                System.out.println(Line);
            }
        }

    }

}


