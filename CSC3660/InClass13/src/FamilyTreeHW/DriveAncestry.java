package FamilyTreeHW;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class DriveAncestry {
    public static void main(String[] args) {
       FamilyTree ft = configureTree();
        TreeMap<String, Person> treeEntries = ft.getAllPeople();

        //HashMap<String, Person> treeEntries = configureTree();
          showAllPeople(treeEntries);
          ft = AddNewPerson( ft );   // ToDO Add Maggie born 2021 with bart and lisa siblings
                                     // and homer and marge (Mom and dad)
        System.out.printf("\n ------------------- All people with Maggie");
        TreeMap<String, Person> treeEntries2 = ft.getAllPeople();
        showAllPeople(treeEntries2);
        String name = "Jackie";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);
        name = "Abbey";
        System.out.printf("\n ---Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);
        name = "Lisa";
        System.out.printf("\n ---- Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);

        name = "Mona";
        System.out.printf("\n ---- Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);

        name="Homer";
        System.out.printf("\n ---- Showing Siblings of %s", name);
        ShowMySiblings(name, ft);
        name="Maggie";
        System.out.printf("\n ---- Showing Siblings of %s", name);
        ShowMySiblings(name, ft);

        name="Clancy";
        System.out.printf("\n ---- Showing Siblings of %s", name);
        ShowMySiblings(name, ft);

//        showThisPersonsTree(treeEntries, "Marge");


    }

    private static void ShowMySiblings(String person, FamilyTree ft) {
         // ToDo:
        // Output all of the siblings of this person. That is someone who shares a mother or father
        // For example if Person is Marge you would show Marge, Patty and Selma
        int ct = 0;
        boolean firstParent = true;
        for(String name : ft.tree.keySet()){
            if (name.equalsIgnoreCase(person)){
                for(Person p : ft.tree.get(name).getParent()){
                    while(firstParent){
                        for(Person c : ft.tree.get(p.name).getChildren()){
                            ct++;
                            System.out.printf("\nSibling #%s: %s", ct, c.toString());
                            firstParent = false;
                        }
                    }
                }
            }
        }
    }

    private static void ShowDirectDescendants(String ancestor, FamilyTree ft) {
        // ToDo: Write this method that shows the direct descendant
        // For example, if anester="Jackie" it would show:
        //    Jackie married to Clancy
        //     Patty
        //     Selma
        //     Marge
        //       Bart
        //       Lisa
        int ct = 0;
        for (String name : ft.tree.keySet()) {
            if (name.equalsIgnoreCase(ancestor)) {
                if (ft.tree.get(name).getSpouse() != null) {
                    System.out.printf("\nSpouse: %s", ft.tree.get(name).spouse.toString());
                }
                for (Person c : ft.tree.get(name).children) {
                    ct++;
                    System.out.printf("\nDecendant #%s: %s", ct, c.toString());
                        if (c.children != null) {
                            for (Person e : c.children) {
                                ct++;
                                System.out.printf("\nDecendant #%s: %s", ct, e.toString());
                            }
                        }
                }
            }
        }
    }

    private static FamilyTree AddNewPerson(FamilyTree ft) {
        // ToDo: Prompt the user for new person:
        //    Name and year birth
        //    Mom and Dad
        //    Spouse
        //   Add this person to the tree
        Scanner scan = new Scanner(System.in);
        String uName = "";
        int uYear = 0;
        String uMom = "";
        String uDad = "";
        String uSpouse = "";
        System.out.printf("\n Please enter the information needed to add a person to the family tree:");
        System.out.printf("\n(If they don't have the relation, just leave the space blank)");
        System.out.printf("\nPerson name: ");
        uName = scan.nextLine();
        System.out.printf("\nBirth year: ");
        uYear = scan.nextInt();
        uMom = scan.nextLine();
        System.out.printf("\nTheir mom: ");
        uMom = scan.nextLine();
        System.out.printf("\nTheir dad: ");
        uDad = scan.nextLine();
        System.out.printf("\nTheir spouse: ");
        uSpouse = scan.nextLine();

        Person uPerson = new Person(uName, uYear);
        ft.addPerson(uName, uPerson);
        if (!uMom.equals("")){
            for(String name : ft.tree.keySet()){
                if(uMom.equalsIgnoreCase(name)){
                    ft.addParent(uName, ft.getThisPerson(name));
                    ft.addChild(name, uPerson);
                }
            }
        }
        if (!uDad.equals("")){
            for(String name : ft.tree.keySet()){
                if(uDad.equalsIgnoreCase(name)){
                    ft.addParent(uName, ft.getThisPerson(name));
                    ft.addChild(name, uPerson);
                }
            }
        }
        if(!uSpouse.equals("")){
            for(String name : ft.tree.keySet()){
                if(uSpouse.equalsIgnoreCase(name)){
                    uPerson.spouse = ft.getThisPerson(name);
                    ft.getThisPerson(name).spouse = uPerson;
                }
            }
        }
       return ft;
    }



    private static void showAllPeople(TreeMap<String, Person> treeEntries) {
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }

    private static void showThisPersonsTree(HashMap<String, Person> treeEntries, String searchPerson) {
        System.out.printf("\n =--------------");
        if (treeEntries.containsKey(searchPerson)) {
            Person targetPerson = treeEntries.get(searchPerson);
            boolean gotMoreToDo = true;
            while (gotMoreToDo) {
                gotMoreToDo = false;

            }
        } else {
            System.out.printf("\n The Person:%s does not exist", searchPerson);
        }
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }


    private static FamilyTree configureTree() {
        // ToDo: Configure tree for Homers side of the family
        FamilyTree ft = new FamilyTree();
//        ft.addPerson( );
        Person nullPerson = null;
        Person nullSpouse = null;

        ArrayList<Person> nullChildrenList = new ArrayList<>();
        ArrayList<Person> nullParentList = new ArrayList<>();

        // bart and lisa and maggie
        Person bart = new Person( "Bart", 2020 );
        ft.addPerson( "Bart", bart);
        Person lisa = new Person( "Lisa", 2021 );
        ft.addPerson("Lisa", lisa);
        Person maggie = new Person( "Maggie", 2022);
        ft.addPerson("Maggie", maggie);

        Person marge = new Person( "Marge", 1990);
        Person homer = new Person( "Homer", 1991);
        homer.spouse = marge;
        ft.addPerson("Homer", homer);
        marge.spouse = homer;
        ft.addPerson( "Marge", marge);

        ft.addParent("Bart", homer);
        ft.addParent( "Lisa", homer);
        ft.addParent("Maggie", homer);
        ft.addParent("Bart", marge );
        ft.addParent( "Lisa", marge);
        ft.addParent("Maggie", maggie);
        ft.addChild("Marge",lisa);
        ft.addChild("Marge",bart);
        ft.addChild("Homer", lisa);
        ft.addChild("Homer", bart);

        // Lets add Marges Sisters
         Person Selma = new Person( "Selma", 1991 );
        ft.addPerson("Selma", Selma);
        Person patty = new Person( "Patty", 1992 );

        ft.addPerson("Patty", patty);

        Person clancy = new Person( "Clancy", 1960 );
        Person jackie = new Person( "Jackie", 1961 );
        clancy.spouse = jackie;
        jackie.spouse = clancy;
        ft.addPerson("Clancy", clancy);
        ft.addPerson( "Jackie", jackie);
        ft.addChild("Clancy", Selma);
        ft.addChild("Clancy", marge);
        ft.addChild("Clancy", patty);

        ft.addChild("Jackie", Selma);
        ft.addChild("Jackie", marge);
        ft.addChild("Jackie", patty);

        ft.addParent("Marge", clancy);
        ft.addParent("Marge", jackie);
        ft.addParent("Patty", clancy);
        ft.addParent("Patty", jackie);
        ft.addParent("Selma", clancy);
        ft.addParent("Selma", jackie);

        // Add Homers parents
        Person mona = new Person("Mona", 1962);
        Person abe = new Person("Abe", 1963);
        ft.addPerson("Mona", mona);
        ft.addPerson("Abe", abe);
        ft.addChild("Mona", homer);
        ft.addChild("Abe", homer);
        ft.addParent("Homer", abe);
        ft.addParent("Homer", mona);

        // Add Abe's other children
        Person herb = new Person("Herbert", 1992);
        Person abbey = new Person("Abbey", 1993);
        ft.addChild("Abe", herb);
        ft.addChild("Abe", abbey);
        ft.addParent("Herbert", abe);
        ft.addParent("Abbey", abe);
        return ft;
    }


}