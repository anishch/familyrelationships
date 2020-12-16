
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
        System.out.println("Ancestors: ");

        System.out.println("Descendants: ");
        Person persona;
        for (Person persons : familyinfo.people) {
            if (persons.getName().equalsIgnoreCase(person)) {
                persona = persons;
                for (Person thingies : returnlist(persona.kids)){
                    //System.out.println(thingies.getName());
                }
                //System.out.println(returnlist(persona.kids));
            }
        }
    }

    public static ArrayList<Person> returnlist (ArrayList<Person> list){
        temp++;
        /*if (list.size() != 0){
            temp++;
        }
        else{
            //temp--;
        }*/
        //System.out.println(makeReadableList(list));
        /*for (int k = 0; k < temp; k++){
            System.out.print("    ");
        }*/
        for (Person persons : list){ //Henry VII,
            for (int k = 0; k < temp; k++){
                System.out.print("    ");
            }
            System.out.println(persons.getName());
            returnlist(persons.kids); //

        }
        //System.out.println(makeReadableList(list));
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




