public class DriverStringManager {
    public static void main(String[] args) {
//        String[] inString = {"Apples", "PeanutButter", "pinaclep"};
//        String[] inString = {};
        String[] inString = {"XXXX"};
        StringManager sm = new StringManager(inString);
        System.out.printf("\n Count: %s", sm.howManyOfThis('p'));
        String[] actors = new String[6];
        actors[0] = "Jerry;Sienfield;960;1954";
        actors[1] = "Tyler;Perry;600;1960";
        actors[2] = "Tom;Cruise;560;1962";
        actors[3] = "George;Clooney;500;1962";
        actors[4] = "Robert;DiNiro;500;1943";
        actors[5] = "John;Wayne;50;Western";
        StringManager sm2 = new StringManager(actors);
        System.out.printf("\n Count: %s", sm2.countOlderThan(1962));
    }
}
