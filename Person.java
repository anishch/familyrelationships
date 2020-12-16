import java.util.ArrayList;

public class Person {

    // variables specific to each person
    private String name;
    public Person mother;
    public Person father;
    public ArrayList<Person> kids;
    public ArrayList<Person> parents;

    // constructor of person to set their name and
    // also initialize arraylists of kids and parents
    public Person (String str){
        this.name = str;
        kids = new ArrayList<Person>();
        parents = new ArrayList<Person>();
    }

    // get method
    public String getName(){
        return this.name;
    }

    // set methods, also add each to the arraylist of parents
    public void setMother(Person person){
        this.mother = person;
        parents.add(mother);
    }
    public void setFather(Person person){
        this.father = person;
        parents.add(father);
    }

    // add kidd to array list of kids
    public void addKid(Person person){
        kids.add(person);
    }
}
