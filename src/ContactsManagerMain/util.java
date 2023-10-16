package ContactsManagerMain;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Files;
import java.util.Arrays;

public class util {

    public static void main(String[] args) throws IOException {
//        displayContacts();
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
