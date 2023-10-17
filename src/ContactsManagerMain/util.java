package ContactsManagerMain;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.Arrays;

import static ContactsManagerMain.DeleteContacts.deleteContactByName;
import static ContactsManagerMain.DeleteContacts.deleteContactByName;
import static ContactsManagerMain.SearchContacts.searchContactByName;
import static ContactsManagerMain.SearchContacts.searchContactByPhoneNumber;

public class util {

    public static void main(String[] args) throws IOException {
        menu();
//        displayContacts();
//        searchContactByPhoneNumber();
//        deleteContactByName();

    }

    private static int menu() throws IOException {

        Path contactPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactPath);
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an option below (1, 2, 3, 4 or 5):");
//        System.out.println("-------------------------\n");
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
        } else if (selection ==2){
            addContact();
        } else if (selection == 3){
            searchContactByName();
            System.out.println(contactList);
        } else if (selection == 4){
            deleteContactByName();
        } else {
            System.out.println("Goodbye!");
            return selection;
        }
        return selection;

    }


    public static void displayContacts () throws IOException {

        Path contactPath = Paths.get("src/data", "/contacts.txt");
        List<String> contactList = Files.readAllLines(contactPath);

        for (String oneLine : contactList) {
            //When using bar character \\ is needed to escape its normal function
            String[] data = new String[]{oneLine};
            for (String s : data) {
                System.out.println(s);
            }
        }
    }

    public static void addContact () {
        System.out.println("");
    }

}


