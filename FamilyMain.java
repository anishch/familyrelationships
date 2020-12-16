
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyMain {

    static int temp = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("This program will show you all of the ancestors and descendants of a person.");
        System.out.print("What is the input file?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        File file = new File(input);
        System.out.print("\n Person's name ('quit' to end)?");
        String str = scanner.nextLine();
        String person = "";
        if (str.equals("quit")) {
            Thread.currentThread().interrupt();
        } else {
            person = str;
        }
        Scanner fileReader = new Scanner(file);
        FamilyInfo familyinfo = new FamilyInfo();
        familyinfo.read(fileReader);

        Person persona;
        for (Person persons : familyinfo.people) {
            if (persons.getName().equalsIgnoreCase(person)) {
                persona = persons;
                System.out.println("Ancestors: ");
                System.out.println(persons.getName());
                for (Person thingies : returnlist(persona.parents, "ancestors")){
                    //System.out.println(thingies.getName());
                }
                System.out.println("Descendants: ");
                System.out.println(persons.getName());
                for (Person thingies : returnlist(persona.kids, "descendants")){
                    //System.out.println(thingies.getName());
                }
                //System.out.println(returnlist(persona.kids));
            }
        }
    }

    public static ArrayList<Person> returnlist (ArrayList<Person> list, String type){
        temp++;
        for (Person persons : list){ //Henry VII,
            for (int k = 0; k < temp; k++){
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
        temp--;
        return list;
    }

    public static ArrayList<String> makeReadableList (ArrayList<Person> list){
        ArrayList<String> strlist = new ArrayList<String>();
        for (Person personies : list){
            strlist.add(personies.getName());
        }
        return strlist;
    }
}




