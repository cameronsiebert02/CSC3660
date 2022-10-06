public class StringManager {
    private String[] myStringList;

    public StringManager(String[] myStringList) {
        this.myStringList = myStringList;
    }

    public int howManyOfThis(char inChar){
        int count = 0;
        for(String item : myStringList){
            for(int i = 0; i<item.length(); i++){
                if(item.charAt(i) == inChar){
                    count++;
                }
            }
        }
        return count;
    }
    public int countOlderThan(int inYear){
        int count = 0;
        for(String actor : myStringList){
            String[] toks = actor.split(";");
            try {
                int bd = Integer.parseInt(toks[3]);
                if (bd < inYear) {
                    count++;
                }
            }catch (Exception e){
                System.out.printf("\nIllegal line: %s", actor);
            }
        }
        return count;
    }
    public int numBornBefore( int inYear ){
        int count = 0;
        for(String actor : myStringList){
            String[] toks = actor.split(";");
            try {
                int bd = Integer.parseInt(toks[3]);
                if (bd < inYear){
                    count++;
                }
            }catch (Exception e){
                System.out.printf("\nIllegal actor: %s", actor);
            }
        }
        return count;
    }
    }