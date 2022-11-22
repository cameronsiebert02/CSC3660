import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FamilyTree_11_22 {
    HashMap<String, Person_11_22> tree = new HashMap<>();

    public void addPerson(String name, Person_11_22 p){
        tree.put(name, p);
    }
    public void addChildren(String parent, ArrayList<Person_11_22> children){
        if(tree.containsKey(parent)){
            Person_11_22 p = tree.get(parent);
            p.children = children;
            tree.put(parent, p);
        }
    }
//    public void addChild(String parent, Person_11_22 child){
//        if(tree.containsKey(parent)){
//            Person_11_22 p = tree.get(parent);
//            p.addChild(child);
//            tree.put(parent, p);
//        }
//    }
    public Person_11_22 getThisPerson(String person){
        if(tree.containsKey(person)){
            return tree.get(person);
        }
        return null;
    }
    public boolean addChild(String parent, Person_11_22 child){
        if(tree.containsKey(parent)){
            Person_11_22 p = tree.get(parent);
            p.addChild(child);
            tree.put(parent, p);
            return true;
        }
        return false;
    }
    public HashMap<String, Person_11_22> getAllPeople(){
        return tree;
    }
}