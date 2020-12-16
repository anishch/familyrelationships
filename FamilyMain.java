import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyMain {

    // we start one indent in when printing first name
    static int numberOfIndents = 1;

    public static void main(String[] args) throws IOException {
        // intro message
        System.out.println("This program will show you all of the ancestors and descendants of a person.");

        // ask for file
        System.out.print("What is the input file?");

        // initialize scanner and set file equal to the input from scanner
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        File file = new File(input);

        // Ask for person's name. If the user asks to quit, then quit
        // else, set the person's name we are looking for to the input
        System.out.print("\n Person's name ('quit' to end)?");
        String str = scanner.nextLine();
        String person = "";
        if (str.equals("quit")) {
            Thread.currentThread().interrupt();
        } else {
            person = str;
        }

        // initialize new scanner and FamilyInfo object
        Scanner fileReader = new Scanner(file);
        FamilyInfo familyinfo = new FamilyInfo();

        // read the file and use the read method from familyinfo
        familyinfo.read(fileReader);

        for (Person persons : familyinfo.people) {
            // if person in our arraylist equals name of inputted person,
            // then print out their ancestors and descendants
            if (persons.getName().equalsIgnoreCase(person)) {
                System.out.println("Ancestors: \n   " + persons.getName());
                printPersons(persons.parents, "ancestors");
                System.out.println("Descendants: \n   " + persons.getName());
                printPersons(persons.kids, "descendants");
                // print out ancestors and descendants using printPersons method
            }
        }
    }

    public static void printPersons(ArrayList<Person> list, String type) {
        // as we will print out another set of kids/parents, we need to indent
        numberOfIndents++;

        /*
        list is the inputted list of the person's kids/parents
        so we print out the number of indents that are necessary
        then we print the parent/kids name (depending on which we
        need to given type input). Then we print out the parents/kids
        of the parent/kid to have a full proper list printed out
         */
        for (Person persons : list) {
            for (int k = 0; k < numberOfIndents; k++) {
                System.out.print("    ");
            }
            System.out.println(persons.getName());
            if (type.equals("descendants")) {
                printPersons(persons.kids, "descendants"); //
            }
            if (type.equals("ancestors")) {
                printPersons(persons.parents, "ancestors"); //
            }
        }

        // go back to the previous number of indents
        numberOfIndents--;
    }
}



