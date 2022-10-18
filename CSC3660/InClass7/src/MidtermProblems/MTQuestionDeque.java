package MidtermProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class MTQuestionDeque {
    public static void main(String[] args) {
        String myString = "AAABCCCDEEEFGAAAA";
        // ToDo: Write the following method
        StringBuilder revString = reverseStringNoDups(myString);
        // The expected output is
        // The String AAABCCCDEEEFGAAAA is GFEDCBA reversed without duplicate characters
        System.out.printf("\n The String %s is %s reversed without duplicates", myString, revString.toString());
    }

    private static StringBuilder reverseStringNoDups(String myString) {
        //Use a deque to reverse the order of the input string
        // Also remove duplicate characters as you place them
        // on the deque. (You can use an additional data structure if
        // needed.) Only use the deque as a stack (with the
        // stack methods).
        // Return a StringBuilder object with the solution.
        StringBuilder reverseString = new StringBuilder();
        Deque<Character> reverse = new ArrayDeque<>();
        LinkedHashSet<Character> noDupes = new LinkedHashSet<>();
        for(int i = 0; i < myString.length(); i++){
            noDupes.add(myString.charAt(i));
        }
        for(Character c : noDupes){
            reverse.push(c);
        }
        for (Character c : reverse){
            reverseString.append(c);
        }
        return reverseString;
    }
}

