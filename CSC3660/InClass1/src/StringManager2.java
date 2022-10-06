public class StringManager2 {
    String[] inString;
    public StringManager2( String[] inString ){
        this.inString = inString;
    }
    public int numBornBefore( int inYear ){
        int count = 0;
        for(String actor : inString){
            String[] toks = actor.split(";");
            try {
                int bd = Integer.parseInt(toks[3]);
                if (bd <= inYear){
                    count++;
                }
            }catch (Exception e){
                System.out.printf("\nIllegal actor: %s", actor);
            }
        }
        return count;
    }
}
