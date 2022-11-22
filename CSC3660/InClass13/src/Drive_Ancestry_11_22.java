public class Drive_Ancestry_11_22 {
    public static void main(String[] args) {
        FamilyTree_11_22 ft = configureTree();
        showAllPeople(ft);
    }

    private static void showAllPeople(FamilyTree_11_22 ft) {
        for(String name : ft.tree.keySet()){
            Person_11_22 p = ft.tree.get(name);
            System.out.printf("\nPerson: %s ", p.toString());
        }
    }

    private static FamilyTree_11_22 configureTree() {
        FamilyTree_11_22 ft = new FamilyTree_11_22();
        Person_11_22 bart = new Person_11_22("Bart", 2020);
        ft.addPerson(bart.name, bart);
        Person_11_22 lisa = new Person_11_22("Lisa", 2021);
        ft.addPerson(lisa.name, lisa);
        Person_11_22 marge = new Person_11_22("Marge", 1990);
        ft.addPerson(marge.name, marge);
        ft.addChild("Marge", lisa);
        ft.addChild("Marge", bart);
        Person_11_22 jackie = new Person_11_22("Jackie", 1960);
        ft.addPerson(jackie.name, jackie);
        ft.addChild("Jackie", marge);
        Person_11_22 clancy = new Person_11_22("Clancy", 1961);
        ft.addPerson(clancy.name, clancy);
        ft.addChild("Clancy", marge);
        clancy.setSpouse(jackie);
        jackie.setSpouse(clancy);
        marge.addParent(jackie);
        marge.addParent(clancy);
        Person_11_22 selma = new Person_11_22("Selma", 1991);
        ft.addPerson(selma.name, selma);
        Person_11_22 patty = new Person_11_22("Patty", 1992);
        ft.addPerson(patty.name, patty);
        selma.addParent(clancy);
        selma.addParent(jackie);
        patty.addParent(clancy);
        patty.addParent(jackie);
        ft.addChild("Clancy", selma);
        ft.addChild("Jackie", selma);
        ft.addChild("Clancy", patty);
        ft.addChild("Jackie", patty);

        return ft;
    }
}
