import java.util.ArrayList;
import java.util.Collections;

public class GreedyTask {
    public static void main(String[] args) {
        ArrayList<Task> myList = new ArrayList<>();
        myList.add(new Task("Paint Bedroom", 2));
        myList.add(new Task("Paint LivingRoom", 5));
        myList.add(new Task("Sweep Patio", 2));
        myList.add(new Task("Paint Basement", 1));
        myList.add(new Task("Paint Kitchen", 4));
        int time = 8;
        Collections.sort(myList);
        showTheList(myList);
        ArrayList<Task> toDoList = maxTasks(myList, time);
        System.out.printf("\n----------------------------");
        showTheList(toDoList);
    }

    private static ArrayList<Task> maxTasks(ArrayList<Task> myList, int time) {
        ArrayList<Task> maxTasks = new ArrayList<>();
        int currentTime = 0;
        for(Task t : myList){
            currentTime += t.getTime();
            if(currentTime >= time){
                break;
            }
            maxTasks.add(t);
        }
        return maxTasks;
    }

    private static void showTheList(ArrayList<Task> myList) {
        for(Task t : myList){
            System.out.printf("\nN: %s T: %s", t.gettName(), t.getTime());
        }
    }
}