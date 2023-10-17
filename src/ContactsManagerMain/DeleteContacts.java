package ContactsManagerMain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static ContactsManagerMain.util.menu;

public class DeleteContacts {
    private static final Scanner scanner = new Scanner(System.in);

    static void deleteContactByName() throws IOException {

        Path contactPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactPath);
            //^ Start of string
            //[A-Z] Match an uppercase char A-Z
            //(?=.{1,29}$) Assert 1-29 chars to the right till the end of the string
            //[A-Za-z]* Optionally match a char A-Za-z
            //(?:\h+[A-Z][A-Za-z]*)* Optionally repeat 1+ horizontal whitespace chars followed by again an uppercase char A-Z and optional chars A-Za-z
            //$ End of string
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
    }

