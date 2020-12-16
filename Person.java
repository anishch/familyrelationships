import java.util.ArrayList;

public class Person {

    private String name;
    public Person mother;
    public Person father;
    public ArrayList<Person> kids;
    public ArrayList<Person> parents;


    public Person (String str){
        this.name = str;
        kids = new ArrayList<Person>();
        parents = new ArrayList<Person>();
    }

    public String getName(){
        return this.name;
    }

    public void setMother(Person person){
        this.mother = person;
        parents.add(mother);
    }

    public void setFather(Person person){
        this.father = person;
        parents.add(father);
    }

    public void addKid(Person person){
        kids.add(person);
    }
}
