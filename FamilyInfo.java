// This class can be used to store basic family relationship information
// about a particular family.  

import java.util.*;

public class FamilyInfo {
    private ArrayList<Person> people;

    private final String LIST_END = "END";  // signals end of list

    // post: constructs an empty family list
    public FamilyInfo() {
        people = new ArrayList<Person>();
    }

    // post: returns the position of a name in the list of people, 
    //       -1 if not found
    private int indexOf(String name) {
        for(int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // post: returns a reference to the person with the given name if
    //       they are in the list; returns null if not found
    public Person getPerson(String name) {
        int pos = indexOf(name);
        if (pos != -1) {
            return people.get(pos);
        } else {
            return null;
        }
    }

    // pre : input contains a sequence of birth records and all people
    //       have already been read into people list
    // post: reads birth records, updating mother/father/children info
    private void ProcessParents(Scanner input) {
        String personName, motherName, fatherName;
        Person person, mother, father;
        for(;;) {
            personName = input.nextLine();
            if (personName.equals(LIST_END)) {
                break;
            }
            person = getPerson(personName);
            motherName = input.nextLine();
            fatherName = input.nextLine();
            if (!motherName.equals("unknown")) {
                mother = getPerson(motherName);
                person.setMother(mother);
                mother.addKid(person);
            }
            if (!fatherName.equals("unknown")) {
                father = getPerson(fatherName);
                person.setFather(father);
                father.addKid(person);
            }
        }
    }

    // pre : input is open for reading and contains a legal family list
    public void read(Scanner input) {
        String name = input.nextLine();
        while (!name.equals(LIST_END)) {
            people.add(new Person(name));
            name = input.nextLine();
        }
        ProcessParents(input);
    }
}
