
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyMain {


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

        Person persona;
        for (Person persons : familyinfo.people) {
            // if person in our arraylist equals name of inputted person,
            // then print out their ancestors and descendants
            if (persons.getName().equalsIgnoreCase(person)) {
                persona = persons;
                System.out.println("Ancestors: \n   " + persons.getName());
                returnlist(persona.parents, "ancestors");
                System.out.println("Descendants: \n   " + persons.getName());
                returnlist(persona.kids, "descendants");
            }
        }
    }

    public static void returnlist (ArrayList<Person> list, String type){
        numberOfIndents++;
        for (Person persons : list){ //Henry VII,
            for (int k = 0; k < numberOfIndents; k++){
                System.out.print("    ");
            }
            System.out.println(persons.getName());
            if (type.equals("descendants")){
                returnlist(persons.kids, "descendants"); //
            }
            if (type.equals("ancestors")){
                returnlist(persons.parents, "ancestors"); //
            }
        }
        numberOfIndents--;
    }

    public static ArrayList<String> makeReadableList (ArrayList<Person> list){
        ArrayList<String> strlist = new ArrayList<String>();
        for (Person personies : list){
            strlist.add(personies.getName());
        }
        return strlist;
    }
}




