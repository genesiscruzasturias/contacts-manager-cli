package ContactsManagerMain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DeleteContacts {
    private static final Scanner scanner = new Scanner(System.in);

    static void deleteContactByName() throws IOException {

        Path contactPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactPath);
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        System.out.println("Which contact would you like to delete?");
        String userDeleteInput = scanner.nextLine();

        boolean contactDeleted = false;
        for (String contact : contactList) {
            if (contact.contains(userDeleteInput)) {
                contactList.remove(contact);
                contactDeleted = true;
                break;
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

