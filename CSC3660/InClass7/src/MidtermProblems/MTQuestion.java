package MidtermProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MTQuestion {
    public static void main(String[] args) {
        HashMap< String, ArrayList<String>> carsColors = getCarsAndColors();
        String color = "Black";
        ArrayList<String> byColor = getCarsOfColor( carsColors, color);
        showOutput( byColor, color);
    }
    private static void showOutput(ArrayList<String> byColor, String color) {
        // Output the cars by color like the following:
        //These cars have color:Black
        //  Car:Tacoma
        //  Car:Encore
        //  Car:Camry
        //  Car:Accord
        //  Car:Corolla
        System.out.printf("\nThese cars have color: %s", color);
        for(String car : byColor){
            System.out.printf("\nCar: %s", car);
        }
    }
    private static ArrayList<String> getCarsOfColor(HashMap<String, ArrayList<String>> carsColors, String inColor) {
           // ToDo: Write this method that
          //        1. Compares inColor with the carsColors data structure
          //        Return: all cars that match the inColor color
          //        For Example,
          //               1.if inColor is "Green" it would return in the ArrayList of Tacoma
          //               2. If inColor is "Red" then return an arrayList of Camry, Accord
        ArrayList<String> cars = new ArrayList<>();
        for(String key : carsColors.keySet()){
            for(String color : carsColors.get(key)){
                if (color.equals(inColor)){
                    cars.add(key);
                }
            }
        }
        return cars;
    }
    private static HashMap<String,ArrayList<String>> getCarsAndColors() {
        HashMap<String, ArrayList<String>> carColors = new HashMap<>();
        ArrayList<String>  rbwb = new ArrayList<String>(Arrays.asList("Red", "Blue", "White", "Black"));
        carColors.put("Accord", rbwb );
        ArrayList<String>  bw = new ArrayList<String>(Arrays.asList("Black", "White"));
        carColors.put("Encore", bw);
        ArrayList<String>  brb = new ArrayList<String>(Arrays.asList("Blue", "Red", "Black"));
        carColors.put("Camry", bw);
        ArrayList<String>  br = new ArrayList<String>(Arrays.asList( "Red", "Green"));
        carColors.put("Tacoma", bw);
        ArrayList<String>  wbr = new ArrayList<String>(Arrays.asList("White", "Blue", "Red"));
        carColors.put("Corolla", bw);

        return carColors;
    }
}
