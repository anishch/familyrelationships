import java.util.ArrayList;

public class Person {

    private String name;
    private Person mother;
    private Person father;
    public ArrayList<Person> kids;


    public Person (String str){
        this.name = str;
        kids = new ArrayList<Person>();
    }

    public String getName(){
        return this.name;
    }

    public void setMother(Person person){
        this.mother = person;
    }

    public void setFather(Person person){
        this.father = person;
    }

    public void addKid(Person person){
        kids.add(person);
    }
}
